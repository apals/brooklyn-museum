package se.apals.brooklynmuseum.data.api;

import android.annotation.SuppressLint;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.util.Log;

import org.json.JSONException;
import org.json.JSONObject;

import se.apals.brooklynmuseum.data.DataSource;
import se.apals.brooklynmuseum.models.ArchiveImage;


/**
 * Created by jespersandstrom on 25/05/16.
 */
public class FetchObjectsTask extends AsyncTask<Void, Void, Void> {

    private static String TAG = FetchObjectsTask.class.getSimpleName();

    private SharedPreferences preferences;
    private DataSource dataSource;

    public FetchObjectsTask(SharedPreferences preferences, DataSource dataSource) {
        this.preferences = preferences;
        this.dataSource = dataSource;
    }

    @SuppressLint("CommitPrefEdits")
    @Override
    protected Void doInBackground(Void... params) {
        JSONObject json = BrooklynMuseumApi.getInstance().fetchObjects(dataSource, preferences);
        try {
            BrooklynMuseumApi.getInstance().persistProperty(dataSource, json, ArchiveImage.class, BrooklynMuseumApi.OBJECT);
        } catch (JSONException e) {
            Log.e(TAG, "Failed to insert objects to database");
        }

        return null;
    }
}
