package com.example.imanshu.levler;

/**
 * Created by Imanshu on 6/26/2017.
 */

public class Getter_Setter {

    String players;
    int images;
    String phone;
    String reviews;
    String status;
    Float rating;

    public Getter_Setter(String players, int images, String phone, String reviews, String status, Float rating) {
        this.players = players;
        this.images = images;
        this.phone = phone;
        this.reviews = reviews;
        this.status = status;
        this.rating = rating;
    }

    public String getPlayers() {
        return players;
    }

    public void setPlayers(String players) {
        this.players = players;
    }

    public int getImages() {
        return images;
    }

    public void setImages(int images) {
        this.images = images;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getReviews() {
        return reviews;
    }

    public void setReviews(String reviews) {
        this.reviews = reviews;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Float getRating() {
        return rating;
    }

    public void setRating(Float rating) {
        this.rating = rating;
    }
}
