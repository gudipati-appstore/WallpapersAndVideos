package com.gcoders.wallpaper.hqwallpapersdaily.service;

import android.util.Log;

import com.gcoders.wallpaper.hqwallpapersdaily.model.video.VideoModelObject;
import com.gcoders.wallpaper.hqwallpapersdaily.model.wallpaper.ImageModelObject;
import com.gcoders.wallpaper.hqwallpapersdaily.storage.DataStore;
import com.google.gson.Gson;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Headers;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;

/**
 * Created by kondareddygudipati on 1/22/18.
 */

public class MyServiceManager implements ServiceManager {

    //I Have used my own key to get images from Thirdparty site(Pixabay). Please get your own to run this project
    private static final String API_KEY = "XXXXX-XXXXXXXXXXXXXXXXXX";
    private static final String TAG = MyServiceManager.class.getName();
    private static MyServiceManager myServiceManager = new MyServiceManager();
    private OkHttpClient okHttpClient;
    //  private static LruCache<String, String> responseCache = new LruCache<>(25);

    private MyServiceManager() {

    }

    public static MyServiceManager getInstance() {
        if (myServiceManager == null) {
            return new MyServiceManager();
        }
        return myServiceManager;
    }


    @Override
    public void callService(final String queryString, final String category, OkHttpClient okHttpClient, final ServiceManagerCallBack callBack) {

        /*final String cachedResponse = responseCache.get(queryString+category);
        if(cachedResponse != null){
            saveResponse(cachedResponse, category);
            return;
        }*/

        this.okHttpClient = okHttpClient;
        callBack.showLoading(true);

        StringBuilder urlBuilder = null;
        try {
            urlBuilder = prepareURLToFetchInfo(queryString, category);
        } catch (IOException e) {
            e.printStackTrace();
        }

        Request request
                = new Request.Builder()
                .url(urlBuilder.toString())
                .build();

        Call call = okHttpClient.newCall(request);
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                callBack.showLoading(false);
                callBack.showErrorMessage(e.getMessage());
                e.printStackTrace();
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                callBack.showLoading(false);

                try (ResponseBody responseBody = response.body()) {
                    if (!response.isSuccessful()) {
                        throw new IOException("Unexpected code " + response);
                    }

                    Headers responseHeaders = response.headers();
                    for (int i = 0, size = responseHeaders.size(); i < size; i++) {
                        System.out.println(responseHeaders.name(i) + ": " + responseHeaders.value(i));
                    }


                    String respBody = null;
                    if (response.body() != null) {
                        respBody = response.body().string();
                        response.body().close();
                    }

                    String jsonInString = respBody;

                    if (saveResponse(jsonInString, category)) {
                        //   responseCache.put(queryString+category, jsonInString);
                        callBack.onSuccess();
                    } else {
                        callBack.showErrorMessage("No Results found. Please try a different search..!");
                    }

                } catch (IOException exception) {
                    Log.d(TAG, exception.getMessage());
                    callBack.showErrorMessage("We were unable to complete your request. Please try again..!");
                }
            }
        });
    }


    @Override
    public boolean isServiceCallInProgress() {
        return null != okHttpClient && okHttpClient.dispatcher().queuedCallsCount() > 0;
    }

    @Override
    public void cancelAllServiceCalls() {
        if (null != okHttpClient && null != okHttpClient.dispatcher()) {
            okHttpClient.dispatcher().cancelAll();
        }
    }

    private boolean saveResponse(String jsonInString, String category) {
        boolean flag = false;
        switch (category) {
            case "IMAGE":
                flag = saveImageResponse(jsonInString);
                break;
            case "VIDEO":
                flag = saveVideoResponse(jsonInString);
        }
        return flag;
    }

    private boolean saveImageResponse(String jsonInString) {
        Gson gson = new Gson();
        ImageModelObject imageModelObject = gson.fromJson(jsonInString, ImageModelObject.class);
        if (null != imageModelObject && imageModelObject.getHits().size() > 0) {
            DataStore.getInstance().setInfo("IMAGE_LIST_FROM_SERVICE", imageModelObject);
            return true;
        }
        return false;
    }

    private boolean saveVideoResponse(String jsonInString) {
        Gson gson = new Gson();
        VideoModelObject videoModelObject = gson.fromJson(jsonInString, VideoModelObject.class);
        if (null != videoModelObject && videoModelObject.getHits().size() > 0) {
            DataStore.getInstance().setInfo("VIDEO_LIST_FROM_SERVICE", videoModelObject);
            return true;
        }
        return false;
    }


    private StringBuilder prepareURLToFetchInfo(String queryString, String category) throws IOException {
        StringBuilder builder;
        switch (category) {
            case "IMAGE":
                builder = getImageURLInfo(queryString);
                break;
            case "VIDEO":
                builder = getVideoURLInfo(queryString);
                break;
            default:
                throw new IOException("Invalid Selection");
        }
        return builder;
    }

    private StringBuilder getImageURLInfo(String queryString) {
        StringBuilder builder = new StringBuilder();
        builder.append("https://pixabay.com/api/")
                .append("?key=").append(API_KEY)
                .append("&q=").append(queryString)
                .append("&orientation=").append("vertical")
                .append("&per_page=").append("50")
                .append("&safesearch=").append("true")
                //  .append("&response_group=").append("high_resolution")
                .append("&image_type=").append("photo");
        return builder;
    }

    private StringBuilder getVideoURLInfo(String queryString) {
        StringBuilder builder = new StringBuilder();
        builder.append("https://pixabay.com/api/videos")
                .append("?key=").append(API_KEY)
                .append("&q=").append(queryString)
                .append("&per_page=").append("50")
                .append("&safesearch=").append("true")
                //  .append("&response_group=").append("high_resolution")
                .append("&video_type=").append("all");
        return builder;
    }

    public interface ServiceManagerCallBack {
        void showLoading(boolean flag);

        void onSuccess();

        void showErrorMessage(String errorMessage);
    }

}
