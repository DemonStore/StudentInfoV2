package com.bsu.mmf.web.losdy.studentinfov2;

import android.app.ListFragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by DemonStore on 24.10.2014.
 */
public class StudentListFragment extends ListFragment {
    private class StudentAdapter extends ArrayAdapter<Student> {
        public StudentAdapter(ArrayList<Student> crimes) {
            super(getActivity(), 0, crimes);
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            if (convertView == null) {
                convertView = getActivity().getLayoutInflater().inflate(R.layout.list_item_student, null);
            }
            Student student = getItem(position);
            TextView nameTextView = (TextView)convertView.findViewById(R.id.student_list_item_studentNameTextView);
            nameTextView.setText(student.getName());
            TextView facultyTextView = (TextView)convertView.findViewById(R.id.student_list_item_studentFacultyTextView);
            facultyTextView.setText(student.getFaculty());
            TextView numberTextView = (TextView)convertView.findViewById(R.id.student_list_item_studentNumberTextView);
            numberTextView.setText(student.getNumber());
            TextView emailTextView = (TextView)convertView.findViewById(R.id.student_list_item_studentEmailTextView);
            emailTextView.setText(student.getEmail());

            return convertView;
        }
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ArrayList<Student> students = StudentLab.get(getActivity()).getStudents();

        StudentAdapter adapter = new StudentAdapter(students);
        setListAdapter(adapter);
    }

    @Override
    public void onResume() {
        super.onResume();
        ((StudentAdapter)getListAdapter()).notifyDataSetChanged();
    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);
        Student student = ((StudentAdapter)getListAdapter()).getItem(position);

        Intent i = new Intent(getActivity(), StudentActivity.class);
        i.putExtra(StudentFragment.EXTRA_STUDENT_ID, student.getId());
        startActivity(i);
    }
}
