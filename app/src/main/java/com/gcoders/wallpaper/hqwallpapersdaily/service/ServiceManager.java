package com.gcoders.wallpaper.hqwallpapersdaily.service;

import okhttp3.OkHttpClient;

/**
 * Created by kondareddygudipati on 2/13/18.
 */

interface ServiceManager {
    void callService(String queryString, String category, OkHttpClient okHttpClient, final MyServiceManager.ServiceManagerCallBack callBack);
    boolean isServiceCallInProgress();
    void cancelAllServiceCalls();
}
