package com.gcoders.wallpaper.hqwallpapersdaily;


import android.support.v4.app.Fragment;

import com.gcoders.wallpaper.hqwallpapersdaily.WallpaperApplication;
import com.gcoders.wallpaper.hqwallpapersdaily.service.MyServiceManager;
import com.squareup.picasso.Picasso;

import okhttp3.OkHttpClient;

/**
 * A simple {@link Fragment} subclass.
 */
public class BaseFragment extends Fragment {


    public BaseFragment() {
        // Required empty public constructor
    }

    public OkHttpClient getOkHttpClientObject() {
        return ((WallpaperApplication)getContext().getApplicationContext()).getOkhttpInstance();
    }

    public MyServiceManager getMyServiceManagerObject() {
        return ((WallpaperApplication)getContext().getApplicationContext()).getServiceManageInstance();
    }

    public Picasso getPicassoObject() {
        return ((WallpaperApplication)getContext().getApplicationContext()).getPicassoInstance();
    }
}
