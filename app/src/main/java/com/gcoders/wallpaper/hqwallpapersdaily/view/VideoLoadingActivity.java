package com.gcoders.wallpaper.hqwallpapersdaily.view;

import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.support.v7.widget.Toolbar;
import android.widget.ImageView;

import com.gcoders.wallpaper.hqwallpapersdaily.BaseActivity;
import com.gcoders.wallpaper.hqwallpapersdaily.R;
import com.gcoders.wallpaper.hqwallpapersdaily.adapter.VideoAdapter;
import com.gcoders.wallpaper.hqwallpapersdaily.model.video.VideoHit;
import com.gcoders.wallpaper.hqwallpapersdaily.model.video.VideoModelObject;
import com.gcoders.wallpaper.hqwallpapersdaily.storage.DataStore;
import com.gcoders.wallpaper.hqwallpapersdaily.view.custom.SimpleDividerItemDecoration;

import java.util.ArrayList;
import java.util.List;

public class VideoLoadingActivity extends BaseActivity {

    private ImageView imageView;
    private RecyclerView recycler_view_videos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video_loading_layout);

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
        recycler_view_videos = findViewById(R.id.recycler_view_videos);

        final VideoAdapter adapter = new VideoAdapter(this, getVideoObjects(), getPictureObjects(), getPicassoObject());

        recycler_view_videos.setLayoutManager(new StaggeredGridLayoutManager(1, RecyclerView.VERTICAL));
        recycler_view_videos.addItemDecoration(new SimpleDividerItemDecoration(this));
        recycler_view_videos.setAdapter(adapter);
        recycler_view_videos.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
            }

            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                if (newState == RecyclerView.SCROLL_STATE_DRAGGING || newState == RecyclerView.SCROLL_STATE_SETTLING || newState == RecyclerView.SCROLL_STATE_IDLE) {
                    adapter.onScrolled(recyclerView);
                }
            }

        });

        loadBackdrop();
    }

    private List<String> getVideoObjects() {
        List<String> videoURLs = new ArrayList<>();
        VideoModelObject videoModelObject = (VideoModelObject) DataStore.getInstance().getInfo("VIDEO_LIST_FROM_SERVICE");
        List<VideoHit> videoHitsList = videoModelObject.getHits();
        for(VideoHit videoHit: videoHitsList) {
            if( null != videoHit.getVideos().getMedium() ) {
                videoURLs.add(videoHit.getVideos().getMedium().getUrl());
            }
        }
        return videoURLs;
    }

    private List<String> getPictureObjects(){
        List<String> pictureObjects = new ArrayList<>();
        VideoModelObject videoModelObject = (VideoModelObject) DataStore.getInstance().getInfo("VIDEO_LIST_FROM_SERVICE");
        List<VideoHit> videoHitsList = videoModelObject.getHits();
        for(VideoHit videoHit: videoHitsList) {
            if( null != videoHit.getPictureId() ) {
                pictureObjects.add(videoHit.getPictureId());
            }
        }
        return pictureObjects;
    }

    private void loadBackdrop() {
        imageView.setImageDrawable(getDrawable(R.drawable.shape_drawable));
    }

}
