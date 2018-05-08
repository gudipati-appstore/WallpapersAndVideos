package com.gcoders.wallpaper.hqwallpapersdaily.service;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


/**

 */
public class HQResourceSystemImpl {
    private Retrofit retrofit = null;
    private static String BASE_URL = "https://pixabay.com";


    /**
     * This method creates a new instance of the API interface.
     *
     * @return The API interface
     */
    public HQResourceSystemAPI getAPI() {

        if (retrofit == null) {
            retrofit = new Retrofit
                    .Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }

        return retrofit.create(HQResourceSystemAPI.class);
    }
}
