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
@Table(name = "restaurant_patron")
public class RestaurantPatron {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    Long seq;
    Integer restaurantSeq;
    Integer userSeq;
}
