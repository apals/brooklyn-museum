package se.apals.brooklynmuseum.components.images;

import dagger.Module;
import dagger.Provides;

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

