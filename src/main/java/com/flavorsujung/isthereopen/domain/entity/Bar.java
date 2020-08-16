package com.flavorsujung.isthereopen.domain.entity;

import com.flavorsujung.isthereopen.domain.mappedenum.OpenState;
import com.flavorsujung.isthereopen.domain.mappedenum.OpenStateConverter;
import com.flavorsujung.isthereopen.domain.mappedenum.OpenStyleConverter;
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
    private Long seq;
    private String name;
    private String address;
    private String runningTime;
    private Double avgRate;
    @Convert(converter = OpenStateConverter.class)
    private OpenState currentState;
    private String photoUrl;
    private Date lastUpdate;
//    private List<BarOpenReview> barOpenReviewList;
//    private List<BarInfoReview> barInfoReviewList;

    public Bar(Long seq, String name, String address,String runningTime) {

        this.seq = seq;
        this.name = name;
        this.address = address;
        this.runningTime = runningTime;
        avgRate = Double.longBitsToDouble(-1);
        currentState = OpenState.UNKNOWN;
//        barInfoReviewList = new ArrayList<>();
//        barOpenReviewList = new ArrayList<>();
    }

}
