package com.flavorsujung.isthereopen.domain.entity;

import com.flavorsujung.isthereopen.domain.mappedenum.OpenStateConverter;
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
    Long seq;
    Long userSeq;
    @Convert(converter = OpenStateConverter.class)
    Long cafeSeq;
    @Convert(converter = OpenStateConverter.class)
    Integer openState; //0 close, 1 break time, 2 open, 3 미확인
    Date createdAt;
    Integer lightness; // 0 어두움, 1 중간, 2 밝음

    public CafeOpenReview(Long seq, Long cafeSeq, Long userSeq, Integer openState) {
        this.seq = seq;
        this.cafeSeq = cafeSeq;
        this.userSeq = userSeq;
        this.openState = openState;
    }

}
