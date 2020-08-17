package com.flavorsujung.isthereopen.domain.entity;

import com.flavorsujung.isthereopen.domain.mappedenum.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@ToString(exclude = {})
@Entity
public class RestaurantInfoReview {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long seq;
    private Long restaurantSeq;
    private Long userSeq;
    @Convert(converter = RateConverter.class)
    private Rate rate;
    @Convert(converter = WaitingTimeConverter.class)
    private WaitingTime waitingTime; // 0 짧은 편, 1 보통, 2 긴편
    @Convert(converter = CleannessConverter.class)
    private Cleanness cleanness; //0 깨끗함, 1 보통, 2 더러움
    @Convert(converter = PriceConverter.class)
    private Price price; //0 쌈, 1 보통, 2 비쌈
    @Convert(converter = TakeOutConverter.class)
    private TakeOut takeOut; // 0 불가능, 1 가능
    @Convert(converter = EatAloneConverter.class)
    private EatAlone eatAlone;  // 0 가능, 1 약간 눈치보임, 2 불가능
    @Convert(converter = OpenStyleConverter.class)
    private OpenStyle openStyle; //0 잘 지키는 편, 1 보통, 2 들쭉날쭉 지맘대로

}
