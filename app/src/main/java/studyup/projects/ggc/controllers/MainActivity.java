package studyup.projects.ggc.controllers;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import java.util.concurrent.ExecutionException;

import studyup.projects.ggc.models.Student;
import studyup.projects.ggc.models.StudentJSONParser;
import studyup.projects.ggc.tasks.CheckNetworkAsyncTask;
import studyup.projects.ggc.tasks.LoginUserAsyncTask;


public class MainActivity extends AppCompatActivity {

    private Button loadProfileButton, createAccountButton;
    private TextView usernameTextValue, passwordTextValue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.loadProfileButton = (Button) findViewById(R.id.load_profile_button);
        this.createAccountButton = (Button) findViewById(R.id.button_create_account);
        this.usernameTextValue = (TextView) findViewById(R.id.username_value);
        this.passwordTextValue = (TextView) findViewById(R.id.password_value);
        this.loadProfileButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    CheckNetworkAsyncTask networkAsyncTask = new CheckNetworkAsyncTask(getApplicationContext());
                    boolean networkAccess = networkAsyncTask.execute().get();
                    if (networkAccess) {
                        LoginUserAsyncTask backgroundTask = new LoginUserAsyncTask(usernameTextValue.getText().toString().trim(), passwordTextValue.getText().toString().trim());
                        String response  = backgroundTask.execute().get();
                        Log.d("Response", response);
                        if (response != null && !response.contains(Student.AUTHENTICATION_ERROR)) {
                            Student.LOGGED_IN_USER = StudentJSONParser.parseJSONRecord(response);
                            Intent intent = new Intent(getApplicationContext(), ProfileActivity.class);
                            MainActivity.this.startActivity(intent);
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
                }
                catch (ExecutionException | InterruptedException ei) {
                    Toast.makeText(MainActivity.this, "There was an network error loading your account", Toast.LENGTH_LONG).show();
                }
            }
        });
        this.createAccountButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, CreateProfileActivity.class);
                startActivity(i);
            }
        });

    }
}
