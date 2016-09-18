package se.apals.brooklynmuseum.data.api;

import android.content.SharedPreferences;
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
import se.apals.brooklynmuseum.models.ArchiveImage;

/**
 * Created by apals on 04/09/16.
 */

public final class BrooklynMuseumApi {

    private static final String TAG = BrooklynMuseumApi.class.getSimpleName();
    public static final String BASE_PATH = "https://www.brooklynmuseum.org/api/v2/archive/image?limit=10";
    public static final String OBJECT = "archive/image?limit=1";

    private static BrooklynMuseumApi sInstance;

    public static BrooklynMuseumApi getInstance() {
        if (sInstance == null) {
            sInstance = new BrooklynMuseumApi();
        }
        return sInstance;
    }

    public JSONObject fetchImages(DataSource dataSource, SharedPreferences preferences) {
        return fetch(dataSource, OBJECT, preferences, ArchiveImage.class);
    }

    private JSONObject fetch(DataSource dataSource, @ApiCalls String endPoint, SharedPreferences prefs, Class<? extends RealmObject> clazz) {
        String response = HTTPUtils.get(getUrl(endPoint), prefs, endPoint);
        try {
            return new JSONObject(response);
        } catch (JSONException e) {
            return null;
        }
    }

    /**
     * Build the entire request URL for a specific @ApiCall
     *
     * @param path path to the api
     * @return The request URl object
     */
    private static URL getUrl(@ApiCalls String path) {
        URL url = null;
        try {
            url = new URL(BASE_PATH);
        } catch (MalformedURLException e) {
            Log.e(TAG, "getUrl: ", e);
        }

        return url;
    }

    public void persistProperty(DataSource dataSource, JSONObject json, final Class<? extends RealmObject> clazz, @ApiCalls String endpoint) throws JSONException {
        if (json == null) return;

        if (endpoint.equals(OBJECT)) {
            JSONArray data = new JSONArray(json.get("data").toString());
            dataSource.insertFromJSONSync(data, endpoint, clazz);
        }
    }

    @StringDef({OBJECT})
    @Retention(RetentionPolicy.SOURCE)
    public @interface ApiCalls {
    }
}

