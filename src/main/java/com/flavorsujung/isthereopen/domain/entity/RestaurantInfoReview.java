package com.flavorsujung.isthereopen.domain.entity;

import com.flavorsujung.isthereopen.domain.mappedenum.OpenStyleConverter;
import com.flavorsujung.isthereopen.domain.mappedenum.PriceConverter;
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
@Table(name = "restaurant_info_review")
public class RestaurantInfoReview {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    Long seq;
    Long restaurantSeq;
    @Convert(converter = OpenStyleConverter.class)
    Integer openStyle; //0 잘 지키는 편, 1 보통, 2 들쭉날쭉 지맘대로
    Integer waitingTime; // 0 짧은 편, 1 보통, 2 긴편
    Integer cleanness; //0 깨끗함, 1 보통, 2 더러움
    @Convert(converter = PriceConverter.class)
    Integer price; //0 쌈, 1 보통, 2 비쌈
    Integer takeOut; // 0 불가능, 1 가능
    Integer eatAlone; // 0 가능, 1 보통, 2 눈치보임
    Integer openStyle; //0 잘 지키는 편, 1 보통, 2 들쭉날쭉 지맘대로

}
