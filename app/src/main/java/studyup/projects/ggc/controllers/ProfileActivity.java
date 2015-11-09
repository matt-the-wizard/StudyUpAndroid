package studyup.projects.ggc.controllers;

import android.app.Activity;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

import studyup.projects.ggc.controllers.R;
import studyup.projects.ggc.models.User;

public class ProfileActivity extends Activity {
    private TextView mProfileDisplay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        this.mProfileDisplay = (TextView) findViewById(R.id.profile_text_view);
        this.mProfileDisplay.setText(User.LOGGED_IN_USER.toString());
    }

}
