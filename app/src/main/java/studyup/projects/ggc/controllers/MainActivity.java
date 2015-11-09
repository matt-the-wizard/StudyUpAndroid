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

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.concurrent.ExecutionException;

import studyup.projects.ggc.models.Student;
import studyup.projects.ggc.models.StudentHash;


public class MainActivity extends AppCompatActivity {

    private TextView profileTextView;
    private Button loadProfileButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.profileTextView = (TextView) findViewById(R.id.profile_text_view);
        this.loadProfileButton = (Button) findViewById(R.id.load_profile_button);
        this.loadProfileButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    LoginUserAsyncTask backgroundTask = new LoginUserAsyncTask("matt@ggc.edu", "test");
                    String response  = backgroundTask.execute().get();
                    if (response != null) {
                        Gson gson = new GsonBuilder().create();
                        StudentHash studentGSON = gson.fromJson(response, StudentHash.class);
                        Student.LOGGED_IN_USER = studentGSON.getSTUDENT();
                        Log.d("Student", studentGSON.getSTUDENT().toString());
                        Log.d("Student in thread", Student.LOGGED_IN_USER.toString());
                        Intent intent = new Intent(getApplicationContext(), ProfileActivity.class);
                        MainActivity.this.startActivity(intent);
                    }
                }
                catch (ExecutionException | InterruptedException ei) {
                    //Toast.makeText(getApplicationContext())
                }
            }
        });
    }

    public static void launchProfileActivity(String response){

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
