package com.roblox.revival2014.ui;

import android.os.Bundle;
import android.widget.TextView;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import com.roblox.revival2014.R;

public class ProfileActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        TextView tvUsername = findViewById(R.id.tv_username);
        TextView tvLevel = findViewById(R.id.tv_level);
        ImageView ivAvatar = findViewById(R.id.iv_avatar);

        // Dados do usuário (substituir com dados reais do servidor)
        tvUsername.setText("Player123");
        tvLevel.setText("Level: 25");
    }
}
