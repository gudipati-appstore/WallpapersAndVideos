
package com.gcoders.wallpaper.hqwallpapersdaily.model.wallpaper.video;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Videos {

    @SerializedName("large")
    @Expose
    private Large large;
    @SerializedName("small")
    @Expose
    private Small small;
    @SerializedName("medium")
    @Expose
    private Medium medium;
    @SerializedName("tiny")
    @Expose
    private Tiny tiny;

    public Large getLarge() {
        return large;
    }

    public void setLarge(Large large) {
        this.large = large;
    }

    public Videos withLarge(Large large) {
        this.large = large;
        return this;
    }

    public Small getSmall() {
        return small;
    }

    public void setSmall(Small small) {
        this.small = small;
    }

    public Videos withSmall(Small small) {
        this.small = small;
        return this;
    }

    public Medium getMedium() {
        return medium;
    }

    public void setMedium(Medium medium) {
        this.medium = medium;
    }

    public Videos withMedium(Medium medium) {
        this.medium = medium;
        return this;
    }

    public Tiny getTiny() {
        return tiny;
    }

    public void setTiny(Tiny tiny) {
        this.tiny = tiny;
    }

    public Videos withTiny(Tiny tiny) {
        this.tiny = tiny;
        return this;
    }

}
