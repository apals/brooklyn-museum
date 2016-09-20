package se.apals.brooklynmuseum.data;

import android.app.Application;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import io.realm.Realm;
import se.apals.brooklynmuseum.data.api.BrooklynMuseumApi;

/**
 * Created by apals on 04/09/16.
 */
@Module
public class DataManagerModule {

    @Singleton
    @Provides
    DataManager providesDataManager(Realm realm) {
        return new DataManager(realm);
    }

    @Singleton
    @Provides
    BrooklynMuseumApi providesBrooklynMuseumApi(SharedPreferences prefs) {
        return new BrooklynMuseumApi(prefs);
    }

    @Provides
    @Singleton
    // Application reference must come from AppModule.class
    SharedPreferences providesSharedPreferences(Application application) {
        return PreferenceManager.getDefaultSharedPreferences(application);
    }


}
