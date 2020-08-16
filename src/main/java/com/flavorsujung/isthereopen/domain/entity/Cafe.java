package com.flavorsujung.isthereopen.domain.entity;

import com.flavorsujung.isthereopen.domain.mappedenum.OpenState;
import com.flavorsujung.isthereopen.domain.mappedenum.OpenStateConverter;
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
public class Cafe {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long seq;
    private String name;
    private String address;
    private String runningTime;
    private Double rate;
    @Convert(converter = OpenStateConverter.class)
    private OpenState currentState;
    private String photoURL;
    private Date lastUpdate;
//    private List<CafeInfoReview> cafeInfoReviewList;
//    private List<CafeOpenReview> cafeOpenReviewList;

    public Cafe(Long seq, String name, String address, String runningTime) {
        this.seq = seq;
        this.name = name;
        this.address = address;
        this.runningTime = runningTime;
        rate = -1.0;
        currentState = OpenState.UNKNOWN;
//        cafeInfoReviewList = new ArrayList<>();
//        cafeOpenReviewList = new ArrayList<>();
    }

    public Cafe(Long seq, String name, String address, String runningTime, String photoURL) {
        this.seq = seq;
        this.name = name;
        this.address = address;
        this.runningTime = runningTime;
        rate = -1.0;
        this.currentState = OpenState.UNKNOWN;
        this.photoURL = photoURL;
//        cafeInfoReviewList = new ArrayList<>();
//        cafeOpenReviewList = new ArrayList<>();
    }

    /*public List<CafeInfoReview> getCafeInfoReviewList() {
        return cafeInfoReviewList;
    }

    public void setCafeInfoReviewList(List<CafeInfoReview> cafeInfoReviewList) {
        this.cafeInfoReviewList = cafeInfoReviewList;
    }

    public String getPhotoURL() {
        return photoURL;
    }

    public void setPhotoURL(String photoURL) {
        this.photoURL = photoURL;
    }

    public Date getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(Date lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

    public List<CafeOpenReview> getCafeOpenReviewList() {
        return cafeOpenReviewList;
    }

    public void setCafeOpenReviewList(List<CafeOpenReview> cafeOpenReviewList) {
        this.cafeOpenReviewList = cafeOpenReviewList;
    }*/
}
