package com.example.theearthgame;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class TwoPlayerWinActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_two_player_win);
        Intent intent = getIntent();
        String name = intent.getStringExtra("name");
        TextView winMessage = (TextView) findViewById(R.id.win);
        winMessage.setText(String.format("%s WINS!", name));
    }

}
