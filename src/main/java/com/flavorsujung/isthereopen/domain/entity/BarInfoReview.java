package com.flavorsujung.isthereopen.domain.entity;

import com.flavorsujung.isthereopen.domain.mappedenum.Mood;
import com.flavorsujung.isthereopen.domain.mappedenum.MoodConverter;
import com.flavorsujung.isthereopen.domain.mappedenum.OpenStateConverter;
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
public class BarInfoReview {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    Integer seq;
    Integer userSeq;
    Integer barSeq;
    Integer openStyle; //0 잘 지키는 편, 1 보통, 2 들쭉날쭉 지맘대로
    Integer cleanness;
    @Convert(converter = MoodConverter.class)
    Mood mood; //0 조용, 1 보통, 2 시끄러움
    Integer mainAlcohol; // 0 소주, 1 맥주, 2 막걸리, 3 와인, 4 보드카
    Integer price; //0 쌈, 1 보통, 2 비쌈
}
