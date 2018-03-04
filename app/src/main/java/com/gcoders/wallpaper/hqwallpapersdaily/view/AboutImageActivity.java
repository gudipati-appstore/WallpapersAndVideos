package com.gcoders.wallpaper.hqwallpapersdaily.view;

import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.gcoders.wallpaper.hqwallpapersdaily.BaseActivity;
import com.gcoders.wallpaper.hqwallpapersdaily.R;
import com.gcoders.wallpaper.hqwallpapersdaily.model.wallpaper.ImageHit;
import com.squareup.picasso.Picasso;

public class AboutImageActivity extends BaseActivity {

    private ImageHit imageObject;
    private Picasso picasso;
    private Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.credits);

        Bundle bundle = getIntent().getExtras();
        if (bundle != null && null != bundle.getSerializable("imageObject")) {
            imageObject = (ImageHit) bundle.getSerializable("imageObject");
        }

        initViews();
        bindEvents();

    }

    private void initViews() {
        ImageView imageView = findViewById(R.id.user_image);
        TextView page_url = findViewById(R.id.page_url);
        btn = findViewById(R.id.go_back_to_app1);
        TextView user_name = findViewById(R.id.user_name);

        picasso = getPicassoObject();
        picasso.with(this)
                .load(Uri.parse(imageObject.getUserImageURL()))
                .into(imageView);
        page_url.setText(imageObject.getImageURL());
        user_name.setText(imageObject.getUser());
    }

    private void bindEvents() {
        btn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
