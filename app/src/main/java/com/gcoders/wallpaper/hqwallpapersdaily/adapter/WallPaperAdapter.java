package com.gcoders.wallpaper.hqwallpapersdaily.adapter;

import android.content.Context;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.gcoders.wallpaper.hqwallpapersdaily.R;
import com.gcoders.wallpaper.hqwallpapersdaily.model.wallpaper.ImageHit;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by kondareddygudipati on 1/21/18.
 */

public class WallPaperAdapter extends RecyclerView.Adapter<WallPaperAdapter.MyViewHolder> {

    private List<ImageHit> imageObjectList;
    private Context mContext;
    private ImageClick imageClick;
    private Picasso picasso;

    @Override
    public WallPaperAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View imageView = inflater.inflate(R.layout.adapter_wallpaper_layout, parent, false);

        return new MyViewHolder(imageView);
    }

    public WallPaperAdapter(Context mContext, List<ImageHit> imageObjectList, ImageClick imageClick, Picasso picasso){
        this.mContext = mContext;
        this.imageObjectList = imageObjectList;
        this.imageClick = imageClick;
        this.picasso = picasso;
    }

    @Override
    public void onBindViewHolder(final WallPaperAdapter.MyViewHolder holder, int position) {
        final ImageHit imageObject = imageObjectList.get(position);

        picasso
                .load(Uri.parse(imageObject.getWebformatURL()))
                .into(holder.imageViewForNow);

        holder.imageViewForNow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imageClick.onImageClick(imageObject);
            }
        });

    }

    @Override
    public int getItemCount() {
        return imageObjectList.size();
    }


    class MyViewHolder extends RecyclerView.ViewHolder {
        private ImageView imageViewForNow;
        MyViewHolder(View itemView) {
            super(itemView);
            imageViewForNow = itemView.findViewById(R.id.action_image_for_noew);
        }
    }

    public interface ImageClick {
        void onImageClick(ImageHit imageObject);
    }
}
