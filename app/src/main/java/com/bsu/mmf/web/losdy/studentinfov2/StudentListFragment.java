package com.bsu.mmf.web.losdy.studentinfov2;

import android.app.ListFragment;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CursorAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

/**
 * Created by DemonStore on 24.10.2014.
 */
public class StudentListFragment extends ListFragment {
    private static class StudentCursorAdapter extends CursorAdapter {
        private StudentDatabaseHelper.StudentCursor mStudentCursor;

        private StudentCursorAdapter(Context context, StudentDatabaseHelper.StudentCursor cursor) {
            super(context, cursor, 0);
            mStudentCursor = cursor;
        }

        @Override
        public View newView(Context context, Cursor cursor, ViewGroup viewGroup) {
            LayoutInflater inflater = (LayoutInflater)context
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            return inflater.inflate(R.layout.list_item_student, viewGroup, false);
        }

        @Override
        public void bindView(View view, Context context, Cursor cursor) {
            Student student = mStudentCursor.getStudent();
            LinearLayout layout = (LinearLayout)view;
            TextView nameTextView = (TextView)layout.findViewById(R.id.student_list_item_studentNameTextView);
            nameTextView.setText(student.getName());
            TextView facultyTextView = (TextView)layout.findViewById(R.id.student_list_item_studentFacultyTextView);
            facultyTextView.setText(student.getFaculty());
            TextView numberTextView = (TextView)layout.findViewById(R.id.student_list_item_studentNumberTextView);
            numberTextView.setText(student.getNumber());
            TextView emailTextView = (TextView)layout.findViewById(R.id.student_list_item_studentEmailTextView);
            emailTextView.setText(student.getEmail());
        }
    }

    StudentDatabaseHelper.StudentCursor mCursor;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mCursor = StudentLab.get(getActivity()).queryStudents();

        StudentCursorAdapter adapter = new StudentCursorAdapter(getActivity(), mCursor);
        setListAdapter(adapter);
    }

    @Override
    public void onResume() {
        super.onResume();
        mCursor.requery();
        ((StudentCursorAdapter)getListAdapter()).notifyDataSetChanged();
    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);

        Intent i = new Intent(getActivity(), StudentActivity.class);
        i.putExtra(StudentFragment.EXTRA_STUDENT_ID, id);
        startActivity(i);
    }

    @Override
    public void onDestroy() {
        mCursor.close();
        super.onDestroy();
    }
}
