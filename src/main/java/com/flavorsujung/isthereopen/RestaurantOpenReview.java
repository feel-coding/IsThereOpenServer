package com.flavorsujung.isthereopen;

public class RestaurantOpenReview {
    Integer seq;
    Integer cafeSeq;
    Integer userSeq;
    Integer openState; //0 close, 1 break time, 2 open, 3 미확인

    public RestaurantOpenReview(Integer seq, Integer cafeSeq, Integer userSeq, Integer openState) {
        this.seq = seq;
        this.cafeSeq = cafeSeq;
        this.userSeq = userSeq;
        this.openState = openState;
    }

    public Integer getSeq() {
        return seq;
    }

    public void setSeq(Integer seq) {
        this.seq = seq;
    }

    public Integer getCafeSeq() {
        return cafeSeq;
    }

    public void setCafeSeq(Integer cafeSeq) {
        this.cafeSeq = cafeSeq;
    }

    public Integer getUserSeq() {
        return userSeq;
    }

    public void setUserSeq(Integer userSeq) {
        this.userSeq = userSeq;
    }

    public Integer getOpenState() {
        return openState;
    }

    public void setOpenState(Integer openState) {
        this.openState = openState;
    }
}
