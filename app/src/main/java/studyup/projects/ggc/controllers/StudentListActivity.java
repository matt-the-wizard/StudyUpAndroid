package studyup.projects.ggc.controllers;

import android.app.Activity;
import android.app.ListActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

import studyup.projects.ggc.models.Student;

/**
 * Created by dericuspaul on 11/22/15.
 */
public class StudentListActivity extends ListActivity {
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        //Student students = new Student[];
        // Students will come from my asnc task
        ArrayList<String> students = new ArrayList<String>();
        students.add("Sally");
        students.add("BOB");
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, R.layout.student_list_item, students);
        setListAdapter(adapter);
    }

    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
        //Student item = (Student) getListAdapter().getItem(position);
        Toast.makeText(this, id + " selected", Toast.LENGTH_LONG).show();
    }
}
