
package com.gcoders.wallpaper.hqwallpapersdaily.model.wallpaper;

import java.io.Serializable;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ImageHit implements Serializable
{

    @SerializedName("previewHeight")
    @Expose
    private Integer previewHeight;
    @SerializedName("largeImageURL")
    @Expose
    private String largeImageURL;
    @SerializedName("user_id")
    @Expose
    private Integer userId;
    @SerializedName("imageSize")
    @Expose
    private Integer imageSize;
    @SerializedName("fullHDURL")
    @Expose
    private String fullHDURL;
    @SerializedName("webformatHeight")
    @Expose
    private Integer webformatHeight;
    @SerializedName("imageURL")
    @Expose
    private String imageURL;
    @SerializedName("webformatWidth")
    @Expose
    private Integer webformatWidth;
    @SerializedName("previewWidth")
    @Expose
    private Integer previewWidth;
    @SerializedName("userImageURL")
    @Expose
    private String userImageURL;
    @SerializedName("previewURL")
    @Expose
    private String previewURL;
    @SerializedName("webformatURL")
    @Expose
    private String webformatURL;
    @SerializedName("imageWidth")
    @Expose
    private Integer imageWidth;
    @SerializedName("id_hash")
    @Expose
    private String idHash;
    @SerializedName("user")
    @Expose
    private String user;
    @SerializedName("type")
    @Expose
    private String type;
    @SerializedName("imageHeight")
    @Expose
    private Integer imageHeight;
    private final static long serialVersionUID = -4010001049942915091L;

    public Integer getPreviewHeight() {
        return previewHeight;
    }

    public void setPreviewHeight(Integer previewHeight) {
        this.previewHeight = previewHeight;
    }

    public ImageHit withPreviewHeight(Integer previewHeight) {
        this.previewHeight = previewHeight;
        return this;
    }

    public String getLargeImageURL() {
        return largeImageURL;
    }

    public void setLargeImageURL(String largeImageURL) {
        this.largeImageURL = largeImageURL;
    }

    public ImageHit withLargeImageURL(String largeImageURL) {
        this.largeImageURL = largeImageURL;
        return this;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public ImageHit withUserId(Integer userId) {
        this.userId = userId;
        return this;
    }

    public Integer getImageSize() {
        return imageSize;
    }

    public void setImageSize(Integer imageSize) {
        this.imageSize = imageSize;
    }

    public ImageHit withImageSize(Integer imageSize) {
        this.imageSize = imageSize;
        return this;
    }

    public String getFullHDURL() {
        return fullHDURL;
    }

    public void setFullHDURL(String fullHDURL) {
        this.fullHDURL = fullHDURL;
    }

    public ImageHit withFullHDURL(String fullHDURL) {
        this.fullHDURL = fullHDURL;
        return this;
    }

    public Integer getWebformatHeight() {
        return webformatHeight;
    }

    public void setWebformatHeight(Integer webformatHeight) {
        this.webformatHeight = webformatHeight;
    }

    public ImageHit withWebformatHeight(Integer webformatHeight) {
        this.webformatHeight = webformatHeight;
        return this;
    }

    public String getImageURL() {
        return imageURL;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }

    public ImageHit withImageURL(String imageURL) {
        this.imageURL = imageURL;
        return this;
    }

    public Integer getWebformatWidth() {
        return webformatWidth;
    }

    public void setWebformatWidth(Integer webformatWidth) {
        this.webformatWidth = webformatWidth;
    }

    public ImageHit withWebformatWidth(Integer webformatWidth) {
        this.webformatWidth = webformatWidth;
        return this;
    }

    public Integer getPreviewWidth() {
        return previewWidth;
    }

    public void setPreviewWidth(Integer previewWidth) {
        this.previewWidth = previewWidth;
    }

    public ImageHit withPreviewWidth(Integer previewWidth) {
        this.previewWidth = previewWidth;
        return this;
    }

    public String getUserImageURL() {
        return userImageURL;
    }

    public void setUserImageURL(String userImageURL) {
        this.userImageURL = userImageURL;
    }

    public ImageHit withUserImageURL(String userImageURL) {
        this.userImageURL = userImageURL;
        return this;
    }

    public String getPreviewURL() {
        return previewURL;
    }

    public void setPreviewURL(String previewURL) {
        this.previewURL = previewURL;
    }

    public ImageHit withPreviewURL(String previewURL) {
        this.previewURL = previewURL;
        return this;
    }

    public String getWebformatURL() {
        return webformatURL;
    }

    public void setWebformatURL(String webformatURL) {
        this.webformatURL = webformatURL;
    }

    public ImageHit withWebformatURL(String webformatURL) {
        this.webformatURL = webformatURL;
        return this;
    }

    public Integer getImageWidth() {
        return imageWidth;
    }

    public void setImageWidth(Integer imageWidth) {
        this.imageWidth = imageWidth;
    }

    public ImageHit withImageWidth(Integer imageWidth) {
        this.imageWidth = imageWidth;
        return this;
    }

    public String getIdHash() {
        return idHash;
    }

    public void setIdHash(String idHash) {
        this.idHash = idHash;
    }

    public ImageHit withIdHash(String idHash) {
        this.idHash = idHash;
        return this;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public ImageHit withUser(String user) {
        this.user = user;
        return this;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public ImageHit withType(String type) {
        this.type = type;
        return this;
    }

    public Integer getImageHeight() {
        return imageHeight;
    }

    public void setImageHeight(Integer imageHeight) {
        this.imageHeight = imageHeight;
    }

    public ImageHit withImageHeight(Integer imageHeight) {
        this.imageHeight = imageHeight;
        return this;
    }

}
