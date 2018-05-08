package com.gcoders.wallpaper.hqwallpapersdaily;


import android.support.v4.app.Fragment;

import com.gcoders.wallpaper.hqwallpapersdaily.service.HQResourceSystemImpl;

/**
 * A simple {@link Fragment} subclass.
 */
public class BaseFragment extends Fragment {

    private static HQResourceSystemImpl hqResourceSystem;


    public BaseFragment() {
        // Required empty public constructor
    }

    public HQResourceSystemImpl getHqWallPaperService(){
        if(hqResourceSystem == null){
            return new HQResourceSystemImpl();
        }
        return hqResourceSystem;
    }

}
