package studyup.projects.ggc.controllers;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import studyup.projects.ggc.controllers.R;
import studyup.projects.ggc.tasks.CreateProfileAsyncTask;

public class CreateProfileActivity extends AppCompatActivity {
    private Button submitAccountButton;
    private EditText username, password, passwordDigest, firstName, lastName, institution;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create);
        this.submitAccountButton = (Button) findViewById(R.id.submit_account_button);
        this.username = (EditText) findViewById(R.id.username_value);
        this.password = (EditText) findViewById(R.id.password_value);
        this.passwordDigest = (EditText) findViewById(R.id.password_digest_value);
        this.firstName = (EditText) findViewById(R.id.first_name_value);
        this.lastName = (EditText) findViewById(R.id.last_name_value);
        this.institution = (EditText) findViewById(R.id.institution_value);

        this.submitAccountButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                
                CreateProfileAsyncTask task = new CreateProfileAsyncTask();
            }
        });
    }

}
