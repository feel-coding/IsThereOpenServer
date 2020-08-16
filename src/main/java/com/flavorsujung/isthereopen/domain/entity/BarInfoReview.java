package com.flavorsujung.isthereopen.domain.entity;

import com.flavorsujung.isthereopen.domain.mappedenum.*;
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
    Long seq;
    Long userSeq;
    Long barSeq;
    @Convert(converter = OpenStyleConverter.class)
    Integer openStyle; //0 잘 지키는 편, 1 보통, 2 들쭉날쭉 지맘대로
    @Convert(converter = CleannessConverter.class)
    Integer cleanness;
    @Convert(converter = MoodConverter.class)
    Mood mood; //0 조용, 1 보통, 2 시끄러움
    Integer mainAlcohol; // 0 소주, 1 맥주, 2 막걸리, 3 와인, 4 보드카
    @Convert(converter = PriceConverter.class)
    Integer price; //0 쌈, 1 보통, 2 비쌈
}
