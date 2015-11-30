package studyup.projects.ggc.controllers;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import studyup.projects.ggc.models.Student;

public class ProfileActivity extends AppCompatActivity {

    public TextView  mProfileLableDisplay,
                     mFirstNameDisplay,
                     mLastNameDisplay,
                     mInstitutionDisplay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        this.mProfileLableDisplay = (TextView) findViewById(R.id.profileTitleValue);
        this.mFirstNameDisplay = (TextView) findViewById(R.id.firstNameValue);
        this.mLastNameDisplay = (TextView) findViewById(R.id.lastNameValue);
        this.mInstitutionDisplay = (TextView) findViewById(R.id.institutionValue);

        Student student = (Student) getIntent().getSerializableExtra(StudentListActivity.STUDENT_TAG);

        if (student != null) {
            this.mProfileLableDisplay.setText(student.getUserName());
            this.mFirstNameDisplay.setText(student.getFirstName());
            this.mLastNameDisplay.setText(student.getLastName());
            this.mInstitutionDisplay.setText(student.getInstitution());
        }
        else {
            this.mProfileLableDisplay.setText(Student.LOGGED_IN_USER.getUserName());
            this.mFirstNameDisplay.setText(Student.LOGGED_IN_USER.getFirstName());
            this.mLastNameDisplay.setText(Student.LOGGED_IN_USER.getLastName());
            this.mInstitutionDisplay.setText(Student.LOGGED_IN_USER.getInstitution());
        }

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_students_list) {
            Intent intent = new Intent(ProfileActivity.this, StudentListActivity.class);
            startActivity(intent);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

}
