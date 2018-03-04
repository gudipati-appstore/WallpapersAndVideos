
package com.gcoders.wallpaper.hqwallpapersdaily.model.wallpaper;

import java.io.Serializable;
import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ImageModelObject implements Serializable
{

    @SerializedName("totalHits")
    @Expose
    private Integer totalHits;
    @SerializedName("hits")
    @Expose
    private List<ImageHit> hits = null;
    @SerializedName("total")
    @Expose
    private Integer total;
    private final static long serialVersionUID = -7117340724403715127L;

    public Integer getTotalHits() {
        return totalHits;
    }

    public void setTotalHits(Integer totalHits) {
        this.totalHits = totalHits;
    }

    public ImageModelObject withTotalHits(Integer totalHits) {
        this.totalHits = totalHits;
        return this;
    }

    public List<ImageHit> getHits() {
        return hits;
    }

    public void setHits(List<ImageHit> hits) {
        this.hits = hits;
    }

    public ImageModelObject withHits(List<ImageHit> hits) {
        this.hits = hits;
        return this;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public ImageModelObject withTotal(Integer total) {
        this.total = total;
        return this;
    }


}
