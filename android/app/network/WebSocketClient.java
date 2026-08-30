package com.roblox.revival2014.network;

import android.content.Context;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.WebSocket;
import okhttp3.WebSocketListener;

public class WebSocketClient extends WebSocketListener {

    private WebSocket webSocket;
    private Context context;
    private static final String WS_URL = "ws://seu-servidor.com:8080";

    public WebSocketClient(Context context) {
        this.context = context;
    }

    public void connect() {
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .url(WS_URL)
                .build();
        webSocket = client.newWebSocket(request, this);
    }

    public void sendMessage(String message) {
        if (webSocket != null) {
            webSocket.send(message);
        }
    }

    @Override
    public void onMessage(WebSocket webSocket, String text) {
        // Processar mensagens recebidas
    }

    public void disconnect() {
        if (webSocket != null) {
            webSocket.close(1000, "Closing");
        }
    }
}
