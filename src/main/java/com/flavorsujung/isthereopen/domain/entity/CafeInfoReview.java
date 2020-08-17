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
public class CafeInfoReview {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long seq;
    private Long userSeq;
    private Long cafeSeq;
    @Convert(converter = RateConverter.class)
    private Rate rate;
    @Convert(converter = WaitingTimeConverter.class)
    private WaitingTime waitingTime; // 0 짧은 편, 1 보통, 2 긴편
    @Convert(converter = PriceConverter.class)
    private Price price; //0 쌈, 1 보통, 2 비쌈
    @Convert(converter = CustomerNumConverter.class)
    private CustomerNum customerNum; // 0 적음, 1 보통, 2 많음
    @Convert(converter = PlugNumConverter.class)
    private PlugNum plugNum; // 0 적음, 1 보통, 2 많음
    @Convert(converter = TableHeightConverter.class)
    private TableHeight tableHeight; //0 낮음, 1 보통, 2 높음
    @Convert(converter = LightnessConverter.class)
    private Lightness lightness; // 0 어두움, 1 중간, 2 밝음
    @Convert(converter = LongStayConverter.class)
    private LongStay longStay; // 0 가능, 1 보통, 2 눈치보임
    @Convert(converter = OpenStyleConverter.class)
    private OpenStyle openStyle; //0 잘 지키는 편, 1 보통, 2 들쭉날쭉 지맘대로
}
