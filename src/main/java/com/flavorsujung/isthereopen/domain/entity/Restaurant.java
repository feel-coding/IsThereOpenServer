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
    private String phoneNum;
    private String runningTime;
    private Double avgRate;
    @Convert(converter = OpenStateConverter.class)
    private OpenState currentState;
    private String photoUrl;
    private Date lastUpdate;
    private String avgWaitingTime;
    private String avgCleanness;
    private String avgPrice;
    private String avgTakeOut;
    private String avgEatAlone;
    private String avgOpenStyle;
    private Integer shortWaiting;
    private Integer clean;
    private Integer cheap;
    private Integer takeout;
    private Integer stable;
    private Integer eatAlone;

    public Restaurant(Long seq, String name, String address,String runningTime) {
        this.seq = seq;
        this.name = name;
        this.address = address;
        this.runningTime = runningTime;
        avgRate = -1.0;
        currentState = OpenState.UNKNOWN;
    }

    public Restaurant(Long seq, String name, String address, String runningTime, String photoUrl) {
        this.seq = seq;
        this.name = name;
        this.address = address;
        this.runningTime = runningTime;
        avgRate = -1.0;
        currentState = OpenState.UNKNOWN;
        this.photoUrl = photoUrl;
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
