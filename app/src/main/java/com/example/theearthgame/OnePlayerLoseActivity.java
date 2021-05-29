package com.example.theearthgame;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class OnePlayerLoseActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_one_player_lose);
        Intent intent = getIntent();
        String country = intent.getStringExtra("country");
        TextView lose = (TextView) findViewById(R.id.lose);
        lose.setText(String.format("You lose. The country was %s.", country));
    }

}
