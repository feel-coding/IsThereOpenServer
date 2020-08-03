package com.flavorsujung.isthereopen;

import java.util.ArrayList;
import java.util.List;

public class Bar {
    Integer seq;
    String name;
    String address;
    String runningTime;
    Double rate;
    Integer currentState;
    List<BarOpenReview> barOpenReviewList;
    List<BarInfoReview> barInfoReviewList;

    public Bar(Integer seq, String name, String address, String runningTime, Double rate, Integer currentState) {
        this.seq = seq;
        this.name = name;
        this.address = address;
        this.runningTime = runningTime;
        this.rate = rate;
        this.currentState = currentState;
        barInfoReviewList = new ArrayList<>();
        barOpenReviewList = new ArrayList<>();
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

    public List<BarOpenReview> getBarOpenReviewList() {
        return barOpenReviewList;
    }

    public void setBarOpenReviewList(List<BarOpenReview> barOpenReviewList) {
        this.barOpenReviewList = barOpenReviewList;
    }

    public List<BarInfoReview> getBarInfoReviewList() {
        return barInfoReviewList;
    }

    public void setBarInfoReviewList(List<BarInfoReview> barInfoReviewList) {
        this.barInfoReviewList = barInfoReviewList;
    }
}
