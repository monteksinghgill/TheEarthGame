package com.example.theearthgame;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import java.util.Random;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class OnePlayerQuestionsActivity extends Activity {
    private String[] countries = new String[0];
    private String[] country_facts = new String [0];
    private String country = "";
    private int hints_start_index;
    private int hint_num;
    private String hints_to_display = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_one_player_questions);
        if (savedInstanceState != null) {
            countries = savedInstanceState.getStringArray("countries");
            country_facts = savedInstanceState.getStringArray("country_facts");
            country = savedInstanceState.getString("country");
            hints_start_index = savedInstanceState.getInt("hints_start_index");
            hint_num = savedInstanceState.getInt("hint_num");
            hints_to_display = savedInstanceState.getString("hints_to_display");
        }

        if (countries.length == 0) {
            countries = getResources().getStringArray(R.array.countries);
        }
        if (country_facts.length == 0) {
            country_facts = getResources().getStringArray(R.array.country_facts);
        }
        if (country.length() == 0) {
            Random rand = new Random();
            int country_num = rand.nextInt(8);
            country = countries[country_num];
            hints_start_index = 10*country_num;
            hint_num = 0;
        }

        setHint();
    }

    public void onGuessClick(View view) {
        EditText guess_view = (EditText) findViewById(R.id.guesstext);
        String guess_text = guess_view.getText().toString().toLowerCase();
        if (guess_text.equals(country.toLowerCase())) {
            Intent intent = new Intent(this, OnePlayerWinActivity.class);
            startActivity(intent);
        }
        else if (hint_num == 9) {
            Intent intent = new Intent(this, OnePlayerLoseActivity.class);
            intent.putExtra("country", country);
            startActivity(intent);
        }
        else {
            hint_num += 1;
            setHint();
        }
    }

    public void onNextHintClick(View view) {
        if (hint_num < 9) {
            hint_num += 1;
            setHint();
        }
    }

    private void setHint() {
        TextView[] hintViewArray = new TextView[10];
        hintViewArray[0] = (TextView) findViewById(R.id.hint1);
        hintViewArray[1] = (TextView) findViewById(R.id.hint2);
        hintViewArray[2] = (TextView) findViewById(R.id.hint3);
        hintViewArray[3] = (TextView) findViewById(R.id.hint4);
        hintViewArray[4] = (TextView) findViewById(R.id.hint5);
        hintViewArray[5] = (TextView) findViewById(R.id.hint6);
        hintViewArray[6] = (TextView) findViewById(R.id.hint7);
        hintViewArray[7] = (TextView) findViewById(R.id.hint8);
        hintViewArray[8] = (TextView) findViewById(R.id.hint9);
        hintViewArray[9] = (TextView) findViewById(R.id.hint10);
        for (int i = 0; i <= hint_num; i++) {
            hintViewArray[i].setText(String.format("%d. %s", i + 1, country_facts[hints_start_index + i]));
        }
    }

    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {
        savedInstanceState.putStringArray("countries", countries);
        savedInstanceState.putStringArray("country_facts", country_facts);
        savedInstanceState.putString("country", country);
        savedInstanceState.putInt("hints_start_index", hints_start_index);
        savedInstanceState.putInt("hint_num", hint_num);
        savedInstanceState.putString("hints_to_display", hints_to_display);
    }
}