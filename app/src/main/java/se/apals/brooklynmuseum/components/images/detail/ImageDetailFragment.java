package se.apals.brooklynmuseum.components.images.detail;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import se.apals.brooklynmuseum.R;

public class ImageDetailFragment extends Fragment implements ImageDetailContract.View {


    private ImageDetailContract.Presenter mPresenter;

    public ImageDetailFragment() {
        // Required empty public constructor
    }

    public static ImageDetailFragment newInstance() {
        ImageDetailFragment fragment = new ImageDetailFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_image_detail, container, false);
    }

    @Override
    public void setPresenter(ImageDetailContract.Presenter presenter) {
        mPresenter = presenter;
    }
}
