package se.apals.brooklynmuseum.components.images.master;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import se.apals.brooklynmuseum.R;
import se.apals.brooklynmuseum.components.images.detail.ImageDetailActivity;
import se.apals.brooklynmuseum.databinding.FragmentImagesBinding;
import se.apals.brooklynmuseum.models.ArchiveImage;

/**
 * Created by apals on 04/09/16.
 */
public class ImagesFragment extends Fragment implements ImagesContract.View {

    private static final String TAG = ImagesFragment.class.getSimpleName();

    private ImagesContract.Presenter presenter;
    private ImagesAdapter adapter;
    private ImageClickListener mOnImageClickListener = new ImageClickListener() {
        @Override
        public void onImageClick(View transitionView, ArchiveImage image) {
            presenter.onImageClicked(transitionView, image);
        }
    };


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        adapter = new ImagesAdapter(getContext(), mOnImageClickListener);
        presenter.start();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        FragmentImagesBinding binding = DataBindingUtil.inflate(inflater, R.layout.fragment_images, container, false);
        RecyclerView recyclerView = binding.imagesRecyclerview;

        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(getContext(), 2);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);

        return binding.getRoot();
    }

    @Override
    public void onResume() {
        super.onResume();
    }

    @Override
    public void setImages(List<ArchiveImage> images) {
        adapter.setDataSet(images);
    }

    @Override
    public void showImageDetailView(View transitionView, ArchiveImage image) {
        ImageDetailActivity.start(transitionView, getContext(), image);
    }

    @Override
    public void setPresenter(@NonNull ImagesContract.Presenter presenter) {
        this.presenter = presenter;
    }

    interface ImageClickListener {

        void onImageClick(View transitionView, ArchiveImage image);

    }
}
