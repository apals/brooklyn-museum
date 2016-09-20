package se.apals.brooklynmuseum.components.images.detail;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.resource.drawable.GlideDrawable;
import com.bumptech.glide.request.target.ImageViewTarget;

import se.apals.brooklynmuseum.R;
import se.apals.brooklynmuseum.databinding.FragmentImageDetailBinding;

public class ImageDetailFragment extends Fragment implements ImageDetailContract.View {


    private ImageDetailContract.Presenter mPresenter;
    private FragmentImageDetailBinding binding;
    private String mImageUrl;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle extras = getActivity().getIntent().getExtras();
        mImageUrl = extras.getString(ImageDetailActivity.KEY_IMAGE);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_image_detail, container, false);

        //Load image
        Glide.with(this)
                .load(mImageUrl)
                .diskCacheStrategy(DiskCacheStrategy.SOURCE)
                .dontAnimate()
                .centerCrop()
                .into(new ImageViewTarget<GlideDrawable>(binding.imageDetailImageview) {
                          @Override
                          protected void setResource(GlideDrawable resource) {
                              binding.imageDetailImageview.setImageDrawable(resource);
                              getActivity().supportStartPostponedEnterTransition();
                          }
                      }
                );

        return binding.getRoot();
    }

    @Override
    public void setPresenter(ImageDetailContract.Presenter presenter) {
        mPresenter = presenter;
    }
}
