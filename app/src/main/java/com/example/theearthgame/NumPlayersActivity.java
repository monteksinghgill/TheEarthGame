package com.example.theearthgame;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class NumPlayersActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_num_players);
    }

    public void onOnePlayerClick(View view) {
        Intent intent = new Intent(this, OnePlayerQuestionsActivity.class);
        startActivity(intent);
    }

    public void onTwoPlayerClick(View view) {
        Intent intent = new Intent(this, PlayerNamesActivity.class);
        startActivity(intent);
    }

}
