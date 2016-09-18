package se.apals.brooklynmuseum.data;

import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;

import java.util.List;

import javax.inject.Inject;

import io.realm.Realm;
import io.realm.RealmObject;
import io.realm.RealmResults;
import rx.Observable;
import se.apals.brooklynmuseum.data.api.BrooklynMuseumApi;
import se.apals.brooklynmuseum.models.ArchiveImage;

/**
 * Created by apals on 04/09/16.
 */

public class DataManager implements DataSource {

    private Realm realm;
    private Observable<RealmResults<ArchiveImage>> imagesStream;

    @Inject
    public DataManager(Realm realm) {
        this.realm = realm;

        imagesStream = realm.where(ArchiveImage.class)
                .findAllAsync()
                .asObservable()
                .filter(RealmResults::isLoaded);
    }

    @Override
    public Observable<? extends List<ArchiveImage>> getImages() {
        Log.d("SUPERTAG", "Doing the get Images");
        return imagesStream;
    }

    @Override
    public void insertFromJSONSync(JSONArray json, @BrooklynMuseumApi.ApiCalls String endpoint, final Class<? extends RealmObject> clazz) throws JSONException {
        Log.d("SUPERTAG", "Inserting from JSONSYNC");
        // This method is run on a background thread, it needs its own realm instance
        Realm realmAsync = Realm.getDefaultInstance();
        // Add the objects to realm db, parsing from JSON
        Log.d("SUPERTAG", json.toString());


        final RealmResults<ArchiveImage> exhibitors = realmAsync.where(ArchiveImage.class).findAll();
        realmAsync.executeTransaction(realm1 -> exhibitors.deleteAllFromRealm());

        realmAsync.beginTransaction();
        try {
            realmAsync.createOrUpdateAllFromJson(ArchiveImage.class, json);
//        realmAsync.executeTransaction(realm1 -> realm1.createOrUpdateAllFromJson(ArchiveImage.class, json));
            realmAsync.commitTransaction();
        } catch (Exception e) {
            realmAsync.cancelTransaction();
        }

        realmAsync.close();


    }
}
