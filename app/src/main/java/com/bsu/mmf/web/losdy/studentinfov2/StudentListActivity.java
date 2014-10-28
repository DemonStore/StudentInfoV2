package com.bsu.mmf.web.losdy.studentinfov2;

import android.app.Activity;
import android.app.Fragment;
import android.content.Intent;
import android.view.Menu;
import android.view.MenuItem;


public class StudentListActivity extends SingleFragmentActivity {
    @Override
    protected void actionsWithActivity(Activity a) {
        a.setTitle(R.string.student_list_title);
    }

    @Override
    protected Fragment createFragment() {
        return new StudentListFragment();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.student_list, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        switch (item.getItemId()) {
            case R.id.action_add_student:
                Intent i = new Intent(this, StudentAddActivity.class);
                startActivity(i);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
