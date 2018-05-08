package com.gcoders.wallpaper.hqwallpapersdaily;

import android.app.Application;

import com.squareup.picasso.Picasso;

import java.io.File;
import java.util.Collections;
import java.util.concurrent.TimeUnit;

import okhttp3.Cache;
import okhttp3.CipherSuite;
import okhttp3.ConnectionSpec;
import okhttp3.OkHttpClient;
import okhttp3.TlsVersion;

/**
 * Created by kondareddygudipati on 2/12/18.
 */

public class WallpaperApplication extends Application {

    private static OkHttpClient okHttpClient;
    private Picasso picassoInstance;


    @Override
    public void onCreate() {
        super.onCreate();
        init();
    }

    private void init() {
        getOkhttpInstance();
        getPicassoInstance();
    }

    public OkHttpClient getOkhttpInstance() {

        if (okHttpClient == null) {
            okHttpClient = initOkHttpClient();
        }
        return okHttpClient;

    }

    public Picasso getPicassoInstance() {
        if (picassoInstance == null) {
            picassoInstance = initPicassoInstance();
            Picasso.setSingletonInstance(picassoInstance);
        }
        return picassoInstance;
    }

    private OkHttpClient initOkHttpClient() {
        return new OkHttpClient.Builder()
                .connectionSpecs(Collections.singletonList(getHttpsConnectionSpecInstance()))
                .readTimeout(30, TimeUnit.SECONDS)
                .connectTimeout(30, TimeUnit.SECONDS)
                .cache(createHttpClientCache())
                .build();
    }

    private Cache createHttpClientCache() {
        int cacheSize = 10 * 1024 * 1024;
        File cacheDir = new File("CacheResponse.tmp");
        return new Cache(cacheDir, cacheSize);
    }

    private ConnectionSpec getHttpsConnectionSpecInstance() {
        return new ConnectionSpec.Builder(ConnectionSpec.MODERN_TLS)
                .tlsVersions(TlsVersion.TLS_1_2)
                .cipherSuites(
                        CipherSuite.TLS_ECDHE_ECDSA_WITH_AES_128_GCM_SHA256,
                        CipherSuite.TLS_ECDHE_RSA_WITH_AES_128_GCM_SHA256,
                        CipherSuite.TLS_DHE_RSA_WITH_AES_128_GCM_SHA256)
                .build();

    }

    private Picasso initPicassoInstance() {
        return new Picasso.Builder(this)
                .build();
    }

}
