package com.endpoint;

import java.io.IOException;
import java.util.Collection;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

import javax.websocket.CloseReason;
import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;

import com.google.gson.Gson;

@ServerEndpoint("/FreshWhenVote/{userName}")
public class FreshWhenVote {
//	Set<Session> connectedSessions = Collections.synchronizedSet(new HashSet<>());
	private static Map<String, Session> sessionsMap = new ConcurrentHashMap<>();
	Gson gson = new Gson();

	@OnOpen //對應前端 onopen  // 前端透過可網址設定讓後端拿到參數
	public void onOpen(@PathParam("userName") String userName, Session userSession) throws IOException { 
//		System.out.println("WebSocket onOpen!!");
		// add new user name and session in the map
		sessionsMap.put(userName, userSession);
		// get all users name
		Set<String> userNames = sessionsMap.keySet();
	}

	@OnMessage            // 發送訊息的人的 session    JSON 字串
	public void onMessage(Session userSession, String message) {
//		System.out.println("WebSocket onmessage!!");
		
		Collection<Session> sessions = sessionsMap.values();
		for(Session session: sessions) {
			if(session.isOpen()) {
				session.getAsyncRemote().sendText("refresh!");
			}
		}
		return;
	}
	
	@OnClose
	public void onClose(Session userSession, CloseReason reason) { 
//		System.out.println("WebSocket closed!!");
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
	}

	@OnError
	public void onError(Session userSession, Throwable e) {
		System.out.println("Error: " + e.toString());
	}

}
