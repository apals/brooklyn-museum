package se.apals.brooklynmuseum.components.images.detail;

import dagger.Module;
import dagger.Provides;
import se.apals.brooklynmuseum.components.images.master.ImagesContract;

/**
 * Created by apals on 04/09/16.
 */
@Module
public class ImageDetailModule {

    private final ImageDetailContract.View view;

    public ImageDetailModule(ImageDetailContract.View view) {
        this.view = view;
    }

    @Provides
    public ImageDetailContract.View provideImagesView() {
        return view;
    }

}

