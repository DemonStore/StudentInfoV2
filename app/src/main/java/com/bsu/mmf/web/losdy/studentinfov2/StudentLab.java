package com.bsu.mmf.web.losdy.studentinfov2;

import android.content.Context;

/**
 * Created by DemonStore on 24.10.2014.
 */
public class StudentLab {
    private static StudentLab sStudentLab;
    private Context mAppContext;
    private StudentDatabaseHelper dbHelper;

    private StudentLab(Context appContext) {
        mAppContext = appContext;
        dbHelper = new StudentDatabaseHelper(mAppContext);
    }

    public static StudentLab get(Context c) {
        if (sStudentLab == null) {
            sStudentLab = new StudentLab(c.getApplicationContext());
        }
        return sStudentLab;
    }

    public Student getStudent(long id) {
        Student student = null;
        StudentDatabaseHelper.StudentCursor cursor = dbHelper.queryStudent(id);
        cursor.moveToFirst();
        if (!cursor.isAfterLast()) {
            student = cursor.getStudent();
        }
        cursor.close();
        return student;
    }

    public Student insertStudent() {
        Student student = new Student();
        student.setId(dbHelper.insertStudent(student));
        return student;
    }

    public void updateStudent(Student student) {
        dbHelper.updateStudent(student);
    }

    public StudentDatabaseHelper.StudentCursor queryStudents() {
        return dbHelper.queryStudents();
    }
}
