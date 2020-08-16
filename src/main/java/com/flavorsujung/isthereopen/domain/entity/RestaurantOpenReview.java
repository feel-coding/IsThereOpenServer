package com.flavorsujung.isthereopen.domain.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@ToString(exclude = {})
@Entity
@Table(name = "restaurant_open_review")
public class RestaurantOpenReview {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    Long seq;
    Long userSeq;
    Long restaurantSeq;
    Integer openState; //0 close, 1 break time, 2 open, 3 미확인
    Date lastUpdate;

    public RestaurantOpenReview(Long seq, Long restaurantSeq, Long userSeq, Integer openState) {
        this.seq = seq;
        this.restaurantSeq = restaurantSeq;
        this.userSeq = userSeq;
        this.openState = openState;
        lastUpdate = new Date();
    }

}
