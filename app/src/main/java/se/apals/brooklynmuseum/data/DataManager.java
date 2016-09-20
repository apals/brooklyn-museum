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

    public DataManager(Realm realm) {
        this.realm = realm;

        imagesStream = realm.where(ArchiveImage.class)
                .findAllAsync()
                .asObservable()
                .filter(RealmResults::isLoaded);
    }

    @Override
    public Observable<? extends List<ArchiveImage>> getImages() {
        return imagesStream;
    }

    @Override
    public void insertFromJSONSync(JSONArray json, @BrooklynMuseumApi.ApiCalls String endpoint, final Class<? extends RealmObject> clazz) throws JSONException {
        // This method is run on a background thread, it needs its own realm instance
        Realm realmAsync = Realm.getDefaultInstance();

        // clear the db since this method is only called when
        // we have updates to the data
        final RealmResults<ArchiveImage> images = realmAsync.where(ArchiveImage.class).findAll();
        realmAsync.executeTransaction(realm1 -> images.deleteAllFromRealm());

        // Add the objects to realm db, parsing from JSON
        realmAsync.executeTransaction(realm1 -> realm1.createOrUpdateAllFromJson(ArchiveImage.class, json));


        realmAsync.close();
    }
}
