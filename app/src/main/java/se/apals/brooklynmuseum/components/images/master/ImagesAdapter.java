package se.apals.brooklynmuseum.components.images.master;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;

import java.util.ArrayList;
import java.util.List;

import se.apals.brooklynmuseum.R;
import se.apals.brooklynmuseum.models.ArchiveImage;

/**
 * Created by apals on 05/09/16.
 */
public class ImagesAdapter extends RecyclerView.Adapter<ImagesAdapter.ViewHolder> {

    private static final String TAG = ImagesAdapter.class.getSimpleName();
    private final Context mContext;
    private final ImagesFragment.ImageClickListener mImageClickListener;
    private List<ArchiveImage> mDataSet = new ArrayList<>();

    public ImagesAdapter(Context context, ImagesFragment.ImageClickListener imageClickListener) {
        mContext = context;
        mImageClickListener = imageClickListener;
    }

    public void setDataSet(List<ArchiveImage> dataSet) {
        mDataSet.clear();
        mDataSet.addAll(dataSet);
        notifyDataSetChanged();
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(mContext).inflate(R.layout.images_list_item, parent, false));
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        final ArchiveImage image = mDataSet.get(position);
        holder.rootView.setOnClickListener(view -> {
            mImageClickListener.onImageClick(holder.rootView, image);
        });
        holder.title.setText(image.getTitle());
        Glide.with(mContext)
                .load(image.getStandard_size_url())
                .diskCacheStrategy(DiskCacheStrategy.SOURCE)
                .centerCrop()
                .crossFade()
                .into(holder.imageView);
    }

    @Override
    public int getItemCount() {
        return mDataSet.size();
    }


    public static class ViewHolder extends RecyclerView.ViewHolder {

        View rootView;
        ImageView imageView;
        TextView title;

        public ViewHolder(View itemView) {
            super(itemView);
            rootView = itemView;
            imageView = (ImageView) itemView.findViewById(R.id.image);
            title = (TextView) itemView.findViewById(R.id.title);
        }
    }
}
