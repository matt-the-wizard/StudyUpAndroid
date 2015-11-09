package studyup.projects.ggc.controllers;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import studyup.projects.ggc.models.User;

public class ProfileActivity extends AppCompatActivity {

    private TextView mFirstNameDisplay,
                     mLastNameDisplay,
                     mInstitutionDisplay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        this.mFirstNameDisplay.setText(User.LOGGED_IN_USER.getFirstName());
        this.mFirstNameDisplay.setVisibility(View.VISIBLE);
        this.mLastNameDisplay.setText(User.LOGGED_IN_USER.getLastName());
        this.mLastNameDisplay.setVisibility(View.VISIBLE);
        this.mInstitutionDisplay.setText(User.LOGGED_IN_USER.getInstitution());
        this.mInstitutionDisplay.setVisibility(View.VISIBLE);
    }

}
