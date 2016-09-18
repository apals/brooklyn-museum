package se.apals.brooklynmuseum.components.images.detail;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import javax.inject.Inject;

import se.apals.brooklynmuseum.BrooklynMuseumApplication;
import se.apals.brooklynmuseum.R;

public class ImageDetailActivity extends AppCompatActivity {

    @Inject
    ImageDetailPresenter mImageDetailPresenter;

    public static void start(Context context) {
        Intent i = new Intent(context, ImageDetailActivity.class);
        context.startActivity(i);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_detail);

        ImageDetailFragment f = (ImageDetailFragment) getSupportFragmentManager().findFragmentById(R.id.image_detail_fragment);
        DaggerImageDetailComponent.builder()
                .imageDetailModule(new ImageDetailModule(f))
                .dataManagerComponent(((BrooklynMuseumApplication) getApplication()).getDataManagerComponent())
                .build()
                .inject(this);

    }
}
