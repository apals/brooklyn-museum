package se.apals.brooklynmuseum.components.images.master;

import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.support.annotation.NonNull;
import android.util.Log;

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

    private ImagesContract.View imageView;
    private DataSource dataSource;
    private SharedPreferences preferences;

    @Inject
    public ImagesPresenter(@NonNull ImagesContract.View view, DataManager dataManager, SharedPreferences preferences) {
        Log.d(TAG, "just created a presenter");
        this.imageView = view;
        this.dataSource = dataManager;
        this.preferences = preferences;
    }

    @Override
    public void start() {
        loadImages();
        new FetchImagesTask(
                preferences,
                dataSource)
                .executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR);
    }

    @Override
    public void loadImages() {
        Log.d(TAG, "Loading images");
        dataSource.getImages().subscribe(this::onImagesLoaded);
    }

    @Override
    public void onImagesLoaded(List<ArchiveImage> images) {
        Log.d(TAG, "Images loaded..");
        for (ArchiveImage a : images) {
            Log.d(TAG, "" + a.getStandard_size_url());
        }

        imageView.setImages(images);
    }

    @Inject
    void setupListeners() {
        imageView.setPresenter(this);
    }
}
