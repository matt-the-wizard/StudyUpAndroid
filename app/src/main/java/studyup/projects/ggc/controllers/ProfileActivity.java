package studyup.projects.ggc.controllers;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;

import studyup.projects.ggc.models.Student;
import studyup.projects.ggc.models.StudentHash;

public class ProfileActivity extends AppCompatActivity {

    private TextView mFirstNameDisplay,
                     mLastNameDisplay,
                     mInstitutionDisplay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_profile);
        Log.d("StudentHash", Student.LOGGED_IN_USER.toString());
        this.mFirstNameDisplay.setText(Student.LOGGED_IN_USER.toString());
//        this.mLastNameDisplay.setText(StudentHash.LOGGED_IN_USER.getLastName());
//        this.mInstitutionDisplay.setText(StudentHash.LOGGED_IN_USER.getInstitution());
    }

}
