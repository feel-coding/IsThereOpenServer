package com.flavorsujung.isthereopen.domain.entity;

import com.flavorsujung.isthereopen.domain.entity.RestaurantInfoReview;
import com.flavorsujung.isthereopen.domain.entity.RestaurantOpenReview;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@ToString(exclude = {})
@Entity
public class Restaurant {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer seq;
    private String name;
    private String address;
    private String runningTime;
    private Double rate;
    private Integer currentState;
    private String photoURL;
    private Date lastUpdate;
//    private List<RestaurantInfoReview> restaurantInfoReviewList;
//    private List<RestaurantOpenReview> restaurantOpenReviewList;

    public Restaurant(Integer seq, String name, String address, String runningTime) {
        this.seq = seq;
        this.name = name;
        this.address = address;
        this.runningTime = runningTime;
        rate = -1.0;
        currentState = 3;
//        restaurantInfoReviewList = new ArrayList<>();
//        restaurantOpenReviewList = new ArrayList<>();
    }

    public Restaurant(Integer seq, String name, String address, String runningTime, String photoURL) {
        this.seq = seq;
        this.name = name;
        this.address = address;
        this.runningTime = runningTime;
        rate = -1.0;
        currentState = 3;
        this.photoURL = photoURL;
//        restaurantInfoReviewList = new ArrayList<>();
//        restaurantOpenReviewList = new ArrayList<>();
    }

    /*public List<RestaurantInfoReview> getRestaurantInfoReviewList() {
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
    }*/

}
