package com.gcoders.wallpaper.hqwallpapersdaily;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.squareup.picasso.Picasso;

import okhttp3.OkHttpClient;

/**
 * Created by kondareddygudipati on 2/13/18.
 */

public class BaseActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    public OkHttpClient getOkHttpClientObject() {
        return ((WallpaperApplication)getApplication()).getOkhttpInstance();
    }

    public Picasso getPicassoObject() {
        return ((WallpaperApplication)getApplication()).getPicassoInstance();
    }


}
