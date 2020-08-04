package com.flavorsujung.isthereopen;

import java.util.ArrayList;
import java.util.List;

public class Restaurant {
    Integer seq;
    String name;
    String address;
    String runningTime;
    Double rate;
    Integer currentState;
    String photoURL;
    List<RestaurantInfoReview> restaurantInfoReviewList;
    List<RestaurantOpenReview> restaurantOpenReviewList;

    public Restaurant(Integer seq, String name, String address, String runningTime, Double rate) {
        this.seq = seq;
        this.name = name;
        this.address = address;
        this.runningTime = runningTime;
        this.rate = rate;
        this.currentState = 3;
        restaurantInfoReviewList = new ArrayList<>();
        restaurantOpenReviewList = new ArrayList<>();
    }

    public Restaurant(Integer seq, String name, String address, String runningTime, Double rate, String photoURL) {
        this.seq = seq;
        this.name = name;
        this.address = address;
        this.runningTime = runningTime;
        this.rate = rate;
        this.currentState = 3;
        this.photoURL = photoURL;
        restaurantInfoReviewList = new ArrayList<>();
        restaurantOpenReviewList = new ArrayList<>();
    }

    public Integer getSeq() {
        return seq;
    }

    public void setSeq(Integer seq) {
        this.seq = seq;
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

    public String getRunningTime() {
        return runningTime;
    }

    public void setRunningTime(String runningTime) {
        this.runningTime = runningTime;
    }

    public Double getRate() {
        return rate;
    }

    public void setRate(Double rate) {
        this.rate = rate;
    }

    public Integer getCurrentState() {
        return currentState;
    }

    public void setCurrentState(Integer currentState) {
        this.currentState = currentState;
    }

    public List<RestaurantInfoReview> getRestaurantInfoReviewList() {
        return restaurantInfoReviewList;
    }

    public void setRestaurantInfoReviewList(List<RestaurantInfoReview> restaurantInfoReviewList) {
        this.restaurantInfoReviewList = restaurantInfoReviewList;
    }

    public List<RestaurantOpenReview> getRestaurantOpenReviewList() {
        return restaurantOpenReviewList;
    }

    public void setRestaurantOpenReviewList(List<RestaurantOpenReview> restaurantOpenReviewList) {
        this.restaurantOpenReviewList = restaurantOpenReviewList;
    }
}
