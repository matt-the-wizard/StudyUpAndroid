package studyup.projects.ggc.controllers;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.concurrent.ExecutionException;

import studyup.projects.ggc.controllers.R;
import studyup.projects.ggc.models.Student;
import studyup.projects.ggc.models.StudentJSONParser;
import studyup.projects.ggc.tasks.CheckNetworkAsyncTask;
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
                Toast.makeText(getApplicationContext(), "Coming Soon!", Toast.LENGTH_LONG).show();
                /*
                Couldn't get this working in time for demo.
                CreateProfileAsyncTask task = new CreateProfileAsyncTask(username.getText().toString(), password.getText().toString(), passwordDigest.getText().toString(), firstName.getText().toString(),
                        lastName.getText().toString(), institution.getText().toString());
                try {
                    CheckNetworkAsyncTask networkAsyncTask = new CheckNetworkAsyncTask(getApplicationContext());
                    boolean networkAccess = networkAsyncTask.execute().get();
                    if (networkAccess) {
                        String response = task.execute().get();
                        Log.d("Response: ", response);
                        if (response != null && !response.contains(Student.AUTHENTICATION_ERROR)) {
                            Student.LOGGED_IN_USER = StudentJSONParser.parseJSONRecord(response);
                            Intent intent = new Intent(getApplicationContext(), ProfileActivity.class);
                            startActivity(intent);
                        }
                        else if (response.contains(Student.AUTHENTICATION_ERROR)){
                            Toast.makeText(getApplicationContext(), StudentJSONParser.parseJSONError(response), Toast.LENGTH_LONG).show();
                        }
                        else {
                            Toast.makeText(getApplicationContext(), "There was an error in loading your account.", Toast.LENGTH_LONG).show();
                        }
                    }
                    else {
                        Toast.makeText(getApplicationContext(), "You do not have internet access.", Toast.LENGTH_LONG).show();
                    }
                } catch (ExecutionException | InterruptedException ei) {
                    Toast.makeText(CreateProfileActivity.this, "There was an network error loading your account", Toast.LENGTH_LONG).show();
                }*/
            }
        });
    }

}
