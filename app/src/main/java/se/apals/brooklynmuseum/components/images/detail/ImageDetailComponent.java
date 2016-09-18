package se.apals.brooklynmuseum.components.images.detail;

import dagger.Component;
import se.apals.brooklynmuseum.data.DataManagerComponent;
import se.apals.brooklynmuseum.utils.FragmentScoped;

/**
 * Created by apals on 18/09/16.
 */

@FragmentScoped
@Component(dependencies = DataManagerComponent.class, modules = ImageDetailModule.class )
public interface ImageDetailComponent {

    void inject(ImageDetailActivity imageDetailActivity);

}
