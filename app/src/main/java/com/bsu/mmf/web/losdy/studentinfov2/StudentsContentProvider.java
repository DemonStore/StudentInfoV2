package com.bsu.mmf.web.losdy.studentinfov2;

import android.content.ContentProvider;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;

import static com.bsu.mmf.web.losdy.studentinfov2.Contants.*;

/**
 * Created by DemonStore on 14.11.2014.
 */
public class StudentsContentProvider extends ContentProvider {
    private static final UriMatcher sUriMatcher = new UriMatcher(UriMatcher.NO_MATCH);

    static {
        sUriMatcher.addURI(PROVIDER_AUTHORITY, DB_TABLE_NAME, PROVIDER_MATCHER_LIST_STUDENTS_ID);
        sUriMatcher.addURI(PROVIDER_AUTHORITY, DB_TABLE_NAME + "/#", PROVIDER_MATCHER_STUDENT_ID);
    }

    StudentDatabaseHelper mStudentDatabaseHelper;
    private SQLiteDatabase mDb;

    // Выполнять getWritableDatabase()/getReadableDatabase() рекомендуется не в onCreate()
    private SQLiteDatabase getDb() {
        if (mDb != null) {
            return mDb;
        } else {
            mDb = mStudentDatabaseHelper.getWritableDatabase();
            return mDb;
        }
    }

    @Override
    public boolean onCreate() {
        mStudentDatabaseHelper = new StudentDatabaseHelper(getContext());
        return true;
    }

    @Override
    public String getType(Uri uri) {
        return PROVIDER_AUTHORITY + "." + DB_TABLE_NAME;
    }

    @Override
    public Cursor query(Uri uri, String[] projection, String selection, String[] selectionArgs, String orderBy) {
        switch (sUriMatcher.match(uri)) {
            case PROVIDER_MATCHER_LIST_STUDENTS_ID:
                break;
            case PROVIDER_MATCHER_STUDENT_ID:
                selection = DB_COLUMN_ID + " = " + uri.getLastPathSegment();
                break;
            default:
                throw new IllegalArgumentException("Incorrect uri in query of content provider");
        }
        return getDb().query(DB_TABLE_NAME,
                projection,
                selection,
                selectionArgs,
                null,
                null,
                orderBy);
    }

    @Override
    public Uri insert(Uri uri, ContentValues contentValues) {
        long id = getDb().insert(DB_TABLE_NAME, null, contentValues);
        return ContentUris.withAppendedId(PROVIDER_URI, id);
    }

    @Override
    public int update(Uri uri, ContentValues contentValues, String s, String[] strings) {
        switch (sUriMatcher.match(uri)) {
            case PROVIDER_MATCHER_LIST_STUDENTS_ID:
                break;
            case PROVIDER_MATCHER_STUDENT_ID:
                s = DB_COLUMN_ID + " = " + uri.getLastPathSegment();
                break;
            default:
                throw new IllegalArgumentException("Incorrect uri in query of content provider");
        }
        return getDb().update(DB_TABLE_NAME, contentValues, s, strings);
    }

    @Override
    public int delete(Uri uri, String s, String[] strings) {
        return getDb().delete(DB_TABLE_NAME, s, strings);
    }
}
