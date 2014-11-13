package com.bsu.mmf.web.losdy.studentinfov2;

import android.app.Fragment;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

/**
 * Created by DemonStore on 24.10.2014.
 */
public class StudentFragment extends Fragment {
    public static final String EXTRA_STUDENT_ID = "com.bsu.mmf.web.losdy.studentinfov2.student_id";

    private Student mStudent;

    private EditText mNameField;
    private EditText mFacultyField;
    private EditText mNumberField;
    private EditText mEmailField;
    private Button mConfirmButton;

    public static StudentFragment newInstance(long studentId) {
        Bundle args = new Bundle();
        args.putLong(EXTRA_STUDENT_ID, studentId);
        StudentFragment fragment = new StudentFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            long studentId = getArguments().getLong(EXTRA_STUDENT_ID);
            mStudent = StudentLab.get(getActivity()).getStudent(studentId);
        } else {
            mStudent = StudentLab.get(getActivity()).insertStudent();
        }

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_student, container, false);

        mNameField = (EditText)v.findViewById(R.id.student_name);
        mNameField.setText(mStudent.getName());
        mNameField.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                mStudent.setName(charSequence.toString());
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        mFacultyField = (EditText)v.findViewById(R.id.student_faculty);
        mFacultyField.setText(mStudent.getFaculty());
        mFacultyField.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                mStudent.setFaculty(charSequence.toString());
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        mNumberField = (EditText)v.findViewById(R.id.student_number);
        mNumberField.setText(mStudent.getNumber());
        mNumberField.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                mStudent.setNumber(charSequence.toString());
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        mEmailField = (EditText)v.findViewById(R.id.student_email);
        mEmailField.setText(mStudent.getEmail());
        mEmailField.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                mStudent.setEmail(charSequence.toString());
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
        mConfirmButton = (Button)v.findViewById(R.id.student_confirm_button);
        mConfirmButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getActivity().finish();
            }
        });

        return v;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        StudentLab.get(getActivity()).updateStudent(mStudent);
    }
}
