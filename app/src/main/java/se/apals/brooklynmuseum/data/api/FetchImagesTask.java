package se.apals.brooklynmuseum.data.api;

import android.annotation.SuppressLint;
import android.app.Application;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import javax.inject.Inject;

import se.apals.brooklynmuseum.BrooklynMuseumApplication;
import se.apals.brooklynmuseum.data.DataManager;
import se.apals.brooklynmuseum.models.ArchiveImage;


/**
 * Created by apals on 25/05/16.
 */
public class FetchImagesTask extends AsyncTask<Void, Void, Void> {

    private static String TAG = FetchImagesTask.class.getSimpleName();

    @Inject
    SharedPreferences preferences;

    @Inject
    DataManager dataSource;

    @Inject
    BrooklynMuseumApi brooklynMuseumApi;

    @Inject
    public FetchImagesTask(Application a) {
        ((BrooklynMuseumApplication) a).getDataManagerComponent().inject(this);
    }

    @SuppressLint("CommitPrefEdits")
    @Override
    protected Void doInBackground(Void... params) {
        JSONObject json = brooklynMuseumApi.fetchImages();
        try {
            JSONArray data = new JSONArray(json.get("data").toString());
            dataSource.insertFromJSONSync(data, BrooklynMuseumApi.IMAGES, ArchiveImage.class);
        } catch (JSONException e) {
            Log.e(TAG, "Failed to insert objects to database");
        }

        return null;
    }
}
