package se.apals.brooklynmuseum;

import android.app.Application;
import android.content.Context;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import io.realm.Realm;

/**
 * Created by apals on 04/09/16.
 */
@Module
public final class ApplicationModule {

    private final Context mContext;
    private final Application application;

    ApplicationModule(Application application) {
        this.application = application;
        mContext = application.getApplicationContext();
    }

    @Provides
    Context provideContext() {
        return mContext;
    }

    @Provides
    Application provideApplication() {
        return application;
    }

    @Provides
    @Singleton
    Realm provideRealm() {
        return Realm.getDefaultInstance();
    }

}
