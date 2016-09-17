package se.apals.brooklynmuseum.components.images;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.drawable.GlideDrawable;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.target.Target;

import java.util.List;

import se.apals.brooklynmuseum.R;
import se.apals.brooklynmuseum.models.BrooklynMuseumImage;

/**
 * Created by apals on 05/09/16.
 */
public class ImagesAdapter extends RecyclerView.Adapter<ImagesAdapter.ViewHolder> {

    private final Context mContext;
    private List<BrooklynMuseumImage> mDataSet;

    public ImagesAdapter(Context context) {
        mContext = context;
    }

    public void setDataSet(List<BrooklynMuseumImage> dataSet) {
        mDataSet = dataSet;
        notifyDataSetChanged();
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(mContext).inflate(R.layout.images_list_item, parent, false));
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        BrooklynMuseumImage image = mDataSet.get(position);
        holder.title.setText(image.getTitle());
        Glide.with(mContext).load("http://i.imgur.com/mQfbH5O.png").error(R.drawable.ic_accessibility_black_24dp).listener(new RequestListener<String, GlideDrawable>() {
            @Override
            public boolean onException(Exception e, String model, Target<GlideDrawable> target, boolean isFirstResource) {
                Log.d("TAG", "Resource failed to load with reason: " + e.getMessage());
                return false;
            }

            @Override
            public boolean onResourceReady(GlideDrawable resource, String model, Target<GlideDrawable> target, boolean isFromMemoryCache, boolean isFirstResource) {
                Log.d("TAG", "Resource is now ready");
                return false;
            }
        })
                .into(holder.imageView);
    }

    @Override
    public int getItemCount() {
        return mDataSet == null ? 0 : mDataSet.size();
    }


    public static class ViewHolder extends RecyclerView.ViewHolder {

        ImageView imageView;
        TextView title;

        public ViewHolder(View itemView) {
            super(itemView);
            imageView = (ImageView) itemView.findViewById(R.id.image);
            title = (TextView) itemView.findViewById(R.id.title);
        }
    }
}
