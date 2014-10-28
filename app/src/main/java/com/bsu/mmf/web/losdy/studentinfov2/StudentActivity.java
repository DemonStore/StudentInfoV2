package com.bsu.mmf.web.losdy.studentinfov2;

import android.app.Activity;
import android.app.Fragment;

import java.util.UUID;

/**
 * Created by DemonStore on 24.10.2014.
 */
public class StudentActivity extends SingleFragmentActivity {
    @Override
    protected void actionsWithActivity(Activity a) {
        a.getActionBar().setDisplayHomeAsUpEnabled(true);
        a.setTitle(R.string.student_edit_title);
    }

    @Override
    protected Fragment createFragment() {
        UUID id = (UUID)getIntent().getSerializableExtra(StudentFragment.EXTRA_STUDENT_ID);
        return StudentFragment.newInstance(id);
    }
}
