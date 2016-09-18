package se.apals.brooklynmuseum.components.images;

import java.util.List;

import se.apals.brooklynmuseum.BasePresenter;
import se.apals.brooklynmuseum.BaseView;
import se.apals.brooklynmuseum.models.ArchiveImage;

/**
 * Created by apals on 04/09/16.
 */
public class ImagesContract {

    public interface View extends BaseView<Presenter> {

        void setImages(List<ArchiveImage> images);

    }

    public interface Presenter extends BasePresenter.Master {

        void start();

        void loadImages();

        void onImagesLoaded(List<ArchiveImage> images);

    }
}
