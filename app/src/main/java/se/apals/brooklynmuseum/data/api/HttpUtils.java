package se.apals.brooklynmuseum.data.api;

import android.annotation.SuppressLint;
import android.content.SharedPreferences;
import android.util.Log;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.zip.GZIPInputStream;

class HTTPUtils {
    private static final String TAG = HTTPUtils.class.getSimpleName();
    private static final String API_KEY = "SDm81cEAcWNp6bLvyRw2nOGUE7WUmdeZ";

    // This is always called from a background thread so suppress warning
    @SuppressLint("CommitPrefEdits")
    public static String get(URL url, SharedPreferences preferences, @BrooklynMuseumApi.ApiCalls String eTagKey) {
        String eTag = preferences.getString(eTagKey, "");

        HttpURLConnection connection = null;
        InputStream inputStream = null;
        try {
            connection = (HttpURLConnection) url.openConnection();
            connection.setRequestProperty("If-None-Match", eTag);
            connection.setRequestProperty("Accept-Encoding", "gzip");
            connection.setRequestProperty("api_key", API_KEY);

            if (connection.getResponseCode() == 304) {
                Log.d(TAG, "get Request: E-tag has not changed!");
                return null;
            } else if (connection.getResponseCode() == 200) {
                // Store the etag
                // Use commit since this will always be called from a background thread
                eTag = connection.getHeaderField("ETag");
                preferences.edit()
                        .putString(eTagKey, eTag)
                        .commit();
            }

            inputStream = new GZIPInputStream(connection.getInputStream());
            return read(inputStream);
        } catch (IOException e) {
            Log.e(TAG, "doInBackground: ", e);
        } finally {
            if (connection != null) {
                connection.disconnect();
            }
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e) {
                    Log.e(TAG, "doInBackground: ", e);
                }
            }
        }
        return null;
    }

    private static String read(InputStream instream) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(instream));
        StringBuilder builder = new StringBuilder();
        String line;
        while ((line = reader.readLine()) != null) {
            builder.append(line);
        }
        return builder.toString();
    }
}
