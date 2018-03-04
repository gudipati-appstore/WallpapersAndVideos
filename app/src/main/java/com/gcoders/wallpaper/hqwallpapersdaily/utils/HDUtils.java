package com.gcoders.wallpaper.hqwallpapersdaily.utils;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Point;
import android.view.Display;
import android.view.View;
import android.view.ViewGroup;

import com.gcoders.wallpaper.hqwallpapersdaily.model.wallpaper.ImageHit;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by kondareddygudipati on 2/14/18.
 */

public class HDUtils {

    private static int screenWidth = -1;

    public static List<ImageHit> removeDuplicates(List<ImageHit> hits) {
        List<ImageHit> finalList = new ArrayList<>();
        for (int i = 0; i < hits.size(); i++) {
            boolean matchFound = false;
            for (int j = i + 1; j < hits.size(); j++) {
                if (hits.get(i).getWebformatURL().equalsIgnoreCase(hits.get(j).getWebformatURL())) {
                    matchFound = true;
                    break;
                }
            }
            if (!matchFound) {
                finalList.add(hits.get(i));
            }
        }
        return finalList;
    }

    // size to the
    // screen width
    @SuppressLint("NewApi")
    @SuppressWarnings("deprecation")
    public static int getScreenWidth(Activity activity) {

        if (screenWidth != -1)
            return screenWidth;
        Display display = activity.getWindowManager().getDefaultDisplay();
        Point size = new Point();

        int width;
        int currentapiVersion = android.os.Build.VERSION.SDK_INT;
        if (currentapiVersion >= android.os.Build.VERSION_CODES.HONEYCOMB_MR2) {
            display.getSize(size);
            width = size.x;
        } else {
            width = display.getWidth();

        }
        screenWidth = width;

        return width;
    }

    public static boolean isTablet(Context context) {
        boolean xlarge = ((context.getResources().getConfiguration().screenLayout & Configuration.SCREENLAYOUT_SIZE_MASK) == Configuration.SCREENLAYOUT_SIZE_XLARGE);
        boolean large = ((context.getResources().getConfiguration().screenLayout & Configuration.SCREENLAYOUT_SIZE_MASK) == Configuration.SCREENLAYOUT_SIZE_LARGE);
        return (xlarge || large);
    }

    public static void resizeView(View view, int width, int height) {
        ViewGroup.LayoutParams layout = view.getLayoutParams();
        layout.width = width;
        layout.height = height;
        view.setLayoutParams(layout);
    }

    public static void main(String[] args) {
        ImageHit hit1 = new ImageHit();
        ImageHit hit2 = new ImageHit();
        ImageHit hit3 = new ImageHit();
        ImageHit hit4 = new ImageHit();
        ImageHit hit5 = new ImageHit();

        hit1.setWebformatURL("abcd");
        hit2.setWebformatURL("abcdw");
        hit3.setWebformatURL("abcefg");
        hit4.setWebformatURL("abcdq");
        hit5.setWebformatURL("abcd");

        List<ImageHit> hits = new ArrayList<>();
        hits.add(hit1);
        hits.add(hit2);
        hits.add(hit3);
        hits.add(hit4);
        hits.add(hit5);

        List<ImageHit> finalHits = removeDuplicates(hits);
        for (ImageHit hit : finalHits) {
            System.out.println(hit.getWebformatURL());
        }

    }
}
