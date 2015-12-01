package studyup.projects.ggc.tasks;

import android.os.AsyncTask;
import android.util.Log;

import org.json.JSONObject;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;

/**
 * Created by matt-the-wizard on 11/22/15.
 */
public class CreateProfileAsyncTask extends AsyncTask<Void, Void, String> {
    private String jsonURL;

    public CreateProfileAsyncTask(String username, String password, String passwordConfirmation, String firstName, String lastName, String institution) {
        this.jsonURL = "https://studyupggc.herokuapp.com/api/students/create_account?username=" + username
                + "&password=" + password
                + "&password_confirmation=" + passwordConfirmation
                + "&first_name=" + firstName
                + "&last_name=" + lastName
                + "&institution=" + institution;
    }

    @Override
    protected String doInBackground(Void... params) {
        HttpURLConnection connection = null;
        URL url = null;
        String response = "";
        InputStream inStream = null;
        try {
            url = new URL(this.jsonURL);
            connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.connect();

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
            if (connection != null) {
                connection.disconnect();
            }
            Log.d("Response:", response);
            return response;
        }
    }
}
