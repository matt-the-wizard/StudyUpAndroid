package studyup.projects.ggc.tasks;

import android.os.AsyncTask;
import android.util.Log;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by matt-the-wizard on 11/22/15.
 */
public class LoadStudentsAsyncTask extends AsyncTask<Void, Void, String> {

    private String jsonURL = "http://www.localhost:3000/api/students";
    //private String jsonURL = "https://studyupggc.herokuapp.com/api/students";

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
