package studyup.projects.ggc.tasks;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

import studyup.projects.ggc.controllers.MainActivity;

/**
 * Reference: http://stackoverflow.com/questions/6493517/detect-if-android-device-has-internet-connection
 */
public class CheckNetworkAsyncTask extends AsyncTask<Void, Void, Boolean> {
    private Context context;

    public CheckNetworkAsyncTask(Context c){
        this.context = c;
    }

    private boolean networkConnectivity() {
        ConnectivityManager cm = (ConnectivityManager) this.context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = cm.getActiveNetworkInfo();
        if (networkInfo != null && networkInfo.isConnected())
            return true;
        return false;
    }

    @Override
    protected Boolean doInBackground(Void... params) {
        if (networkConnectivity()) {
            try {
                HttpURLConnection urlc = (HttpURLConnection) (new URL("https://studyupggc.herokuapp.com").openConnection());
                urlc.setRequestProperty("User-Agent", "Test");
                urlc.setRequestProperty("Connection", "close");
                urlc.setConnectTimeout(3000);
                urlc.setReadTimeout(4000);
                urlc.connect();
                return (urlc.getResponseCode() == 200);
            } catch (IOException e) {
                return false;
            }
        } else
            return false;
    }
}
