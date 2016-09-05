package se.apals.brooklynmuseum;

import android.app.Application;

import io.realm.Realm;
import io.realm.RealmConfiguration;
import se.apals.brooklynmuseum.data.DaggerDataManagerComponent;
import se.apals.brooklynmuseum.data.DataManagerComponent;

/**
 * Created by apals on 04/09/16.
 */
public class BrooklynMuseumApplication extends Application {

    private DataManagerComponent dataManagerComponent;

    @Override
    public void onCreate() {
        super.onCreate();

        RealmConfiguration config = new RealmConfiguration.Builder(this)
                .deleteRealmIfMigrationNeeded()
                .build();
        Realm.setDefaultConfiguration(config);

        dataManagerComponent = DaggerDataManagerComponent.builder()
                .applicationModule(new ApplicationModule(getApplicationContext()))
                .build();
    }

    public DataManagerComponent getDataManagerComponent() {
        return dataManagerComponent;
    }

}
