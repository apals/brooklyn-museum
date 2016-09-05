package se.apals.brooklynmuseum.data;

import org.json.JSONException;

import java.util.List;

import io.realm.RealmObject;
import rx.Observable;
import se.apals.brooklynmuseum.models.BrooklynMuseumImage;

/**
 * Created by apals on 04/09/16.
 */
public interface DataSource {

    Observable<? extends List<BrooklynMuseumImage>> getImages();

    void insertFromJSONSync(String json, String endpoint, Class<? extends RealmObject> clazz) throws JSONException;
}
