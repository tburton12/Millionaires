package com.example.tburton.millionaires;

/*
 public static class QuestionsTable implements BaseColumns{
        public static final String TABLE_NAME = "questions";
        public static final String COLUMN_QUESTION_TEXT = "question_text";
        public static final String COLUMN_STAGE = "question_stage";
        public static final String COLUMN_PRIZE = "question_prize";
        public static final String COLUMN_CORRECT_ANSWER_LETTER = "correct_answer_letter";
    }

    public static class AnswersTable implements BaseColumns{
        public static final String TABLE_NAME = "answers";
        public static final String COLUMN_ANSWER_TEXT = "answer_text";
        public static final String QUESTION_ID = "question_ID";
        public static final String COLUMN_ANSWER_LETTER = "answer_letter";
    }
 */

public class Question {
    private String question_text;
    private int question_stage;
    private int question_prize;
    private String optionA;
    private String optionB;
    private String optionC;
    private String correct_answer_letter;

    public Question(){
    }

    public Question(String question_text, int question_stage, int question_prize, String optionA, String optionB, String optionC, String correct_answer_letter) {
        this.question_text = question_text;
        this.question_stage = question_stage;
        this.question_prize = question_prize;
        this.optionA = optionA;
        this.optionB = optionB;
        this.optionC = optionC;
        this.correct_answer_letter = correct_answer_letter;
    }

    public String getQuestion_text() {
        return question_text;
    }

    public void setQuestion_text(String question_text) {
        this.question_text = question_text;
    }

    public int getQuestion_stage() {
        return question_stage;
    }

    public void setQuestion_stage(int question_stage) {
        this.question_stage = question_stage;
    }

    public int getQuestion_prize() {
        return question_prize;
    }

    public void setQuestion_prize(int question_prize) {
        this.question_prize = question_prize;
    }

    public String getOptionA() {
        return optionA;
    }

    public void setOptionA(String optionA) {
        this.optionA = optionA;
    }

    public String getOptionB() {
        return optionB;
    }

    public void setOptionB(String optionB) {
        this.optionB = optionB;
    }

    public String getOptionC() {
        return optionC;
    }

    public void setOptionC(String optionC) {
        this.optionC = optionC;
    }

    public String getCorrect_answer_letter() {
        return correct_answer_letter;
    }

    public void setCorrect_answer_letter(String correct_answer_letter) {
        this.correct_answer_letter = correct_answer_letter;
    }
}
