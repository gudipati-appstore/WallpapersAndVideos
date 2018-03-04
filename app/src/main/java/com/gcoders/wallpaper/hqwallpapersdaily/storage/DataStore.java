package com.gcoders.wallpaper.hqwallpapersdaily.storage;

import java.util.HashMap;

/**
 * Created by kondareddygudipati on 1/22/18.
 */

public class DataStore{

    private static DataStore dataStore;
    private static HashMap<String, Object> map = new HashMap<>();

    public static DataStore getInstance(){
        if(null == dataStore){
            return new DataStore();
        }
        return dataStore;
    }

    public void setInfo(String key, Object obj){
        map.put(key,obj);
    }

    public Object getInfo(String key){
        return map.get(key);
    }
}
