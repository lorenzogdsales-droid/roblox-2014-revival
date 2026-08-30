package com.roblox.revival2014;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import com.roblox.revival2014.ui.PlayActivity;
import com.roblox.revival2014.ui.GamesActivity;
import com.roblox.revival2014.ui.ProfileActivity;
import com.roblox.revival2014.ui.ChatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Logo Roblox Azul 2014
        ImageView logoRoblox = findViewById(R.id.logo_roblox);
        logoRoblox.setImageResource(R.drawable.roblox_logo_2014);

        // Botões de Navegação
        Button btnPlay = findViewById(R.id.btn_play);
        Button btnGames = findViewById(R.id.btn_games);
        Button btnProfile = findViewById(R.id.btn_profile);
        Button btnChat = findViewById(R.id.btn_chat);

        btnPlay.setOnClickListener(v -> startActivity(new Intent(this, PlayActivity.class)));
        btnGames.setOnClickListener(v -> startActivity(new Intent(this, GamesActivity.class)));
        btnProfile.setOnClickListener(v -> startActivity(new Intent(this, ProfileActivity.class)));
        btnChat.setOnClickListener(v -> startActivity(new Intent(this, ChatActivity.class)));
    }
}
