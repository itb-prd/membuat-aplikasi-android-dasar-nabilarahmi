package com.example.nabila.todolist;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class TaskDbHelper extends SQLiteOpenHelper {

    public TaskDbHelper(Context context) {
        super(context, com.example.nabila.todolist.TaskContract.DB_NAME, null, com.example.nabila.todolist.TaskContract.DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String createTable = "CREATE TABLE " + com.example.nabila.todolist.TaskContract.TaskEntry.TABLE + " ( " +
                com.example.nabila.todolist.TaskContract.TaskEntry._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                com.example.nabila.todolist.TaskContract.TaskEntry.COL_TASK_TITLE + " TEXT NOT NULL);";

        db.execSQL(createTable);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + com.example.nabila.todolist.TaskContract.TaskEntry.TABLE);
        onCreate(db);
    }
}
