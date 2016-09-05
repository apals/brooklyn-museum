package se.apals.brooklynmuseum.data.api;

import android.content.SharedPreferences;
import android.net.Uri;
import android.support.annotation.StringDef;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.net.MalformedURLException;
import java.net.URL;

import io.realm.RealmObject;
import se.apals.brooklynmuseum.data.DataSource;
import se.apals.brooklynmuseum.models.BrooklynMuseumImage;

/**
 * Created by apals on 04/09/16.
 */

public final class BrooklynMuseumApi {

    public static final String BASE_PATH = "https://www.brooklynmuseum.org/api/v2/";
    public static final String OBJECT = "object";
    private static final String TAG = BrooklynMuseumApi.class.getSimpleName();

    public static void fetchObjects(DataSource dataSource, SharedPreferences preferences) {
        fetch(dataSource, OBJECT, preferences, BrooklynMuseumImage.class);
    }

    private static void fetch(DataSource dataSource, @ApiCalls String endPoint, SharedPreferences prefs, Class<? extends RealmObject> clazz) {
        String response = HTTPUtils.get(getUrl(endPoint), prefs, endPoint);
        try {
            // Put the results in the database in the database
            persistProperty(dataSource, response, clazz, endPoint);
            Log.d(TAG, endPoint + " stored in database!");
        } catch (JSONException e) {
            Log.e(TAG, "doInBackground: ", e);
            // Something went wrong when inserting, make sure the etag is cleared!
            // Note: commit since we are on a background thread
            prefs.edit().putString(endPoint, "").commit();
        }
    }

    /*
        Build the entire request URL for a specific @ApiCall
     */
    private static URL getUrl(@ApiCalls String path) {
        URL url = null;
        try {
            url = new URL((Uri.parse(BASE_PATH)
                    .buildUpon()
                    .appendPath(path)
                    .build()).toString());
        } catch (MalformedURLException e) {
            Log.e(TAG, "getUrl: ", e);
        }

        return url;
    }

    private static void persistProperty(DataSource dataSource, String jsonString, final Class<? extends RealmObject> clazz, @ApiCalls String endpoint) throws JSONException {
        if (jsonString == null || jsonString.isEmpty()) {
            return;
        }

        if (endpoint.equals(OBJECT)) {
            JSONObject j = new JSONObject(jsonString);
            JSONArray a = new JSONArray();
            dataSource.insertFromJSONSync(j.get("data").toString(), endpoint, clazz);

        }

//        // Get the JSON array
//        JSONObject wrapper = new JSONObject(jsonString);
//        final String json = wrapper.getString(endpoint);
//        dataSource.insertFromJSONSync(json, endpoint, clazz);
    }

    @StringDef({OBJECT})
    @Retention(RetentionPolicy.SOURCE)
    public @interface ApiCalls {
    }
}

