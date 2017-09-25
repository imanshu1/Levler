package com.example.imanshu.levler.pojo;

/**
 * Created by Imanshu on 8/28/2017.
 */

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Location {

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("team_id")
    @Expose
    private Integer teamId;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("address")
    @Expose
    private String address;
    @SerializedName("phone")
    @Expose
    private String phone;
    @SerializedName("google_place_id")
    @Expose
    private String googlePlaceId;
    @SerializedName("fb_page_name")
    @Expose
    private Object fbPageName;
    @SerializedName("fb_page_id")
    @Expose
    private Object fbPageId;
    @SerializedName("fb_page_access_token")
    @Expose
    private Object fbPageAccessToken;
    @SerializedName("state")
    @Expose
    private Object state;
    @SerializedName("position")
    @Expose
    private Object position;
    @SerializedName("website")
    @Expose
    private String website;
    @SerializedName("language")
    @Expose
    private Object language;
    @SerializedName("photo")
    @Expose
    private String photo;
    @SerializedName("link_to_map_url")
    @Expose
    private String linkToMapUrl;
    @SerializedName("ratings")
    @Expose
    private Object ratings;
    @SerializedName("shortlink")
    @Expose
    private String shortlink;
    @SerializedName("yelp_bussiness_id")
    @Expose
    private Object yelpBussinessId;
    @SerializedName("created_at")
    @Expose
    private String createdAt;
    @SerializedName("updated_at")
    @Expose
    private String updatedAt;

    public Location(Integer id, Integer teamId, String name, String address, String phone, String googlePlaceId, Object fbPageName, Object fbPageId, Object fbPageAccessToken, Object state, Object position, String website, Object language, String photo, String linkToMapUrl, Object ratings, String shortlink, Object yelpBussinessId, String createdAt, String updatedAt) {
        this.id = id;
        this.teamId = teamId;
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.googlePlaceId = googlePlaceId;
        this.fbPageName = fbPageName;
        this.fbPageId = fbPageId;
        this.fbPageAccessToken = fbPageAccessToken;
        this.state = state;
        this.position = position;
        this.website = website;
        this.language = language;
        this.photo = photo;
        this.linkToMapUrl = linkToMapUrl;
        this.ratings = ratings;
        this.shortlink = shortlink;
        this.yelpBussinessId = yelpBussinessId;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getTeamId() {
        return teamId;
    }

    public void setTeamId(Integer teamId) {
        this.teamId = teamId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getGooglePlaceId() {
        return googlePlaceId;
    }

    public void setGooglePlaceId(String googlePlaceId) {
        this.googlePlaceId = googlePlaceId;
    }

    public Object getFbPageName() {
        return fbPageName;
    }

    public void setFbPageName(Object fbPageName) {
        this.fbPageName = fbPageName;
    }

    public Object getFbPageId() {
        return fbPageId;
    }

    public void setFbPageId(Object fbPageId) {
        this.fbPageId = fbPageId;
    }

    public Object getFbPageAccessToken() {
        return fbPageAccessToken;
    }

    public void setFbPageAccessToken(Object fbPageAccessToken) {
        this.fbPageAccessToken = fbPageAccessToken;
    }

    public Object getState() {
        return state;
    }

    public void setState(Object state) {
        this.state = state;
    }

    public Object getPosition() {
        return position;
    }

    public void setPosition(Object position) {
        this.position = position;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public Object getLanguage() {
        return language;
    }

    public void setLanguage(Object language) {
        this.language = language;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getLinkToMapUrl() {
        return linkToMapUrl;
    }

    public void setLinkToMapUrl(String linkToMapUrl) {
        this.linkToMapUrl = linkToMapUrl;
    }

    public Object getRatings() {
        return ratings;
    }

    public void setRatings(Object ratings) {
        this.ratings = ratings;
    }

    public String getShortlink() {
        return shortlink;
    }

    public void setShortlink(String shortlink) {
        this.shortlink = shortlink;
    }

    public Object getYelpBussinessId() {
        return yelpBussinessId;
    }

    public void setYelpBussinessId(Object yelpBussinessId) {
        this.yelpBussinessId = yelpBussinessId;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }

}