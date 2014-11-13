package com.bsu.mmf.web.losdy.studentinfov2;

import android.app.Activity;
import android.app.Fragment;

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
        long id = getIntent().getLongExtra(StudentFragment.EXTRA_STUDENT_ID, -1);
        return StudentFragment.newInstance(id);
    }
}
