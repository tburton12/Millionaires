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

        TextView textViewCredits;
        textViewCredits = findViewById(R.id.text_view_credits);
        textViewCredits.setText("1.000.000 $");

        Button buttonFinishGame = findViewById(R.id.button_confirm_finish);

        // TODO: if won money then set value, else left empty
        if(true) {
            buttonFinishGame.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    finishGame();
                }
            });
        }
    }

    private void finishGame() {
        Intent intent = new Intent(GameLost.this, StartingScreenActivity.class);
        startActivity(intent);
    }
}
