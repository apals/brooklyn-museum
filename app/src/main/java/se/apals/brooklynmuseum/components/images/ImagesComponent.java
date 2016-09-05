package se.apals.brooklynmuseum.components.images;

import dagger.Component;
import se.apals.brooklynmuseum.MainActivity;
import se.apals.brooklynmuseum.data.DataManagerComponent;
import se.apals.brooklynmuseum.utils.FragmentScoped;

/**
 * Created by apals on 04/09/16.
 */
@FragmentScoped
@Component(dependencies = DataManagerComponent.class,
        modules = {ImagesModule.class})
public interface ImagesComponent {

    void inject(MainActivity activity);

}