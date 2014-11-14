package com.bsu.mmf.web.losdy.studentinfov2;

import android.net.Uri;

/**
 * Created by DemonStore on 14.11.2014.
 */
public class Contants {
    // StudentsContentProvider
    public static final String PROVIDER_AUTHORITY = "com.bsu.mmf.web.losdy.studentinfov2";
    public static final Uri PROVIDER_URI = Uri.parse("content://" + PROVIDER_AUTHORITY);
    public static final int PROVIDER_MATCHER_STUDENT_ID = 1;
    public static final int PROVIDER_MATCHER_LIST_STUDENTS_ID = 2;

    // StudentsDatabaseHelper
    public static final String DB_NAME = "students";
    public static final int DB_VERSION = 1;
    public static final String DB_TABLE_NAME = "students_list";
    public static final String DB_COLUMN_ID = "_id";
    public static final String DB_COLUMN_NAME = "name";
    public static final String DB_COLUMN_FACULTY = "faculty";
    public static final String DB_COLUMN_NUMBER = "number";
    public static final String DB_COLUMN_EMAIL = "email";

    public static final Uri PROVIDER_CONTENT_URI = Uri.parse("content://" + PROVIDER_AUTHORITY + "/" + DB_TABLE_NAME);
}
