package com.gcoders.wallpaper.hqwallpapersdaily;

import android.os.Bundle;
import android.support.annotation.Nullable;

import com.gcoders.wallpaper.hqwallpapersdaily.service.MyServiceManager;
import com.squareup.picasso.Picasso;

import nucleus5.view.NucleusAppCompatActivity;
import okhttp3.OkHttpClient;

/**
 * Created by kondareddygudipati on 2/13/18.
 */

public class BaseActivity extends NucleusAppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    public OkHttpClient getOkHttpClientObject() {
        return ((WallpaperApplication)getApplication()).getOkhttpInstance();
    }

    public MyServiceManager getMyServiceManagerObject() {
        return ((WallpaperApplication)getApplication()).getServiceManageInstance();
    }

    public Picasso getPicassoObject() {
        return ((WallpaperApplication)getApplication()).getPicassoInstance();
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        cancelAllPendingEvents();
    }

    private void cancelAllPendingEvents(){
        if(getMyServiceManagerObject().isServiceCallInProgress()) {
            getMyServiceManagerObject().cancelAllServiceCalls();
        }
    }
}
