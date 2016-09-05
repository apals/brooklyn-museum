package se.apals.brooklynmuseum.data;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import io.realm.Realm;

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

}
