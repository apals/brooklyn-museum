package se.apals.brooklynmuseum.components.images.master;

import android.app.Application;

import dagger.Module;
import dagger.Provides;
import se.apals.brooklynmuseum.components.images.master.ImagesContract;

/**
 * Created by apals on 04/09/16.
 */
@Module
public class ImagesModule {

    private final ImagesContract.View view;
    private final Application application;

    public ImagesModule(ImagesContract.View view, Application app) {
        this.view = view;
        this.application = app;
    }

    @Provides
    public Application providesApplication() {
        return application;
    }

    @Provides
    public ImagesContract.View provideImagesView() {
        return view;
    }

}

