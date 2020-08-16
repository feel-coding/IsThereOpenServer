package com.flavorsujung.isthereopen.domain.entity;

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
public class RestaurantPatron {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    Long seq;
    Integer userSeq;
    Integer restaurantSeq;

}
