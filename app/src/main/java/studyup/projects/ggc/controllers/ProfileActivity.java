package studyup.projects.ggc.controllers;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import studyup.projects.ggc.models.Student;

public class ProfileActivity extends AppCompatActivity {

    public TextView  mProfileLableDisplay,
                     mFirstNameDisplay,
                     mLastNameDisplay,
                     mInstitutionDisplay;
    private Button mEmailButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        this.mProfileLableDisplay = (TextView) findViewById(R.id.profileTitleValue);
        this.mFirstNameDisplay = (TextView) findViewById(R.id.firstNameValue);
        this.mLastNameDisplay = (TextView) findViewById(R.id.lastNameValue);
        this.mInstitutionDisplay = (TextView) findViewById(R.id.institutionValue);
        this.mEmailButton = (Button) findViewById(R.id.email_button);

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

        this.mEmailButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                _sendEmail();
            }
        });

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

    private void _sendEmail(){
        Intent emailIntent = new Intent(android.content.Intent.ACTION_SEND);
        emailIntent.setData(Uri.parse("mailto:"));
        emailIntent.setType("text/plain");
        emailIntent.putExtra(android.content.Intent.EXTRA_EMAIL, new String[] {""});
        emailIntent.putExtra(android.content.Intent.EXTRA_SUBJECT, "Want to study?");
        emailIntent.putExtra(android.content.Intent.EXTRA_TEXT, "Contact me on study up!\n" +
         "https://studyupggc.herokuapp.com");
        startActivity(Intent.createChooser(emailIntent, "Sharing Options"));
    }

}
