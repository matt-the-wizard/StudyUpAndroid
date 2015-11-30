package studyup.projects.ggc.tasks;

import android.os.AsyncTask;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by matt-the-wizard on 11/22/15.
 */
public class CreateProfileAsyncTask extends AsyncTask<Void, Void, String> {
    private String jsonURL;

    public CreateProfileAsyncTask(String username, String password, String passwordConfirmation, String firstName, String lastName, String institution) {
        this.jsonURL = "https://studyupggc.herokuapp.com/api/students?username=" + username
                + "&password=" + password
                + "&password_confirmation=" + passwordConfirmation
                + "&first_name=" + firstName
                + "&last_name=" + lastName
                + "&institution=" + institution;
    }

    @Override
    protected String doInBackground(Void... params) {
        HttpURLConnection urlConnection = null;
        URL url = null;
        OutputStream outStream = null;
        String response = "";
        try {
            url = new URL(this.jsonURL);
            urlConnection = (HttpURLConnection) url.openConnection();
            urlConnection.setRequestMethod("POST");
            urlConnection.connect();
            outStream = urlConnection.getOutputStream();
            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(outStream, "UTF-8"));
            writer.write(this.jsonURL);
            writer.flush();
            writer.close();
            outStream.close();
            int responseCode = urlConnection.getResponseCode();
            if (responseCode == HttpURLConnection.HTTP_OK) {
                String line;
                BufferedReader br=new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
                while ((line = br.readLine()) != null)
                    response += line;
            }
            else
                response = "";
        } catch (Exception e) {}
        return response;
    }
}
