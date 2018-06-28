package com.example.tburton.millionaires;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class GameLost extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_lost);

        Intent intent = getIntent();

        int creditsGained = intent.getIntExtra("creditsGained", 0);
        String creditsWon = "0";

        if(creditsGained >= 1000){
            creditsWon = "1.000";
            if(creditsGained >= 32000){
                creditsWon = "32.000";
            }
        }

        TextView textViewCredits;
        textViewCredits = findViewById(R.id.text_view_credits);

        textViewCredits.setText("Your guaranteed prize:\n" + creditsWon + "$");

        Button buttonFinishGame = findViewById(R.id.button_confirm_finish);

        buttonFinishGame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finishGame();
            }
        });
    }

    private void finishGame() {
        Intent intent = new Intent(GameLost.this, StartingScreenActivity.class);
        startActivity(intent);
    }
}
