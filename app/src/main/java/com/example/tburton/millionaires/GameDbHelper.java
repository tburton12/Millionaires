package com.example.tburton.millionaires;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.tburton.millionaires.GameContract.*;

public class GameDbHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "Millionaires.db";
    private static final int DATABASE_VERSION = 1;

    private SQLiteDatabase db;

    public GameDbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        this.db = db;

        /*
        public static final String TABLE_NAME = "questions";
        public static final String COLUMN_QUESTION = "question_text";
        public static final String COLUMN_STAGE = "question_stage"
        public static final String COLUMN_PRIZE = "prize"
        public static final String COLUMN_CORRECT_ANSWER_LETTER = "correct_answer_letter";
         */
        final String SQL_CREATE_QUESTIONS_TABLE = "CREATE TABLE " +
                QuestionsTable.TABLE_NAME + " ( " +
                QuestionsTable._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                QuestionsTable.COLUMN_QUESTION_TEXT + " TEXT, " +
                QuestionsTable.COLUMN_STAGE + " int, " +
                QuestionsTable.COLUMN_PRIZE + " int, " +
                QuestionsTable.COLUMN_CORRECT_ANSWER_LETTER + " CHAR" +
                ")";

        db.execSQL(SQL_CREATE_QUESTIONS_TABLE);

        /*
        public static class AnswersTable implements BaseColumns{
        public static final String TABLE_NAME = "answers";
        public static final String COLUMN_ANSWER_TEXT = "answer_text";
        public static final String QUESTION_ID = "question_ID";
        public static final String COLUMN_ANSWER_LETTER = "answer_letter";
    }
         */

        // TODO Add Foreign Key
        final String SQL_CREATE_ANSWERS_TABLE = "CREATE TABLE " +
                AnswersTable.TABLE_NAME + " ( " +
                AnswersTable._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                AnswersTable.COLUMN_ANSWER_TEXT + " TEXT, " +
                AnswersTable.QUESTION_ID + " int, " +
                AnswersTable.COLUMN_ANSWER_LETTER + " CHAR" +
                ")";

        db.execSQL(SQL_CREATE_ANSWERS_TABLE);

    //    fillQuestionsTable();
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + QuestionsTable.TABLE_NAME);
        onCreate(db);
    }

    // TODO Complete it: Add more real questions
    // TODO Call it
    // Values for questions table are hardcoded for now
    private void fillQuestionsTable() {
        ContentValues values = new ContentValues();
        values.put(QuestionsTable.COLUMN_QUESTION_TEXT, "Question text no. 1");
        values.put(QuestionsTable.COLUMN_STAGE, "1");
        values.put(QuestionsTable.COLUMN_PRIZE, "100");
        values.put(QuestionsTable.COLUMN_CORRECT_ANSWER_LETTER, "C");
        addQuestion(values);

    }

    /*
public static final String TABLE_NAME = "questions";
public static final String COLUMN_QUESTION = "question_text";
public static final String COLUMN_STAGE = "question_stage"
public static final String COLUMN_PRIZE = "prize"
public static final String COLUMN_CORRECT_ANSWER_LETTER = "correct_answer_letter";
 */

    private void addQuestion(ContentValues values) {
        db.insert(QuestionsTable.TABLE_NAME, null, values);
    }

    // TODO fillAnswersTable function

    // TODO addAnswer function
}
