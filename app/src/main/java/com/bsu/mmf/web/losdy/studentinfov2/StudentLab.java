package com.bsu.mmf.web.losdy.studentinfov2;

import android.content.ContentResolver;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.Context;
import android.net.Uri;

import static com.bsu.mmf.web.losdy.studentinfov2.Contants.*;

/**
 * Created by DemonStore on 24.10.2014.
 */
public class StudentLab {
    private static StudentLab sStudentLab;
    private Context mAppContext;
    ContentResolver mResolver;

    private StudentLab(Context appContext) {
        mAppContext = appContext;
        mResolver = mAppContext.getContentResolver();
    }

    public static StudentLab get(Context c) {
        if (sStudentLab == null) {
            sStudentLab = new StudentLab(c.getApplicationContext());
        }
        return sStudentLab;
    }

    public Student getStudent(long id) {
        String projection[] = new String[] {DB_COLUMN_ID, DB_COLUMN_NAME, DB_COLUMN_FACULTY, DB_COLUMN_NUMBER, DB_COLUMN_EMAIL};
        StudentDatabaseHelper.StudentCursor cursor = new StudentDatabaseHelper.StudentCursor(
                mResolver.query(ContentUris.withAppendedId(PROVIDER_CONTENT_URI, id), projection, null, null, null)
        );

        Student student = null;
        cursor.moveToFirst();
        if (!cursor.isAfterLast()) {
            student = cursor.getStudent();
        }
        cursor.close();
        return student;
    }

    public Student insertStudent() {
        Student student = new Student();

        ContentValues cv = new ContentValues();
        cv.put(DB_COLUMN_NAME, student.getName());
        cv.put(DB_COLUMN_FACULTY, student.getFaculty());
        cv.put(DB_COLUMN_NUMBER, student.getNumber());
        cv.put(DB_COLUMN_EMAIL, student.getEmail());

        Uri resUri = mResolver.insert(PROVIDER_CONTENT_URI, cv);

        student.setId(ContentUris.parseId(resUri));
        return student;
    }

    public void updateStudent(Student student) {
        ContentValues cv = new ContentValues();
        cv.put(DB_COLUMN_NAME, student.getName());
        cv.put(DB_COLUMN_FACULTY, student.getFaculty());
        cv.put(DB_COLUMN_NUMBER, student.getNumber());
        cv.put(DB_COLUMN_EMAIL, student.getEmail());

        mResolver.update(ContentUris.withAppendedId(PROVIDER_CONTENT_URI, student.getId()), cv, null, null);
    }

    public StudentDatabaseHelper.StudentCursor queryStudents() {
        String projection[] = new String[] {DB_COLUMN_ID, DB_COLUMN_NAME, DB_COLUMN_FACULTY, DB_COLUMN_NUMBER, DB_COLUMN_EMAIL};
        return new StudentDatabaseHelper.StudentCursor(
                mResolver.query(PROVIDER_CONTENT_URI, projection, null, null, null)
        );
    }
}
