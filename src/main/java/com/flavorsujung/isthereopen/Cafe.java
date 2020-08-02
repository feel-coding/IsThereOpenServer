package com.flavorsujung.isthereopen;

import java.util.ArrayList;
import java.util.List;

public class Cafe {
    private Integer seq;
    private String name;
    private String address;
    private String runtime;
    private Double rate;
    private Integer currentState;
    List<CafeInfoReview> cafeInfoReviewList;
    List<CafeOpenReview> cafeOpenReviewList;

    public Cafe(Integer seq, String name, String address, String runtime, Double rate, Integer currentState) {
        this.seq = seq;
        this.name = name;
        this.address = address;
        this.runtime = runtime;
        this.rate = rate;
        this.currentState = currentState;
        cafeInfoReviewList = new ArrayList<>();
    }

    public Integer getSeq() {
        return seq;
    }

    public void setSeq(Integer seq) {
        this.seq = seq;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setRuntime(String runtime) {
        this.runtime = runtime;
    }

    public void setRate(Double rate) {
        this.rate = rate;
    }

    public void setCurrentState(Integer currentState) {
        this.currentState = currentState;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public String getRuntime() {
        return runtime;
    }

    public Double getRate() {
        return rate;
    }

    public Integer getCurrentState() {
        return currentState;
    }

    public List<CafeInfoReview> getCafeInfoReviewList() {
        return cafeInfoReviewList;
    }

    public void setCafeInfoReviewList(List<CafeInfoReview> cafeInfoReviewList) {
        this.cafeInfoReviewList = cafeInfoReviewList;
    }

    public List<CafeOpenReview> getCafeOpenReviewList() {
        return cafeOpenReviewList;
    }

    public void setCafeOpenReviewList(List<CafeOpenReview> cafeOpenReviewList) {
        this.cafeOpenReviewList = cafeOpenReviewList;
    }
}
