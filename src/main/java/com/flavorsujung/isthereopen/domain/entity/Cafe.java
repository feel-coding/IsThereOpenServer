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
    private String phoneNum;
    private String runningTime;
    private Double avgRate;
    @Convert(converter = OpenStateConverter.class)
    private OpenState currentState;
    private String photoUrl;
    private Date lastUpdate;
//    private List<CafeInfoReview> cafeInfoReviewList;
//    private List<CafeOpenReview> cafeOpenReviewList;

    public Cafe(Long seq, String name, String address,String runningTime) {
        this.seq = seq;
        this.name = name;
        this.address = address;
        this.runningTime = runningTime;
        avgRate = Double.longBitsToDouble(-1);
        currentState = OpenState.UNKNOWN;
//        cafeInfoReviewList = new ArrayList<>();
//        cafeOpenReviewList = new ArrayList<>();
    }

    public Cafe(Long seq, String name, String address, String runningTime, String photoUrl) {
        this.seq = seq;
        this.name = name;
        this.address = address;
        this.phoneNum = phoneNum;
        this.runningTime = runningTime;
        avgRate = Double.longBitsToDouble(-1);
        this.currentState = OpenState.UNKNOWN;
        this.photoUrl = photoUrl;
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
