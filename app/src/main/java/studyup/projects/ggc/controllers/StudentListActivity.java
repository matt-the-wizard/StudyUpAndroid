package studyup.projects.ggc.controllers;

import android.app.Activity;
import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.concurrent.ExecutionException;

import studyup.projects.ggc.models.Student;
import studyup.projects.ggc.models.StudentJSONParser;
import studyup.projects.ggc.tasks.LoadStudentsAsyncTask;

/**
 * Created by dericuspaul on 11/22/15.
 */
public class StudentListActivity extends ListActivity {

    public static final String STUDENT_TAG = "Student-Detail-Object";

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        LoadStudentsAsyncTask task = new LoadStudentsAsyncTask();
        try {
            ArrayList<Student> students = StudentJSONParser.parseJSONRecordList(task.execute().get());
            ArrayAdapter<Student> adapter = new ArrayAdapter<Student>(this, R.layout.student_list_item, students);
            setListAdapter(adapter);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
        Toast.makeText(getApplicationContext(), "You clicked an item", Toast.LENGTH_LONG).show();
        Student student = (Student) getListAdapter().getItem(position);
        Intent i = new Intent(StudentListActivity.this, ProfileActivity.class);
        i.putExtra(STUDENT_TAG, student);
    }
}
