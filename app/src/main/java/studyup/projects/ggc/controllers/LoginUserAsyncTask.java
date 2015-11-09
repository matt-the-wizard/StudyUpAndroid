package studyup.projects.ggc.controllers;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.TextView;
import android.os.AsyncTask;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

import studyup.projects.ggc.models.User;

public class LoginUserAsyncTask extends AsyncTask<Void, Integer, String> {
    private String jsonURL;
    private Context context;
    private TextView loadingDisplay;
    private ArrayList<String> errors;
    private User user;

    public LoginUserAsyncTask(Context c, TextView t, String username, String password) {
        this.jsonURL = "https://studyupggc.herokuapp.com/api/students/access_profile?username=wizard@ggc.edu&password=supersecret";
        //this.jsonURL = "https://studyupggc.herokuapp.com/api/students/access_profile?username=" + username + "&password=" + password;
        this.context = c;
        this.loadingDisplay = t;
        this.errors = new ArrayList<String>();
    }

    @Override
    protected void onPreExecute(){

    }

    @Override
    protected String doInBackground(Void... params) {
        HttpURLConnection urlConnection = null;
        URL url = null;
        InputStream inStream = null;
        String response = "";
        try {
            url = new URL(this.jsonURL);
            urlConnection = (HttpURLConnection) url.openConnection();
            urlConnection.setRequestMethod("GET");
            urlConnection.connect();
            inStream = urlConnection.getInputStream();
            BufferedReader bReader = new BufferedReader(new InputStreamReader(inStream));
            String temp = "";
            while ((temp = bReader.readLine()) != null) {
                response += temp;
            }
        } catch (Exception e) {
            this.errors.add(e.toString());
        } finally {
            if (inStream != null) {
                try { inStream.close(); } catch (IOException ignored) { }
            }
            if (urlConnection != null) {
                urlConnection.disconnect();
            }
            if (!this.errors.isEmpty()) {
                Log.d("ERRORS", this.errors.toString());
                return null;
            }
            else {
                return response;
            }
        }
    }

    @Override
    protected void onPostExecute(String response) {
        Toast.makeText(this.context, "Profile loaded successfully!", Toast.LENGTH_LONG).show();
        this.loadingDisplay.setText(response);
        if (response != null) {
            Gson gson = new GsonBuilder().create();
            User.LOGGED_IN_USER = gson.fromJson(response, User.class);
            Intent intent = new Intent(this.context, ProfileActivity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            this.context.startActivity(intent);
        }
    }


}