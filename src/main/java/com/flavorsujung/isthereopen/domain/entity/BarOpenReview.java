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
@Table(name = "bar_open_review")
public class BarOpenReview {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    Integer seq;
    Integer barSeq;
    Integer userSeq;
    Integer openState; //0 close, 1 break time, 2 open, 3 미확인
    Date lastUpdate;



}
