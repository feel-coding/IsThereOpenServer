package com.flavorsujung.isthereopen.domain.entity;

import com.flavorsujung.isthereopen.domain.entity.RestaurantInfoReview;
import com.flavorsujung.isthereopen.domain.entity.RestaurantOpenReview;
import com.flavorsujung.isthereopen.domain.mappedenum.OpenState;
import com.flavorsujung.isthereopen.domain.mappedenum.OpenStateConverter;
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
    private Long seq;
    private String name;
    private String address;
    private String runningTime;
    private Double avgRate;
    @Convert(converter = OpenStateConverter.class)
    private OpenState currentState;
    private String photoURL;
    private Date lastUpdate;
//    private List<RestaurantInfoReview> restaurantInfoReviewList;
//    private List<RestaurantOpenReview> restaurantOpenReviewList;

    public Restaurant(Long seq, String name, String address, String runningTime) {
        this.seq = seq;
        this.name = name;
        this.address = address;
        this.runningTime = runningTime;
        avgRate = -1.0;
        currentState = OpenState.UNKNOWN;
//        restaurantInfoReviewList = new ArrayList<>();
//        restaurantOpenReviewList = new ArrayList<>();
    }

    public Restaurant(Long seq, String name, String address, String runningTime, String photoURL) {
        this.seq = seq;
        this.name = name;
        this.address = address;
        this.runningTime = runningTime;
        avgRate = -1.0;
        currentState = OpenState.UNKNOWN;
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
