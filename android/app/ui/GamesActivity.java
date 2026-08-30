package com.roblox.revival2014.ui;

import android.os.Bundle;
import android.widget.GridView;

import androidx.appcompat.app.AppCompatActivity;

import com.roblox.revival2014.R;
import com.roblox.revival2014.adapter.GameAdapter;

public class GamesActivity extends AppCompatActivity {

    private GridView gridGames;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_games);

        gridGames = findViewById(R.id.grid_games);
        GameAdapter adapter = new GameAdapter(this);
        gridGames.setAdapter(adapter);
    }
}
