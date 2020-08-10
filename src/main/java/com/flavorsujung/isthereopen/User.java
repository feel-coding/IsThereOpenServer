package com.flavorsujung.isthereopen;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@ToString(exclude = {})
@Entity
@Table(name = "user")
public class User {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer seq;
   /* private String id;*/
    private String name;
    /*List<Integer> patronBarList; // Bar seq list
    List<Integer> patronCafeList; // Cafe seq list
    List<Integer> patronRestaurantList; // Restaurant seq list*/

    public User(Integer seq, String id, String name) {
        this.seq = seq;
       /* this.id = id;*/
        this.name = name;
        /*patronBarList = new ArrayList<>();
        patronCafeList = new ArrayList<>();
        patronRestaurantList = new ArrayList<>();*/
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
