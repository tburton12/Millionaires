package com.example.tburton.millionaires;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class GameWon extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_won);

        TextView textViewCredits;
        textViewCredits = findViewById(R.id.text_view_credits);
        textViewCredits.setText("1.000.000 $");

        Button buttonFinishGame = findViewById(R.id.button_confirm_finish);
        buttonFinishGame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finishGame();
            }
        });

    }

    private void finishGame() {
        Intent intent = new Intent(GameWon.this, StartingScreenActivity.class);
        startActivity(intent);
    }
}
