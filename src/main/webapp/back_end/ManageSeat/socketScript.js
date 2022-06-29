let MyPoint = "/WebSocket_server/backend_user";
let host = window.location.host;
let path = window.location.pathname;
let webCtx = path.substring(0, path.indexOf('/', 1));
let endPointURL = "ws://" + window.location.host + webCtx + MyPoint;
						//串接起來=> ws://localhost:8081/CGA102G1/WebSocket_server/backend_user

	let webSocket;

	function connect() {
		webSocket = new WebSocket(endPointURL);
		
		webSocket.onopen = function(event) {
		};
		// 此處收到來自server的session.getAsyncRemote().sendText(message);
		webSocket.onmessage = function(event) {
			
			// 用事件.data拿到後端送來的文字資料 轉回json物件
			let jsonObj = JSON.parse(event.data);
			// 調出 username : message
			let message = jsonObj.message;
			
			document.getElementById("showSeatSource").value=message;
			
			generateSeat();
		};

		webSocket.onclose = function(event) {
		};
	}
	connect();
	
	function sendMessage() {
		let message = document.getElementById('showSeatSource').value

			var jsonObj = {
				"message" : message
			};
			// JSON API 轉成文字 送到SERVER 清空欄位 focus
			webSocket.send(JSON.stringify(jsonObj));
			
	}

	function disconnect() {
		webSocket.close();
	}