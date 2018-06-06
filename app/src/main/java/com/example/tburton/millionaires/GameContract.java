package com.example.tburton.millionaires;

import android.provider.BaseColumns;

// It's final to don't let change values in different places
public final class GameContract {

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
}
