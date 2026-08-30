package com.roblox.revival2014.ui;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.Button;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import com.roblox.revival2014.R;
import com.roblox.revival2014.adapter.MessageAdapter;
import com.roblox.revival2014.network.WebSocketClient;

public class ChatActivity extends AppCompatActivity {

    private EditText inputMessage;
    private Button btnSend;
    private ListView listMessages;
    private MessageAdapter messageAdapter;
    private WebSocketClient wsClient;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat);

        inputMessage = findViewById(R.id.input_message);
        btnSend = findViewById(R.id.btn_send);
        listMessages = findViewById(R.id.list_messages);

        messageAdapter = new MessageAdapter(this);
        listMessages.setAdapter(messageAdapter);

        // WebSocket para chat em tempo real
        wsClient = new WebSocketClient(this);
        wsClient.connect();

        btnSend.setOnClickListener(v -> {
            String message = inputMessage.getText().toString();
            if (!message.isEmpty()) {
                wsClient.sendMessage(message);
                inputMessage.setText("");
            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        wsClient.disconnect();
    }
}
