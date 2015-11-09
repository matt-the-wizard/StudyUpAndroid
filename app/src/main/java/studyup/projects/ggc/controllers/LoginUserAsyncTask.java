package studyup.projects.ggc.controllers;

import android.util.Log;
import android.os.AsyncTask;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class LoginUserAsyncTask extends AsyncTask<Void, Integer, String> {

    private String jsonURL;

    public LoginUserAsyncTask(String username, String password) {
        this.jsonURL = "https://studyupggc.herokuapp.com/api/students/access_profile?username=wizard@ggc.edu&password=supersecret";
        //this.jsonURL = "https://studyupggc.herokuapp.com/api/students/access_profile?username=" + username + "&password=" + password;
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
            Log.d("Error", e.getMessage());
        } finally {
            if (inStream != null) {
                try { inStream.close(); } catch (IOException ignored) { }
            }
            if (urlConnection != null) {
                urlConnection.disconnect();
            }
            return response;
        }
    }


}