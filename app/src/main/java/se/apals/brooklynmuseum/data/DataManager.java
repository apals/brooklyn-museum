package se.apals.brooklynmuseum.data;

import android.util.Log;

import org.json.JSONException;

import java.util.List;

import javax.inject.Inject;

import io.realm.Realm;
import io.realm.RealmObject;
import io.realm.RealmResults;
import rx.Observable;
import se.apals.brooklynmuseum.data.api.BrooklynMuseumApi;
import se.apals.brooklynmuseum.models.BrooklynMuseumImage;

/**
 * Created by apals on 04/09/16.
 */

public class DataManager implements DataSource {

    private Realm realm;
    private Observable<RealmResults<BrooklynMuseumImage>> imagesStream;

    @Inject
    public DataManager(Realm realm) {
        this.realm = realm;

        imagesStream = realm.where(BrooklynMuseumImage.class)
                .findAllAsync()
                .asObservable()
                .filter(RealmResults::isLoaded);
    }

    @Override
    public Observable<? extends List<BrooklynMuseumImage>> getImages() {
        Log.d("SUPERTAG", "Doing the get Images");
        return imagesStream;
    }

    @Override
    public void insertFromJSONSync(String json, @BrooklynMuseumApi.ApiCalls String endpoint, final Class<? extends RealmObject> clazz) throws JSONException {
        Log.d("SUPERTAG", "Inserting from JSONSYNC");
        // This method is run on a background thread, it needs its own realm instance
        Realm realmAsync = Realm.getDefaultInstance();
        // Add the objects to realm db, parsing from JSON
        Log.d("SUPERTAG", json);
        realmAsync.executeTransaction(realm1 -> realm1.createOrUpdateAllFromJson(clazz, json));
        realmAsync.close();

    }
}
