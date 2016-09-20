package se.apals.brooklynmuseum.data;

import javax.inject.Singleton;

import dagger.Component;
import se.apals.brooklynmuseum.ApplicationModule;
import se.apals.brooklynmuseum.data.api.FetchImagesTask;

/**
 * Created by apals on 04/09/16.
 */
@Singleton
@Component(modules = {ApplicationModule.class, DataManagerModule.class})
public interface DataManagerComponent {

    DataManager getDataManager();

    // FetchImagesTask does not belong to anything downstream, so inject here
    void inject(FetchImagesTask task);

}
