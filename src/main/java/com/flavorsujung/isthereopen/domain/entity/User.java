package com.flavorsujung.isthereopen.domain.entity;

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
public class User {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long seq;
    private String name;

    public User(Long seq, String id, String name) {
        this.seq = seq;
        this.name = name;
    }



   /* public List<Integer> getPatronBarList() {
        return patronBarList;
    }

    public void setPatronBarList(List<Integer> patronBarList) {
        this.patronBarList = patronBarList;
    }

    public List<Integer> getPatronCafeList() {
        return patronCafeList;
    }

    public void setPatronCafeList(List<Integer> patronCafeList) {
        this.patronCafeList = patronCafeList;
    }

    public List<Integer> getPatronRestaurantList() {
        return patronRestaurantList;
    }

    public void setPatronRestaurantList(List<Integer> patronRestaurantList) {
        this.patronRestaurantList = patronRestaurantList;
    }*/
}
