package com.example.tburton.millionaires;

import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

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
    private ColorStateList defaultTextColor;

    private List<Question> questionList;

    private int questionCurrentStage;
    private int questionTotalStages = 8;    // number of stages in real TV Show
    private Question currentQuestion;

    private int credits;
    private boolean answered;
    private boolean gameLost = false;

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

        defaultTextColor = rb1.getTextColors();

        GameDbHelper dbHelper = new GameDbHelper(this);
        questionList = dbHelper.getAllQuestionsAndAnswersFromDatabase();

        showNextQuestion();

        buttonConfirmNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!answered) {
                    if (rb1.isChecked() || rb2.isChecked() || rb3.isChecked()) {
                        checkAnswer();
                    } else {
                        Toast.makeText(GameActivity.this, "You need to select an answer!", Toast.LENGTH_LONG).show();
                    }
                } else {
                    if(!gameLost) {
                        showNextQuestion();
                    }   else    {
                        Intent intent = new Intent(GameActivity.this, GameLost.class);

                        Bundle extras = new Bundle();
                        extras.putInt("creditsGained", credits);
                        intent.putExtras(extras);

                        startActivity(intent);

                        finishGame();
                    }
                }
            }
        });

    }

    private void showNextQuestion() {
        rbGroup.clearCheck();

        if (questionCurrentStage < questionTotalStages) {
            currentQuestion = questionList.get(questionCurrentStage);

            textViewQuestion.setText(currentQuestion.getQuestion_text());
            rb1.setText(currentQuestion.getOptionA());
            rb2.setText(currentQuestion.getOptionB());
            rb3.setText(currentQuestion.getOptionC());

            rb1.setTextColor(defaultTextColor);
            rb2.setTextColor((defaultTextColor));
            rb3.setTextColor((defaultTextColor));

            questionCurrentStage++;
            textViewStage.setText("Stage: " + questionCurrentStage + "/" + questionTotalStages);
            answered = false;
            buttonConfirmNext.setText("Confirm");
        } else {
            Intent intent = new Intent(GameActivity.this, GameWon.class);
            startActivity(intent);
            finishGame();
        }
    }

    private void checkAnswer() {
        answered = true;

        RadioButton rbSelected = findViewById(rbGroup.getCheckedRadioButtonId());

        String selectedAnswer = "A";    // temporary value

        switch(rbGroup.indexOfChild(rbSelected) + 1){
            case 1:
                selectedAnswer = "A";
                break;
            case 2:
                selectedAnswer = "B";
                break;
            case 3:
                selectedAnswer = "C";
                break;
        }

        // if selected answer is correct
        if (selectedAnswer.equals(currentQuestion.getCorrect_answer_letter())) {
            credits = currentQuestion.getQuestion_prize();
            textViewCredits.setText("Credits: " + credits + "$");
            showSolution();
        }   else    {
            gameLost = true;
            Toast.makeText(GameActivity.this, "Wrong answer!", Toast.LENGTH_LONG).show();
            showSolution();
        }

    }

    private void showSolution(){
        rb1.setTextColor(Color.RED);
        rb2.setTextColor((Color.RED));
        rb3.setTextColor((Color.RED));

        switch (currentQuestion.getCorrect_answer_letter()) {
            case "A":
                rb1.setTextColor((Color.GREEN));
                break;
            case "B":
                rb2.setTextColor((Color.GREEN));
                break;
            case "C":
                rb3.setTextColor((Color.GREEN));
                break;
        }

        if (questionCurrentStage < questionTotalStages) {
            if(gameLost == false) {
                buttonConfirmNext.setText("Next");
            }   else    {
                buttonConfirmNext.setText("Finish");
            }
        } else {
            buttonConfirmNext.setText("Finish");
        }
    }

    private void finishGame(){
        finish();
    }
}
