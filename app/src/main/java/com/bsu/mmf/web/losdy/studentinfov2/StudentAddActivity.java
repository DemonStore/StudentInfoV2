package com.bsu.mmf.web.losdy.studentinfov2;

import android.app.Activity;
import android.app.Fragment;

/**
 * Created by DemonStore on 24.10.2014.
 */
public class StudentAddActivity extends SingleFragmentActivity {
    @Override
    protected void actionsWithActivity(Activity a) {
        a.setTitle(R.string.student_add_title);
    }

    @Override
    protected Fragment createFragment() {
        return new StudentFragment();
    }


}
