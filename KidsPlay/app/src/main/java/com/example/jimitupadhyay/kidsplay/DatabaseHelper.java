package com.example.jimitupadhyay.kidsplay;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jimitupadhyay on 2017-04-18.
 */

public class DatabaseHelper extends SQLiteOpenHelper {

    public DatabaseHelper(Context context) {
        super(context, "C0685607_KIDSDRAW", null, 1);
    }




    @Override
    public void onCreate(SQLiteDatabase db) {

        String sql = "CREATE TABLE Students (name TEXT NOT NULL)";

        db.execSQL(sql);
    }

    /* 0007: This method exists due the fact that if you change
   your database it will not be created again, but will be upgraded
   */
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int
            newVersion) {
        String sql = "DROP TABLE IF EXISTS Students";
        db.execSQL(sql);
        onCreate(db);
    }
    public void dbinsert(Points points) {

        SQLiteDatabase db = getWritableDatabase();

        ContentValues studentData = getStudentContentValues(points);

        db.insert("Students", null, studentData);
    }
    private ContentValues getStudentContentValues(Points student)
    {
        ContentValues studentData = new ContentValues();
        studentData.put("name", student.getName());

        return studentData;
    }
    public List<Points> searchStudents() {
        String sql = "SELECT * FROM Students;";
        SQLiteDatabase db = getReadableDatabase();

        Cursor c = db.rawQuery(sql, null);

        List<Points> studentsList = new ArrayList<Points>();

        while (c.moveToNext()) {
            Points student = new Points();



            student.setName(c.getString(c.getColumnIndex("name")));


 /* 0016 : Assign each student readed to an array,
until array finalize */
            studentsList.add(student);
        }
 /* 0017: Close Cursor */
        c.close();
 /* 0018: Return Array of students */
        return studentsList;
    }

}