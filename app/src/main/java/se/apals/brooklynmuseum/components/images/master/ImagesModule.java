package se.apals.brooklynmuseum.components.images.master;

import dagger.Module;
import dagger.Provides;
import se.apals.brooklynmuseum.components.images.master.ImagesContract;

/**
 * Created by apals on 04/09/16.
 */
@Module
public class ImagesModule {

    private final ImagesContract.View view;

    public ImagesModule(ImagesContract.View view) {
        this.view = view;
    }

    @Provides
    public ImagesContract.View provideImagesView() {
        return view;
    }

}

