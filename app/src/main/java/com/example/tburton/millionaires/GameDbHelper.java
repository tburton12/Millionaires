package com.example.tburton.millionaires;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.tburton.millionaires.GameContract.*;

import java.util.ArrayList;
import java.util.List;

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

        final String SQL_CREATE_QUESTIONS_TABLE = "CREATE TABLE " +
                QuestionsTable.TABLE_NAME + " ( " +
                QuestionsTable._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                QuestionsTable.COLUMN_QUESTION_TEXT + " TEXT, " +
                QuestionsTable.COLUMN_STAGE + " int, " +
                QuestionsTable.COLUMN_PRIZE + " int, " +
                QuestionsTable.COLUMN_CORRECT_ANSWER_LETTER + " CHAR" +
                ")";

        db.execSQL(SQL_CREATE_QUESTIONS_TABLE);

        final String SQL_CREATE_ANSWERS_TABLE = "CREATE TABLE " +
                AnswersTable.TABLE_NAME + " ( " +
                AnswersTable._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                AnswersTable.COLUMN_ANSWER_TEXT + " TEXT, " +
                AnswersTable.QUESTION_ID + " int, " +
                AnswersTable.COLUMN_ANSWER_LETTER + " CHAR, " +
                "FOREIGN KEY (" + AnswersTable.QUESTION_ID + ") " +
                "REFERENCES " + QuestionsTable.TABLE_NAME + " (" + QuestionsTable._ID + ")" +
                ")";

        db.execSQL(SQL_CREATE_ANSWERS_TABLE);

        fillQuestionsTable();
        fillAnswersTable();
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + QuestionsTable.TABLE_NAME);
        onCreate(db);
    }

    // Values for questions table are hardcoded for now
    private void fillQuestionsTable() {
        ContentValues values = new ContentValues();
        values.put(QuestionsTable.COLUMN_QUESTION_TEXT, "At	any	one	time, what percentage of 5 to 16 year olds in the UK have a mental health problem?");
        values.put(QuestionsTable.COLUMN_STAGE, "1");
        values.put(QuestionsTable.COLUMN_PRIZE, "100");
        values.put(QuestionsTable.COLUMN_CORRECT_ANSWER_LETTER, "B");
        addQuestion(values);
        values.clear();     // Not sure

        values.put(QuestionsTable.COLUMN_QUESTION_TEXT, "How many teenagers are believed to self-harm in the UK?");
        values.put(QuestionsTable.COLUMN_STAGE, "2");
        values.put(QuestionsTable.COLUMN_PRIZE, "500");
        values.put(QuestionsTable.COLUMN_CORRECT_ANSWER_LETTER, "A");
        addQuestion(values);
        values.clear();     // Not sure

        values.put(QuestionsTable.COLUMN_QUESTION_TEXT, "Which of these symptoms can happen if you’re depressed?");
        values.put(QuestionsTable.COLUMN_STAGE, "3");
        values.put(QuestionsTable.COLUMN_PRIZE, "1000");
        values.put(QuestionsTable.COLUMN_CORRECT_ANSWER_LETTER, "C");
        addQuestion(values);
        values.clear();     // Not sure

        values.put(QuestionsTable.COLUMN_QUESTION_TEXT, "Which of these are possible triggers for a psychotic episode?");
        values.put(QuestionsTable.COLUMN_STAGE, "4");
        values.put(QuestionsTable.COLUMN_PRIZE, "16000");
        values.put(QuestionsTable.COLUMN_CORRECT_ANSWER_LETTER, "A");
        addQuestion(values);
        values.clear();     // Not sure

        values.put(QuestionsTable.COLUMN_QUESTION_TEXT, "How many murders are committed in England & Wales in one year by people judged to be mentally ill?");
        values.put(QuestionsTable.COLUMN_STAGE, "5");
        values.put(QuestionsTable.COLUMN_PRIZE, "32000");
        values.put(QuestionsTable.COLUMN_CORRECT_ANSWER_LETTER, "C");
        addQuestion(values);
        values.clear();     // Not sure

        values.put(QuestionsTable.COLUMN_QUESTION_TEXT, "It is estimated that since 1985 suicide attempts by young men have…");
        values.put(QuestionsTable.COLUMN_STAGE, "6");
        values.put(QuestionsTable.COLUMN_PRIZE, "64000");
        values.put(QuestionsTable.COLUMN_CORRECT_ANSWER_LETTER, "B");
        addQuestion(values);
        values.clear();     // Not sure

        values.put(QuestionsTable.COLUMN_QUESTION_TEXT, "Which of the following people has experienced serious mental health problems?");
        values.put(QuestionsTable.COLUMN_STAGE, "7");
        values.put(QuestionsTable.COLUMN_PRIZE, "500000");
        values.put(QuestionsTable.COLUMN_CORRECT_ANSWER_LETTER, "C");
        addQuestion(values);
        values.clear();     // Not sure

        values.put(QuestionsTable.COLUMN_QUESTION_TEXT, "Which of the following are considered to be real medical conditions?");
        values.put(QuestionsTable.COLUMN_STAGE, "8");
        values.put(QuestionsTable.COLUMN_PRIZE, "1000000");
        values.put(QuestionsTable.COLUMN_CORRECT_ANSWER_LETTER, "C");
        addQuestion(values);
        values.clear();     // Not sure

    }

    private void addQuestion(ContentValues values) {
        db.insert(QuestionsTable.TABLE_NAME, null, values);
    }

    // Values for answers table are hardcoded for now
    private void fillAnswersTable() {
        ContentValues values = new ContentValues();

        // Question no. 1
        values.put(AnswersTable.COLUMN_ANSWER_TEXT, "5%");
        values.put(AnswersTable.QUESTION_ID, "1");
        values.put(AnswersTable.COLUMN_ANSWER_LETTER, "A");
        addAnswer(values);
        values.clear();     // Not sure

        values.put(AnswersTable.COLUMN_ANSWER_TEXT, "10%");
        values.put(AnswersTable.QUESTION_ID, "1");
        values.put(AnswersTable.COLUMN_ANSWER_LETTER, "B");
        addAnswer(values);
        values.clear();

        values.put(AnswersTable.COLUMN_ANSWER_TEXT, "20%");
        values.put(AnswersTable.QUESTION_ID, "1");
        values.put(AnswersTable.COLUMN_ANSWER_LETTER, "C");
        addAnswer(values);
        values.clear();

        // Question no. 2
        values.put(AnswersTable.COLUMN_ANSWER_TEXT, "1 in 15");
        values.put(AnswersTable.QUESTION_ID, "2");
        values.put(AnswersTable.COLUMN_ANSWER_LETTER, "A");
        addAnswer(values);
        values.clear();

        values.put(AnswersTable.COLUMN_ANSWER_TEXT, "1 in 30");
        values.put(AnswersTable.QUESTION_ID, "2");
        values.put(AnswersTable.COLUMN_ANSWER_LETTER, "B");
        addAnswer(values);
        values.clear();

        values.put(AnswersTable.COLUMN_ANSWER_TEXT, "1 in 50");
        values.put(AnswersTable.QUESTION_ID, "2");
        values.put(AnswersTable.COLUMN_ANSWER_LETTER, "C");
        addAnswer(values);
        values.clear();

        // Question no. 3
        values.put(AnswersTable.COLUMN_ANSWER_TEXT, "Don't feel hungry");
        values.put(AnswersTable.QUESTION_ID, "3");
        values.put(AnswersTable.COLUMN_ANSWER_LETTER, "A");
        addAnswer(values);
        values.clear();

        values.put(AnswersTable.COLUMN_ANSWER_TEXT, "Hungry all the time");
        values.put(AnswersTable.QUESTION_ID, "3");
        values.put(AnswersTable.COLUMN_ANSWER_LETTER, "B");
        addAnswer(values);
        values.clear();

        values.put(AnswersTable.COLUMN_ANSWER_TEXT, "Both are correct");
        values.put(AnswersTable.QUESTION_ID, "3");
        values.put(AnswersTable.COLUMN_ANSWER_LETTER, "C");
        addAnswer(values);
        values.clear();

        // Question no. 4
        values.put(AnswersTable.COLUMN_ANSWER_TEXT, "Taking drugs");
        values.put(AnswersTable.QUESTION_ID, "4");
        values.put(AnswersTable.COLUMN_ANSWER_LETTER, "A");
        addAnswer(values);
        values.clear();

        values.put(AnswersTable.COLUMN_ANSWER_TEXT, "Going to school");
        values.put(AnswersTable.QUESTION_ID, "4");
        values.put(AnswersTable.COLUMN_ANSWER_LETTER, "B");
        addAnswer(values);
        values.clear();

        values.put(AnswersTable.COLUMN_ANSWER_TEXT, "Going shopping");
        values.put(AnswersTable.QUESTION_ID, "4");
        values.put(AnswersTable.COLUMN_ANSWER_LETTER, "C");
        addAnswer(values);
        values.clear();

        // Question no. 5
        values.put(AnswersTable.COLUMN_ANSWER_TEXT, "1555");
        values.put(AnswersTable.QUESTION_ID, "5");
        values.put(AnswersTable.COLUMN_ANSWER_LETTER, "A");
        addAnswer(values);
        values.clear();

        values.put(AnswersTable.COLUMN_ANSWER_TEXT, "555");
        values.put(AnswersTable.QUESTION_ID, "5");
        values.put(AnswersTable.COLUMN_ANSWER_LETTER, "B");
        addAnswer(values);
        values.clear();

        values.put(AnswersTable.COLUMN_ANSWER_TEXT, "55");
        values.put(AnswersTable.QUESTION_ID, "5");
        values.put(AnswersTable.COLUMN_ANSWER_LETTER, "C");
        addAnswer(values);
        values.clear();

        // Question no. 6
        values.put(AnswersTable.COLUMN_ANSWER_TEXT, "Stayed the same");
        values.put(AnswersTable.QUESTION_ID, "6");
        values.put(AnswersTable.COLUMN_ANSWER_LETTER, "A");
        addAnswer(values);
        values.clear();

        values.put(AnswersTable.COLUMN_ANSWER_TEXT, "Risen by 170%");
        values.put(AnswersTable.QUESTION_ID, "6");
        values.put(AnswersTable.COLUMN_ANSWER_LETTER, "B");
        addAnswer(values);
        values.clear();

        values.put(AnswersTable.COLUMN_ANSWER_TEXT, "Risen by 70%");
        values.put(AnswersTable.QUESTION_ID, "6");
        values.put(AnswersTable.COLUMN_ANSWER_LETTER, "C");
        addAnswer(values);
        values.clear();

        // Question no. 7
        values.put(AnswersTable.COLUMN_ANSWER_TEXT, "J K Rowling");
        values.put(AnswersTable.QUESTION_ID, "7");
        values.put(AnswersTable.COLUMN_ANSWER_LETTER, "A");
        addAnswer(values);
        values.clear();

        values.put(AnswersTable.COLUMN_ANSWER_TEXT, "Robbie Williams");
        values.put(AnswersTable.QUESTION_ID, "7");
        values.put(AnswersTable.COLUMN_ANSWER_LETTER, "B");
        addAnswer(values);
        values.clear();

        values.put(AnswersTable.COLUMN_ANSWER_TEXT, "Both of them");
        values.put(AnswersTable.QUESTION_ID, "7");
        values.put(AnswersTable.COLUMN_ANSWER_LETTER, "C");
        addAnswer(values);
        values.clear();

        // Question no. 8
        values.put(AnswersTable.COLUMN_ANSWER_TEXT, "Diabetes");
        values.put(AnswersTable.QUESTION_ID, "8");
        values.put(AnswersTable.COLUMN_ANSWER_LETTER, "A");
        addAnswer(values);
        values.clear();

        values.put(AnswersTable.COLUMN_ANSWER_TEXT, "Anxiety disorders");
        values.put(AnswersTable.QUESTION_ID, "8");
        values.put(AnswersTable.COLUMN_ANSWER_LETTER, "B");
        addAnswer(values);
        values.clear();

        values.put(AnswersTable.COLUMN_ANSWER_TEXT, "Both of them");
        values.put(AnswersTable.QUESTION_ID, "8");
        values.put(AnswersTable.COLUMN_ANSWER_LETTER, "C");
        addAnswer(values);
        values.clear();
    }

    private void addAnswer(ContentValues values) {
        db.insert(AnswersTable.TABLE_NAME, null, values);
    }

    /*
    SELECT
	q.question_text,
	q.question_stage,
	q.question_prize,
	q.correct_answer_letter,

	-- optionA
	(SELECT a1.answer_text
		FROM answers a1
		WHERE a1.question_ID = q.ID
		AND a1.answer_letter = 'A'
	) AS optionA,

	-- optionB
	(SELECT a1.answer_text
		FROM answers a1
		WHERE a1.question_ID = q.ID
		AND a1.answer_letter = 'B'
	) AS optionB,

	-- optionC
	(SELECT a1.answer_text
		FROM answers a1
		WHERE a1.question_ID = q.ID
		AND a1.answer_letter = 'C'
	) AS optionC

FROM
	questions q;
     */

    // Not sure about QuestionsTable._ID / q._ID
    public List<Question> getAllQuestionsAndAnswersFromDatabase() {
        List<Question> questionList = new ArrayList<>();
        db = getReadableDatabase();
        Cursor cursor = db.rawQuery(
            "SELECT" +
            " q." + QuestionsTable.COLUMN_QUESTION_TEXT +
            ", q." + QuestionsTable.COLUMN_STAGE +
            ", q." + QuestionsTable.COLUMN_PRIZE +
            ", q." + QuestionsTable.COLUMN_CORRECT_ANSWER_LETTER +
            // Option A
            ", (SELECT a1." + AnswersTable.COLUMN_ANSWER_TEXT +
            " FROM " + AnswersTable.TABLE_NAME + " a1 " +
            "WHERE a1." + AnswersTable.QUESTION_ID + " = q._ID " +
            "AND a1." + AnswersTable.COLUMN_ANSWER_LETTER + " = 'A') AS optionA" +
            // Option B
            ", (SELECT a1." + AnswersTable.COLUMN_ANSWER_TEXT +
            " FROM " + AnswersTable.TABLE_NAME + " a1 " +
            "WHERE a1." + AnswersTable.QUESTION_ID + " = q._ID " +
            "AND a1." + AnswersTable.COLUMN_ANSWER_LETTER + " = 'B') AS optionB" +
            // Option C
            ", (SELECT a1." + AnswersTable.COLUMN_ANSWER_TEXT +
            " FROM " + AnswersTable.TABLE_NAME + " a1 " +
            "WHERE a1." + AnswersTable.QUESTION_ID + " = q._ID " +
            "AND a1." + AnswersTable.COLUMN_ANSWER_LETTER + " = 'C') AS optionC " +
            "FROM " + QuestionsTable.TABLE_NAME + "q",
            null);

        if (cursor.moveToFirst()) {
            do {
                Question question = new Question();
                question.setQuestion_text(cursor.getString(cursor.getColumnIndex(QuestionsTable.COLUMN_QUESTION_TEXT)));
                question.setQuestion_stage(cursor.getInt(cursor.getColumnIndex(QuestionsTable.COLUMN_STAGE)));
                question.setQuestion_prize(cursor.getInt(cursor.getColumnIndex(QuestionsTable.COLUMN_PRIZE)));
                question.setCorrect_answer_letter(cursor.getString(cursor.getColumnIndex(QuestionsTable.COLUMN_CORRECT_ANSWER_LETTER)));
                question.setOptionA(cursor.getString(cursor.getColumnIndex("optionA")));
                question.setOptionB(cursor.getString(cursor.getColumnIndex("optionB")));
                question.setOptionC(cursor.getString(cursor.getColumnIndex("optionC")));
                questionList.add(question);
            } while (cursor.moveToNext());
        }

        cursor.close();
        return questionList;
    }
}
