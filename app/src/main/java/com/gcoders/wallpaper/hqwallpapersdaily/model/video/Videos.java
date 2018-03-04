
package com.gcoders.wallpaper.hqwallpapersdaily.model.video;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Videos {

    @SerializedName("large")
    @Expose
    private LargeVideo large;
    @SerializedName("small")
    @Expose
    private SmallVideo small;
    @SerializedName("medium")
    @Expose
    private MediumVideo medium;
    @SerializedName("tiny")
    @Expose
    private TinyVideo tiny;

    public LargeVideo getLarge() {
        return large;
    }

    public void setLarge(LargeVideo large) {
        this.large = large;
    }

    public Videos withLarge(LargeVideo large) {
        this.large = large;
        return this;
    }

    public SmallVideo getSmall() {
        return small;
    }

    public void setSmall(SmallVideo small) {
        this.small = small;
    }

    public Videos withSmall(SmallVideo small) {
        this.small = small;
        return this;
    }

    public MediumVideo getMedium() {
        return medium;
    }

    public void setMedium(MediumVideo medium) {
        this.medium = medium;
    }

    public Videos withMedium(MediumVideo medium) {
        this.medium = medium;
        return this;
    }

    public TinyVideo getTiny() {
        return tiny;
    }

    public void setTiny(TinyVideo tiny) {
        this.tiny = tiny;
    }

    public Videos withTiny(TinyVideo tiny) {
        this.tiny = tiny;
        return this;
    }

}
