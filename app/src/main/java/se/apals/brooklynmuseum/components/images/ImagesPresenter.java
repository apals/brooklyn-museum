package se.apals.brooklynmuseum.components.images;

import android.os.AsyncTask;
import android.preference.PreferenceManager;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.util.Log;

import java.util.List;

import javax.inject.Inject;

import se.apals.brooklynmuseum.data.DataManager;
import se.apals.brooklynmuseum.data.DataSource;
import se.apals.brooklynmuseum.data.api.FetchObjectsTask;
import se.apals.brooklynmuseum.models.BrooklynMuseumImage;

/**
 * Created by apals on 04/09/16.
 */
public class ImagesPresenter implements ImagesContract.Presenter {

    private static final String TAG = ImagesPresenter.class.getSimpleName();

    private ImagesContract.View imageView;
    private DataSource dataSource;

    @Inject
    public ImagesPresenter(@NonNull ImagesContract.View view, DataManager dataManager) {
        Log.d(TAG, "just created a presenter");
        this.imageView = view;
        this.dataSource = dataManager;
    }

    @Override
    public void start() {
        loadImages();
        new FetchObjectsTask(
                PreferenceManager.getDefaultSharedPreferences(((Fragment) this.imageView).getContext()),
                dataSource)
                .executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR);
    }

    @Override
    public void loadImages() {
        Log.d(TAG, "Loading images");

        dataSource.getImages().subscribe(this::onImagesLoaded);
    }

    @Override
    public void onImagesLoaded(List<BrooklynMuseumImage> images) {
        Log.d(TAG, "Images loaded..");
        imageView.setImages(images);
    }

    @Inject
    void setupListeners() {
        imageView.setPresenter(this);
    }
}
