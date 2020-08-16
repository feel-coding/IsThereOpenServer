package com.flavorsujung.isthereopen.domain.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@ToString(exclude = {})
@Entity
public class CafeOpenReview {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    Integer seq;
    Integer cafeSeq;
    Integer userSeq;
    Integer openState; //0 close, 1 break time, 2 open, 3 미확인
    Date lastUpdate;

    public CafeOpenReview(Integer seq, Integer cafeSeq, Integer userSeq, Integer openState) {
        this.seq = seq;
        this.cafeSeq = cafeSeq;
        this.userSeq = userSeq;
        this.openState = openState;
        lastUpdate = new Date();
    }

}
