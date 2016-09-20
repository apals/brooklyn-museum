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
import se.apals.brooklynmuseum.models.ArchiveImage;

/**
 * Created by apals on 04/09/16.
 */

public final class BrooklynMuseumApi {

    private static final String TAG = BrooklynMuseumApi.class.getSimpleName();
    public static final String BASE_PATH = "https://www.brooklynmuseum.org/api/v2/";
    public static final String IMAGES = "archive/image?limit=30";

    private final SharedPreferences prefs;

    public BrooklynMuseumApi(SharedPreferences prefs) {
        this.prefs = prefs;
    }

    public JSONObject fetchImages() {
        return fetch(IMAGES);
    }

    private JSONObject fetch(@ApiCalls String endPoint) {
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
            url = new URL((Uri.parse(BASE_PATH + path).toString()));
        } catch (MalformedURLException e) {
            Log.e(TAG, "getUrl: ", e);
        }

        return url;
    }

    @StringDef({IMAGES})
    @Retention(RetentionPolicy.SOURCE)
    public @interface ApiCalls {
    }
}

