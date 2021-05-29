package com.example.theearthgame;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class PlayerNamesActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_player_names);
    }

    public void onSubmitClick(View view) {
        Intent intent = new Intent(this, TwoPlayerQuestionsActivity.class);
        EditText p1View = (EditText) findViewById(R.id.editp1name);
        EditText p2View = (EditText) findViewById(R.id.editp2name);
        String p1name = p1View.getText().toString();
        String p2name = p2View.getText().toString();
        intent.putExtra("p1name", p1name);
        intent.putExtra("p2name", p2name);
        startActivity(intent);
    }

}
