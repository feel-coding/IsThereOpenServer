package com.flavorsujung.isthereopen.domain.entity;

import com.flavorsujung.isthereopen.domain.mappedenum.*;
import com.mysql.cj.x.protobuf.MysqlxCursor;
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
    private Long seq;
    private Long userSeq;
    private Long barSeq;
    @Convert(converter = RateConverter.class)
    private Rate rate;
    @Convert(converter = ToiletConverter.class)
    private Toilet toilet; // 0 남여분리, 1 남여공용
    @Convert(converter = MoodConverter.class)
    private Mood mood; //0 조용, 1 보통, 2 시끄러움
    @Convert(converter = AlcoholConverter.class)
    private Alcohol mainAlcohol; // 0 소주, 1 맥주, 2 막걸리, 3 와인, 4 보드카
    @Convert(converter = PriceConverter.class)
    private Price price; //0 쌈, 1 보통, 2 비쌈
    @Convert(converter = CleannessConverter.class)
    private Cleanness cleanness;
    @Convert(converter = OpenStyleConverter.class)
    private OpenStyle openStyle; //0 잘 지키는 편, 1 보통, 2 들쭉날쭉 지맘대로
}
