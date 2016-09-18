package se.apals.brooklynmuseum.data;

import org.json.JSONArray;
import org.json.JSONException;

import java.util.List;

import io.realm.RealmObject;
import rx.Observable;
import se.apals.brooklynmuseum.models.ArchiveImage;

/**
 * Created by apals on 04/09/16.
 */
public interface DataSource {

    Observable<? extends List<ArchiveImage>> getImages();

    void insertFromJSONSync(JSONArray json, String endpoint, Class<? extends RealmObject> clazz) throws JSONException;
}
