package se.apals.brooklynmuseum.data.api;

import android.annotation.SuppressLint;
import android.content.SharedPreferences;
import android.os.AsyncTask;

import se.apals.brooklynmuseum.data.DataSource;


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
        BrooklynMuseumApi.fetchObjects(dataSource, preferences);
        return null;
    }
}
