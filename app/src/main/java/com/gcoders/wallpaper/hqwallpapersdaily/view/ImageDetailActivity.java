package com.gcoders.wallpaper.hqwallpapersdaily.view;

import android.app.WallpaperManager;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.gcoders.wallpaper.hqwallpapersdaily.BaseActivity;
import com.gcoders.wallpaper.hqwallpapersdaily.R;
import com.gcoders.wallpaper.hqwallpapersdaily.view.custom.MyDialogFragment;
import com.gcoders.wallpaper.hqwallpapersdaily.view.custom.MyProgressDialog;
import com.gcoders.wallpaper.hqwallpapersdaily.model.wallpaper.ImageHit;
import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;

import java.io.IOException;

public class ImageDetailActivity extends BaseActivity {

    WallpaperManager wallpaperManager;
    Bitmap bitmap1, bitmap2;
    DisplayMetrics displayMetrics;
    int width, height;
    BitmapDrawable bitmapDrawable;
    private ImageHit imageObject;
    private ImageView detail_image;
    private MyProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_detail);

        detail_image = findViewById(R.id.detail_image);
        TextView about_image_text = findViewById(R.id.about_image_text);
        TextView set_wallpaper_text = findViewById(R.id.set_wallpaper_text);
        TextView go_back_text = findViewById(R.id.go_back_text);

        Bundle bundle = getIntent().getExtras();
        if (bundle != null && null != bundle.getSerializable("imageObject")) {
            imageObject = (ImageHit) bundle.getSerializable("imageObject");
        }

        wallpaperManager = WallpaperManager.getInstance(getApplicationContext());

        progressDialog = new MyProgressDialog(this);
        progressDialog.setCancelable(false);

        progressDialog.show();


        Picasso picasso = getPicassoObject();

        picasso.with(this)
                .load(Uri.parse(imageObject.getWebformatURL()))
                .into(detail_image, new Callback() {
                    @Override
                    public void onSuccess() {
                        progressDialog.dismiss();
                    }

                    @Override
                    public void onError() {
                        if (progressDialog.isShowing()) {
                            progressDialog.dismiss();
                        }
                    }
                });

        set_wallpaper_text.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDialogBox();
            }
        });

        about_image_text.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                navigateToAboutImageActivity();
            }
        });

        go_back_text.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }


    private void showDialogBox() {
        Bundle savedInstanceState = new Bundle();
        savedInstanceState.putString("dialog_title", "Set WallPaper");
        savedInstanceState.putString("dialog_body", "Would you like to set this image as your Wallpaper ?");
        savedInstanceState.putString("positive_button_title", "Yes");
        savedInstanceState.putString("negative_button_title", "No");
        showDialogFragment(savedInstanceState, "setwallpaperdialog");
    }

    private void showDialogFragment(Bundle savedInstanceState, String tag) {
        getFragmentManager().beginTransaction().add(MyDialogFragment.newInstance(savedInstanceState, new MyDialogFragment.OnOptionSelectionListner() {
            @Override
            public void onPositiveButtonSelected() {
                setWallPaper();
            }

            @Override
            public void onNeagtiveButtonSelected() {

            }

            @Override
            public void onNeutralButtonSelected() {

            }
        }), tag).commit();
    }

    private void getScreenWidthHeight() {
        displayMetrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        width = displayMetrics.widthPixels;
        height = displayMetrics.heightPixels;
    }

    private void setBitmapDrawable() {
        bitmapDrawable = (BitmapDrawable) detail_image.getDrawable();
        bitmap1 = bitmapDrawable.getBitmap();

    }

    private void setBitmapSize() {
        bitmap2 = Bitmap.createScaledBitmap(bitmap1, width, height, false);
    }

    private void setWallPaper() {
        getScreenWidthHeight();
        setBitmapDrawable();
        setBitmapSize();
        try {
            wallpaperManager.setBitmap(bitmap2);
            wallpaperManager.suggestDesiredDimensions(width, height);
            Toast.makeText(getApplicationContext(), "Wallpaper has been set", Toast.LENGTH_SHORT).show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void navigateToAboutImageActivity() {
        Intent intent = new Intent(this, AboutImageActivity.class);
        Bundle bundle = new Bundle();
        bundle.putSerializable("imageObject", imageObject);
        intent.putExtras(bundle);
        startActivity(intent);
    }

}
