package se.apals.brooklynmuseum.data;

import javax.inject.Singleton;

import dagger.Component;
import se.apals.brooklynmuseum.ApplicationModule;

/**
 * Created by apals on 04/09/16.
 */
@Singleton
@Component(modules = {ApplicationModule.class, DataManagerModule.class})
public interface DataManagerComponent {

    DataManager getDataManager();

}
