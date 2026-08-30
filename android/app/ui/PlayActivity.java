package com.roblox.revival2014.ui;

import android.os.Bundle;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import com.roblox.revival2014.R;
import com.roblox.revival2014.adapter.ServerAdapter;

public class PlayActivity extends AppCompatActivity {

    private ListView listServers;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play);

        listServers = findViewById(R.id.list_servers);

        // Adapter para servidores
        ServerAdapter adapter = new ServerAdapter(this);
        listServers.setAdapter(adapter);
    }
}
