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
public class RestaurantInfo {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    Long seq;
    Long restaurantSeq;
    @Convert(converter = WaitingTimeConverter.class)
    WaitingTime waitingTime; // 0 짧은 편, 1 보통, 2 긴편
    @Convert(converter = CleannessConverter.class)
    Cleanness cleanness; //0 깨끗함, 1 보통, 2 더러움
    @Convert(converter = PriceConverter.class)
    Price price; //0 쌈, 1 보통, 2 비쌈
    @Convert(converter = TakeOutConverter.class)
    TakeOut takeOut; // 0 불가능, 1 가능
    @Convert(converter = EatAloneConverter.class)
    EatAlone eatAlone; // 0 가능, 1 보통, 2 눈치보임
    @Convert(converter = OpenStyleConverter.class)
    OpenStyle openStyle; //0 잘 지키는 편, 1 보통, 2 들쭉날쭉 지맘대로
}
