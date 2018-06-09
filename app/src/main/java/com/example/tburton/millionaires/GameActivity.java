package com.example.tburton.millionaires;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import java.util.List;

public class GameActivity extends AppCompatActivity {
    private TextView textViewQuestion;
    private TextView textViewCredits;
    private TextView textViewStage;
    private RadioGroup rbGroup;
    private RadioButton rb1;
    private RadioButton rb2;
    private RadioButton rb3;
    private Button buttonConfirmNext;

    private List<Question> questionList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        textViewQuestion = findViewById(R.id.text_view_question);
        textViewCredits = findViewById(R.id.text_view_credits);
        textViewStage = findViewById(R.id.text_view_stage);
        rbGroup = findViewById(R.id.radio_group);
        rb1 = findViewById(R.id.radio_button1);
        rb2 = findViewById(R.id.radio_button2);
        rb3 = findViewById(R.id.radio_button3);
        buttonConfirmNext = findViewById(R.id.button_confirm_next);

        GameDbHelper dbHelper = new GameDbHelper(this);
        questionList = dbHelper.getAllQuestionsAndAnswersFromDatabase();
    }
}
