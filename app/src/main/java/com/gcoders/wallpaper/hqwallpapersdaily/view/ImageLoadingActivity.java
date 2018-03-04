package com.gcoders.wallpaper.hqwallpapersdaily.view;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.support.v7.widget.Toolbar;
import android.widget.ImageView;

import com.gcoders.wallpaper.hqwallpapersdaily.BaseActivity;
import com.gcoders.wallpaper.hqwallpapersdaily.R;
import com.gcoders.wallpaper.hqwallpapersdaily.adapter.WallPaperAdapter;
import com.gcoders.wallpaper.hqwallpapersdaily.model.wallpaper.ImageHit;
import com.gcoders.wallpaper.hqwallpapersdaily.model.wallpaper.ImageModelObject;
import com.gcoders.wallpaper.hqwallpapersdaily.storage.DataStore;
import com.gcoders.wallpaper.hqwallpapersdaily.utils.HDUtils;

import java.util.List;

public class ImageLoadingActivity extends BaseActivity {

    private ImageView imageView;
    private RecyclerView recycler_view_images;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_loading_layout);

        final Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        imageView = findViewById(R.id.backdrop);

        bindViewAndEvents();
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }

    private void bindViewAndEvents() {
        recycler_view_images = findViewById(R.id.recycler_view_images);

        WallPaperAdapter adapter = new WallPaperAdapter(this, getImageObjects(), new WallPaperAdapter.ImageClick() {
            @Override
            public void onImageClick(ImageHit imageObject) {
                navigateToImageDetailActivity(imageObject);
            }
        }, getPicassoObject());


        recycler_view_images.setLayoutManager(new StaggeredGridLayoutManager(1, RecyclerView.VERTICAL));


        recycler_view_images.setAdapter(adapter);

        loadBackdrop();

    }

    private List<ImageHit> getImageObjects() {
        ImageModelObject imageInfo = (ImageModelObject) DataStore.getInstance().getInfo("IMAGE_LIST_FROM_SERVICE");
        return HDUtils.removeDuplicates(imageInfo.getHits());
    }

    private void navigateToImageDetailActivity(ImageHit imageObject) {
        Intent intent = new Intent(this, ImageDetailActivity.class);
        Bundle bundle = new Bundle();
        bundle.putSerializable("imageObject", imageObject);
        intent.putExtras(bundle);
        startActivity(intent);

    }

    private void loadBackdrop() {
        imageView.setImageDrawable(getDrawable(R.drawable.shape_drawable));
    }

}
