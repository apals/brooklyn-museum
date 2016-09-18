package se.apals.brooklynmuseum.components.images.detail;

import android.support.annotation.NonNull;

import javax.inject.Inject;

import se.apals.brooklynmuseum.components.images.master.ImagesContract;
import se.apals.brooklynmuseum.data.DataManager;

/**
 * Created by apals on 18/09/16.
 */
public class ImageDetailPresenter implements ImageDetailContract.Presenter {


    private final ImageDetailContract.View mView;
    private final DataManager mDataManager;

    @Inject
    public ImageDetailPresenter(@NonNull ImageDetailContract.View view, DataManager dataManager) {
        mView = view;
        mDataManager = dataManager;
    }

    @Inject
    void setupListeners() {
        mView.setPresenter(this);
    }


}
