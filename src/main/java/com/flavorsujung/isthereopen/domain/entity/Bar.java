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
public class Bar {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer seq;
    private String name;
    private String address;
    private String runningTime;
    private Double avgRate;
    private Integer currentState;
    private String photoUrl;
    private Date lastUpdate;
//    private List<BarOpenReview> barOpenReviewList;
//    private List<BarInfoReview> barInfoReviewList;

    public Bar(Integer seq, String name, String address,String runningTime) {

        this.seq = seq;
        this.name = name;
        this.address = address;
        this.runningTime = runningTime;
        avgRate = Double.longBitsToDouble(-1);
        currentState = 3;
//        barInfoReviewList = new ArrayList<>();
//        barOpenReviewList = new ArrayList<>();
    }

}
