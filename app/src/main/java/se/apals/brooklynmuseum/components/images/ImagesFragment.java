package se.apals.brooklynmuseum.components.images;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import se.apals.brooklynmuseum.R;
import se.apals.brooklynmuseum.models.BrooklynMuseumImage;

/**
 * Created by apals on 04/09/16.
 */
public class ImagesFragment extends Fragment implements ImagesContract.View {

    private static final String TAG = ImagesFragment.class.getSimpleName();

    private ImagesContract.Presenter presenter;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_images, container, false);
    }

    @Override
    public void onResume() {
        super.onResume();
        presenter.start();
    }

    @Override
    public void setImages(List<BrooklynMuseumImage> images) {
        Log.d(TAG, "Setting images: " + images.size());

        TextView tv = ((TextView) getView().findViewById(R.id.textview_images));
        tv.setText("");
        for (BrooklynMuseumImage i : images) {
            tv.setText(tv.getText() + "\n" + i.getTitle());
        }
    }

    @Override
    public void setPresenter(@NonNull ImagesContract.Presenter presenter) {
        this.presenter = presenter;
    }
}
