package com.bsu.mmf.web.losdy.studentinfov2;

import android.content.Context;

import java.util.ArrayList;
import java.util.UUID;

/**
 * Created by DemonStore on 24.10.2014.
 */
public class StudentLab {
    private ArrayList<Student> mStudents;

    private static StudentLab sStudentLab;
    private Context mAppContext;

    private StudentLab(Context appContext) {
        mAppContext = appContext;
        mStudents = new ArrayList<Student>();
        for (int i = 0; i < 10; i++) {
            Student student = new Student();
            student.setName("Name" + (i + 1));
            student.setFaculty("MMF");
            student.setNumber("+37529100000" + (i + 1));
            student.setEmail("email" + (i + 1) + "@mail.ru");
            mStudents.add(student);
        }
    }

    public static StudentLab get(Context c) {
        if (sStudentLab == null) {
            sStudentLab = new StudentLab(c.getApplicationContext());
        }
        return sStudentLab;
    }

    public Student getStudent(UUID id) {
        for (Student student : mStudents) {
            if (student.getId().equals(id)) {
                return student;
            }
        }
        return null;
    }

    public ArrayList<Student> getStudents() {
        return mStudents;
    }
}
