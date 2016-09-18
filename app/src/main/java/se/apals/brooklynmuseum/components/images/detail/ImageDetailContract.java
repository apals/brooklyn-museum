package se.apals.brooklynmuseum.components.images.detail;

import se.apals.brooklynmuseum.BasePresenter;
import se.apals.brooklynmuseum.BaseView;

/**
 * Created by apals on 18/09/16.
 */
public interface ImageDetailContract {

    interface View extends BaseView<Presenter> {

    }

    interface Presenter extends BasePresenter.Detail {
    }

}
