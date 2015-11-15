package studyup.projects.ggc.controllers;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
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

        this.mProfileLableDisplay.setText(Student.LOGGED_IN_USER.getUserName());
        this.mFirstNameDisplay.setText(Student.LOGGED_IN_USER.getFirstName());
        this.mLastNameDisplay.setText(Student.LOGGED_IN_USER.getLastName());
        this.mInstitutionDisplay.setText(Student.LOGGED_IN_USER.getInstitution());

    }

}
