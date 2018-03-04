
package com.gcoders.wallpaper.hqwallpapersdaily.model.video;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class VideoHit {

    @SerializedName("picture_id")
    @Expose
    private String pictureId;
    @SerializedName("videos")
    @Expose
    private Videos videos;
    @SerializedName("tags")
    @Expose
    private String tags;
    @SerializedName("downloads")
    @Expose
    private Integer downloads;
    @SerializedName("likes")
    @Expose
    private Integer likes;
    @SerializedName("favorites")
    @Expose
    private Integer favorites;
    @SerializedName("duration")
    @Expose
    private Integer duration;
    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("user_id")
    @Expose
    private Integer userId;
    @SerializedName("views")
    @Expose
    private Integer views;
    @SerializedName("comments")
    @Expose
    private Integer comments;
    @SerializedName("userImageURL")
    @Expose
    private String userImageURL;
    @SerializedName("pageURL")
    @Expose
    private String pageURL;
    @SerializedName("type")
    @Expose
    private String type;
    @SerializedName("user")
    @Expose
    private String user;

    public String getPictureId() {
        return pictureId;
    }

    public void setPictureId(String pictureId) {
        this.pictureId = pictureId;
    }

    public VideoHit withPictureId(String pictureId) {
        this.pictureId = pictureId;
        return this;
    }

    public Videos getVideos() {
        return videos;
    }

    public void setVideos(Videos videos) {
        this.videos = videos;
    }

    public VideoHit withVideos(Videos videos) {
        this.videos = videos;
        return this;
    }

    public String getTags() {
        return tags;
    }

    public void setTags(String tags) {
        this.tags = tags;
    }

    public VideoHit withTags(String tags) {
        this.tags = tags;
        return this;
    }

    public Integer getDownloads() {
        return downloads;
    }

    public void setDownloads(Integer downloads) {
        this.downloads = downloads;
    }

    public VideoHit withDownloads(Integer downloads) {
        this.downloads = downloads;
        return this;
    }

    public Integer getLikes() {
        return likes;
    }

    public void setLikes(Integer likes) {
        this.likes = likes;
    }

    public VideoHit withLikes(Integer likes) {
        this.likes = likes;
        return this;
    }

    public Integer getFavorites() {
        return favorites;
    }

    public void setFavorites(Integer favorites) {
        this.favorites = favorites;
    }

    public VideoHit withFavorites(Integer favorites) {
        this.favorites = favorites;
        return this;
    }

    public Integer getDuration() {
        return duration;
    }

    public void setDuration(Integer duration) {
        this.duration = duration;
    }

    public VideoHit withDuration(Integer duration) {
        this.duration = duration;
        return this;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public VideoHit withId(String id) {
        this.id = id;
        return this;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public VideoHit withUserId(Integer userId) {
        this.userId = userId;
        return this;
    }

    public Integer getViews() {
        return views;
    }

    public void setViews(Integer views) {
        this.views = views;
    }

    public VideoHit withViews(Integer views) {
        this.views = views;
        return this;
    }

    public Integer getComments() {
        return comments;
    }

    public void setComments(Integer comments) {
        this.comments = comments;
    }

    public VideoHit withComments(Integer comments) {
        this.comments = comments;
        return this;
    }

    public String getUserImageURL() {
        return userImageURL;
    }

    public void setUserImageURL(String userImageURL) {
        this.userImageURL = userImageURL;
    }

    public VideoHit withUserImageURL(String userImageURL) {
        this.userImageURL = userImageURL;
        return this;
    }

    public String getPageURL() {
        return pageURL;
    }

    public void setPageURL(String pageURL) {
        this.pageURL = pageURL;
    }

    public VideoHit withPageURL(String pageURL) {
        this.pageURL = pageURL;
        return this;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public VideoHit withType(String type) {
        this.type = type;
        return this;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public VideoHit withUser(String user) {
        this.user = user;
        return this;
    }

}
