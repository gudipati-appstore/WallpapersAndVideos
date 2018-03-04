package com.gcoders.wallpaper.hqwallpapersdaily.adapter;

import android.app.Activity;
import android.graphics.Rect;
import android.media.MediaPlayer;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;

import com.gcoders.wallpaper.hqwallpapersdaily.R;
import com.gcoders.wallpaper.hqwallpapersdaily.utils.HDUtils;
import com.gcoders.wallpaper.hqwallpapersdaily.view.custom.CustomTextureVideoView;
import com.squareup.picasso.Picasso;

import java.lang.ref.WeakReference;
import java.util.List;


/**
 * Created by Ahmed on 12/15/2015.
 */
public class VideoAdapter extends RecyclerView.Adapter<VideoAdapter.VideoViewHolder> {
    private List<String> videos;
    private List<String> pictureObjects;
    private WeakReference<Activity> activityWeakReference;
    private VideoViewHolder currentVideoViewHolder;
    private Picasso picassoObject;

    public VideoAdapter(Activity activity, List<String> videos, List<String> pictureObjects, Picasso picassoObject) {
        this.activityWeakReference = new WeakReference<>(activity);
        this.videos = videos;
        this.pictureObjects = pictureObjects;
        this.picassoObject = picassoObject;
    }

    private Activity getActivity() {
        return activityWeakReference.get();
    }

    @Override
    public VideoViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_item_video, parent, false);
        return new VideoViewHolder(view);
    }

    @Override
    public void onBindViewHolder(VideoViewHolder holder, int position) {
        holder.videoUrl = videos.get(position);
        holder.imageLoaderProgressBar.setVisibility(View.INVISIBLE);
        holder.videoImageView.setVisibility(View.VISIBLE);

        final String pictureObject = pictureObjects.get(position);

        picassoObject
                .load(Uri.parse(getVideoPreviewImage(pictureObject)))
                .into(holder.videoImageView);

    }

    @Override
    public void onViewRecycled(VideoViewHolder holder) {
        if (holder == currentVideoViewHolder) {
            currentVideoViewHolder = null;
            holder.stopVideo();
        }
        holder.videoView.stopPlayback();
        super.onViewRecycled(holder);

    }

    private String getVideoPreviewImage(String pictureID) {
        StringBuilder builder = new StringBuilder();
        builder.append("https://i.vimeocdn.com/video/")
                .append(pictureID)
                .append("_")
                .append("1280x720")
                .append(".jpg");
        return builder.toString();
    }

    @Override
    public int getItemCount() {
        return videos.size();
    }

    public void onScrolled(RecyclerView recyclerView) {
        if (currentVideoViewHolder != null) {
            currentVideoViewHolder.onScrolled(recyclerView);
        }
    }

    class VideoViewHolder extends RecyclerView.ViewHolder {
        ImageView videoPlayImageButton;
        ProgressBar imageLoaderProgressBar;
        CustomTextureVideoView videoView;
        ImageView videoImageView;

        String videoUrl;

        public VideoViewHolder(View view) {
            super(view);

            videoPlayImageButton = view.findViewById(R.id.video_play_img_btn);
            imageLoaderProgressBar = view.findViewById(R.id.lyt_image_loader_progress_bar);
            videoView = view.findViewById(R.id.video_feed_item_video);
            videoImageView = view.findViewById(R.id.video_feed_item_video_image);

            videoView.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
                @Override
                public void onPrepared(final MediaPlayer mp) {
                    Log.v("Video", "onPrepared" + videoView.getVideoPath());
                    int width = mp.getVideoWidth();
                    int height = mp.getVideoHeight();
                    videoView.setIsPrepared(true);
                    HDUtils.resizeView(videoView, HDUtils.getScreenWidth(getActivity()), HDUtils.getScreenWidth(getActivity()) * height / width);
                    if (currentVideoViewHolder == VideoViewHolder.this) {
                        videoImageView.setVisibility(View.GONE);
                        imageLoaderProgressBar.setVisibility(View.INVISIBLE);
                        videoView.setVisibility(View.VISIBLE);
                        videoView.seekTo(0);
                        videoView.start();
                    }
                }
            });
            videoView.setOnFocusChangeListener(new View.OnFocusChangeListener() {
                @Override
                public void onFocusChange(View v, boolean hasFocus) {
                    Log.v("Video", "onFocusChange" + hasFocus);
                    if (!hasFocus && currentVideoViewHolder == VideoViewHolder.this) {
                        stopVideo();
                    }

                }
            });
            videoView.setOnInfoListener(new MediaPlayer.OnInfoListener() {
                @Override
                public boolean onInfo(MediaPlayer mp, int what, int extra) {
                    Log.v("Video", "onInfo" + what + " " + extra);

                    return false;
                }
            });
            videoView.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                @Override
                public void onCompletion(MediaPlayer mp) {
                    Log.v("Video", "onCompletion");

                    videoImageView.setVisibility(View.VISIBLE);
                    videoPlayImageButton.setVisibility(View.VISIBLE);

                    if (videoView.getVisibility() == View.VISIBLE)
                        videoView.setVisibility(View.INVISIBLE);


                    imageLoaderProgressBar.setVisibility(View.INVISIBLE);
                    currentVideoViewHolder = null;
                }
            });
            videoPlayImageButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (currentVideoViewHolder != null && currentVideoViewHolder != VideoViewHolder.this) {
                        currentVideoViewHolder.videoView.pause();
                        currentVideoViewHolder.videoImageView.setVisibility(View.INVISIBLE);
                        currentVideoViewHolder.videoPlayImageButton.setVisibility(View.VISIBLE);
                        currentVideoViewHolder.imageLoaderProgressBar.setVisibility(View.INVISIBLE);
                        if (currentVideoViewHolder.videoView.getVisibility() == View.VISIBLE)
                            currentVideoViewHolder.videoView.setVisibility(View.INVISIBLE);


                        currentVideoViewHolder = null;
                    }

                    currentVideoViewHolder = VideoViewHolder.this;

                    videoPlayImageButton.setVisibility(View.INVISIBLE);
                    imageLoaderProgressBar.setVisibility(View.VISIBLE);
                    videoView.setVisibility(View.VISIBLE);
                    videoImageView.setVisibility(View.INVISIBLE);
                    if (!getVideoUrl().equals(videoView.getVideoPath())) {
                        videoView.setIsPrepared(false);
                        videoView.setVideoPath(getVideoUrl());
                        videoView.requestFocus();
                    } else {
                        if (videoView.isPrepared()) {
                            imageLoaderProgressBar.setVisibility(View.INVISIBLE);
                        } else {
                            imageLoaderProgressBar.setVisibility(View.VISIBLE);
                        }
                        videoView.requestFocus();
                        videoView.seekTo(0);
                        videoView.start();
                    }
                }
            });

        }

        public String getVideoUrl() {
            return videoUrl;
        }

        public void stopVideo() {
            Log.v("Video", "stopVideo");

            //imageView is within the visible window
            videoView.pause();
            if (videoView.getVisibility() == View.VISIBLE) {
                videoView.setVisibility(View.INVISIBLE);
            }
            videoImageView.setVisibility(View.VISIBLE);
            videoPlayImageButton.setVisibility(View.VISIBLE);
            imageLoaderProgressBar.setVisibility(View.INVISIBLE);
            currentVideoViewHolder = null;
        }

        public void onScrolled(RecyclerView recyclerView) {
            if (isViewNotVisible(videoPlayImageButton, recyclerView) || isViewNotVisible(imageLoaderProgressBar, recyclerView)) {
                //imageView is within the visible window
                stopVideo();
            }
        }

        public boolean isViewNotVisible(View view, RecyclerView recyclerView) {
            Rect scrollBounds = new Rect();
            recyclerView.getHitRect(scrollBounds);
            return view.getVisibility() == View.VISIBLE && !view.getLocalVisibleRect(scrollBounds);
        }
    }
}
