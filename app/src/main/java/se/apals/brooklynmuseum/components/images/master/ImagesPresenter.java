package se.apals.brooklynmuseum.components.images.master;

import android.app.Application;
import android.os.AsyncTask;
import android.support.annotation.NonNull;
import android.util.Log;
import android.view.View;

import java.util.List;

import javax.inject.Inject;

import se.apals.brooklynmuseum.data.DataManager;
import se.apals.brooklynmuseum.data.DataSource;
import se.apals.brooklynmuseum.data.api.FetchImagesTask;
import se.apals.brooklynmuseum.models.ArchiveImage;

/**
 * Created by apals on 04/09/16.
 */
public class ImagesPresenter implements ImagesContract.Presenter {

    private static final String TAG = ImagesPresenter.class.getSimpleName();

    private Application application;
    private ImagesContract.View imageView;
    private DataSource dataSource;

    @Inject
    public ImagesPresenter(@NonNull ImagesContract.View view, DataManager dataManager, Application application) {
        this.imageView = view;
        this.dataSource = dataManager;
        this.application = application;
    }

    @Override
    public void start() {
        loadImages();
        new FetchImagesTask(application)
                .executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR);
    }

    @Override
    public void loadImages() {
        Log.d(TAG, "Loading images");
        dataSource.getImages().subscribe(this::onImagesLoaded);
    }

    @Override
    public void onImagesLoaded(List<ArchiveImage> images) {
        Log.d(TAG, "Images loaded");
        imageView.setImages(images);
    }

    @Override
    public void onImageClicked(View transitionView, ArchiveImage image) {
        imageView.showImageDetailView(transitionView, image);
    }

    @Inject
    void setupListeners() {
        imageView.setPresenter(this);
    }
}
