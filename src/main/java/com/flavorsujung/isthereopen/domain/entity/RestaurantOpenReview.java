package com.flavorsujung.isthereopen.domain.entity;

import com.flavorsujung.isthereopen.domain.mappedenum.OpenState;
import com.flavorsujung.isthereopen.domain.mappedenum.OpenStateConverter;
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
public class RestaurantOpenReview {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    Long seq;
    Long userSeq;
    Long restaurantSeq;
    @Convert(converter = OpenStateConverter.class)
    OpenState openState; //0 close, 1 break time, 2 open, 3 미확인
    Date lastUpdate;

    public RestaurantOpenReview(Long seq, Long restaurantSeq, Long userSeq, OpenState openState) {
        this.seq = seq;
        this.restaurantSeq = restaurantSeq;
        this.userSeq = userSeq;
        this.openState = openState;
    }

}
