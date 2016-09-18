package se.apals.brooklynmuseum;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import javax.inject.Inject;

import se.apals.brooklynmuseum.components.images.master.DaggerImagesComponent;
import se.apals.brooklynmuseum.components.images.master.ImagesFragment;
import se.apals.brooklynmuseum.components.images.master.ImagesModule;
import se.apals.brooklynmuseum.components.images.master.ImagesPresenter;
import se.apals.brooklynmuseum.data.DataManagerComponent;

public class MainActivity extends AppCompatActivity {

    @Inject
    ImagesPresenter imagesPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ImagesFragment fragment = new ImagesFragment();

        DataManagerComponent dataManagerComponent = ((BrooklynMuseumApplication) getApplication()).getDataManagerComponent();

        DaggerImagesComponent.builder()
                .imagesModule(new ImagesModule(fragment))
                .dataManagerComponent(dataManagerComponent)
                .build().inject(this);

        getSupportFragmentManager().beginTransaction().replace(R.id.container, fragment).commit();

    }

}
