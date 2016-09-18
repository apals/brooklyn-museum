package se.apals.brooklynmuseum.components.images.detail;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v4.util.Pair;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import java.util.ArrayList;

import javax.inject.Inject;

import se.apals.brooklynmuseum.BrooklynMuseumApplication;
import se.apals.brooklynmuseum.R;
import se.apals.brooklynmuseum.models.ArchiveImage;

public class ImageDetailActivity extends AppCompatActivity {

    public static final String KEY_IMAGE = "KEY_IMAGE";

    @Inject
    ImageDetailPresenter mImageDetailPresenter;

    public static void start(View transitionView, Context context, ArchiveImage image) {
        Intent i = new Intent(context, ImageDetailActivity.class);
        ArrayList<Pair<View, String>> pairs = new ArrayList<>();
        pairs.add(new Pair<>(transitionView, context.getString(R.string.image_detail_transition_name)));
        ActivityOptionsCompat options = ActivityOptionsCompat.makeSceneTransitionAnimation
                ((Activity) context, pairs.toArray(new Pair[pairs.size()]));

        i.putExtra(KEY_IMAGE, image.getStandard_size_url());

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
            context.startActivity(i, options.toBundle());
        }
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
