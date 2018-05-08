package com.gcoders.wallpaper.hqwallpapersdaily.service;


import com.gcoders.wallpaper.hqwallpapersdaily.model.video.VideoModelObject;
import com.gcoders.wallpaper.hqwallpapersdaily.model.wallpaper.ImageModelObject;

import java.util.Map;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.QueryMap;

/**

 */
public interface HQResourceSystemAPI {

    @GET("/api/")
    Call<ImageModelObject> getWallPapers(@QueryMap Map<String, String> options);

    @GET("/api/videos")
    Call<VideoModelObject> getVideos(@QueryMap Map<String, String> options);
}
