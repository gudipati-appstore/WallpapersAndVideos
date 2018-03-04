package com.gcoders.wallpaper.hqwallpapersdaily.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.gcoders.wallpaper.hqwallpapersdaily.R;

import java.util.List;

/**
 * Created by kondareddygudipati on 1/21/18.
 */

public class WallpaperOptionsAdapter extends RecyclerView.Adapter<WallpaperOptionsAdapter.MyViewHolder> {

    private List<String> optionsList;
    private Context mContext;
    private ButtonClick buttonClick;

    public WallpaperOptionsAdapter(Context mContext, List<String> optionsList, ButtonClick buttonClick) {
        this.mContext = mContext;
        this.optionsList = optionsList;
        this.buttonClick = buttonClick;
    }

    @Override
    public WallpaperOptionsAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View imageView = inflater.inflate(R.layout.wallpaper_option_row, parent, false);

        return new MyViewHolder(imageView);
    }

    @Override
    public void onBindViewHolder(final WallpaperOptionsAdapter.MyViewHolder holder, int position) {
        final String optionContent = optionsList.get(position);

        holder.search_category_cntent.setText(optionContent);


        holder.imageViewForNow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                buttonClick.onButtonClick(optionContent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return optionsList.size();
    }


    public interface ButtonClick {
        void onButtonClick(String text);
    }

    class MyViewHolder extends RecyclerView.ViewHolder {
        private ImageView imageViewForNow;
        private TextView search_category_cntent;

        MyViewHolder(View itemView) {
            super(itemView);
            imageViewForNow = itemView.findViewById(R.id.action_homepage_image);
            search_category_cntent = itemView.findViewById(R.id.search_category_cntent);
        }
    }
}
