package com.endpoint;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.ConcurrentHashMap;

import javax.websocket.CloseReason;
import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;

import com.common.JedisPoolUtil;
import com.google.gson.Gson;
import com.wishing_pond.model.WishingNotifyPOJO;

import redis.clients.jedis.Jedis;

@ServerEndpoint("/FreshWhenVote/{userName}")
public class FreshWhenVote {
//	Set<Session> connectedSessions = Collections.synchronizedSet(new HashSet<>());
	private static Map<String, Session> sessionsMap = new ConcurrentHashMap<>();
	Gson gson = new Gson();
	private Timer timer = null; // 可以共用?

	@OnOpen //對應前端 onopen  // 前端透過可網址設定讓後端拿到參數
	public void onOpen(@PathParam("userName") String userName, Session userSession) throws IOException { 
		System.out.println("WebSocket onOpen!!");
		// add new user name and session in the map
		sessionsMap.put(userName, userSession);
		// get all users name
		Set<String> userNames = sessionsMap.keySet();
		Integer memId = Integer.valueOf(userName.substring(8));
		
		// 定期驅動刷新
		long now = System.currentTimeMillis();
		if(timer == null) { 
			// 開啟 Timer
	    	timer = new Timer();
	    	TimerTask task = new TimerTask() {
				@Override
				public void run() {
					// 避免 onopen 時，timer 造成 websocket exception 
					// The remote endpoint was in state [TEXT_PARTIAL_WRITING] which is an invalid stat
					if(scheduledExecutionTime() > now && userSession.isOpen()) { 
						Jedis jedis = JedisPoolUtil.getJedisPool().getResource();
						List<String> historyMsg = jedis.lrange("msg:member:" + memId, 0, -1);
						userSession.getAsyncRemote().sendText(gson.toJson(historyMsg, List.class));
						if(jedis != null) {
							jedis.close();
						}
					}
				}
	    	};
	    	// 指定日期
	    	Calendar cal = new GregorianCalendar(2022, Calendar.JULY, 5, 14, 39, 0);
	    	timer.scheduleAtFixedRate(task, cal.getTime(), 10 * 1000);
		}
	}

	@OnMessage            // 發送訊息的人的 session    JSON 字串
	public void onMessage(Session userSession, String message) {
		System.out.println(message);
		System.out.println("WebSocket onmessage!!");
		String action = message.substring(0, 6);
		Collection<Session> sessions = sessionsMap.values();
		// 投票驅動刷新
		if("refresh".equals(message)) {
			for(Session session: sessions) {
				if(session.isOpen()) {
					session.getAsyncRemote().sendText("refresh");
				}
			}
			return;
		}
		if("giveme".equals(action)) {
			Integer memId = Integer.valueOf(message.substring(6));
			Jedis jedis = JedisPoolUtil.getJedisPool().getResource();
			List<String> historyMsg = jedis.lrange("msg:member:" + memId, 0, -1);
			userSession.getAsyncRemote().sendText(gson.toJson(historyMsg, List.class));
			if(jedis != null) {
				jedis.close();
			}
			return;
		}
		if("update".equals(action)) {
			System.out.println("this");
			Integer memId = Integer.valueOf(message.substring(6));
			Jedis jedis = JedisPoolUtil.getJedisPool().getResource();
			List<String> historyMsg = jedis.lrange("msg:member:" + memId, 0, -1);
			List<WishingNotifyPOJO> changeStatus = new ArrayList<WishingNotifyPOJO>();
			// 將資料從 Redis 撈出來，修改每一筆訊息的狀態
			for(String msg: historyMsg) {
				WishingNotifyPOJO notifyPOJO = gson.fromJson(msg, WishingNotifyPOJO.class);
				notifyPOJO.setStatus(1);
				changeStatus.add(notifyPOJO);
			}
			// 再將資料轉回 JSON 格式存回 Redis
			for(WishingNotifyPOJO notifyPOJO: changeStatus) {
				String msg = gson.toJson(notifyPOJO, WishingNotifyPOJO.class);
				jedis.rpush("msg:member:" + memId, msg);
				while(jedis.llen("msg:member:" + memId) > 10) {
					jedis.lpop("msg:member:" + memId);
				}
			}
			if(jedis != null) {
				jedis.close();
			}
			return;
		}
	}
	
	@OnClose
	public void onClose(Session userSession, CloseReason reason) { 
		System.out.println("WebSocket closed!!");
		String userNameClose = null;
		Set<String> userNames = sessionsMap.keySet();
		for(String userName: userNames) {
			if(sessionsMap.get(userName).equals(userSession)) {
				userNameClose = userName;
				sessionsMap.remove(userName);
				break;
			}
		}
		
		String text = String.format("session ID = %s, disconnected; close code = %d; reason phrase = %s",
				userSession.getId(), reason.getCloseCode().getCode(), reason.getReasonPhrase());
//		System.out.println(text);
		timer.cancel();
	}

	@OnError
	public void onError(Session userSession, Throwable e) {
		System.out.println("Error: " + e.toString());
	}

}
