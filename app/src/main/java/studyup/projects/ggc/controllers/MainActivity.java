package studyup.projects.ggc.controllers;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.concurrent.ExecutionException;

import studyup.projects.ggc.models.Student;
import studyup.projects.ggc.models.StudentJSONParser;


public class MainActivity extends AppCompatActivity {

    private Button loadProfileButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.loadProfileButton = (Button) findViewById(R.id.load_profile_button);
        this.loadProfileButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            try {
                LoginUserAsyncTask backgroundTask = new LoginUserAsyncTask("matt@ggc.edu", "test");
                String response  = backgroundTask.execute().get();
                if (response != null) {
                    Student.LOGGED_IN_USER = StudentJSONParser.parseJSONRecord(response);
                    Intent intent = new Intent(getApplicationContext(), ProfileActivity.class);
                    MainActivity.this.startActivity(intent);
                }
            }
            catch (ExecutionException | InterruptedException ei) {
                Toast.makeText(MainActivity.this, "There was an network error loading your account", Toast.LENGTH_LONG).show();
            }
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
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}