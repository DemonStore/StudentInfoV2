package com.bsu.mmf.web.losdy.studentinfov2;

import java.util.UUID;

/**
 * Created by DemonStore on 24.10.2014.
 */
public class Student {
    private UUID mId;
    private String name;
    private String faculty;
    private String number;
    private String email;

    public Student() {
        mId = UUID.randomUUID();
    }

    public UUID getId() {
        return mId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFaculty() {
        return faculty;
    }

    public void setFaculty(String faculty) {
        this.faculty = faculty;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
