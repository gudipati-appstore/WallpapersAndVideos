package com.gcoders.wallpaper.hqwallpapersdaily.view;

import android.os.Bundle;
import android.view.View;

import com.gcoders.wallpaper.hqwallpapersdaily.BaseActivity;
import com.gcoders.wallpaper.hqwallpapersdaily.R;

public class InfoActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.aboutapp_info);

        findViewById(R.id.go_back_to_app).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

}
