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
    Long seq;
    Long userSeq;
    Long cafeSeq;
    WaitingTime waitingTime; // 0 짧은 편, 1 보통, 2 긴편
    @Convert(converter = PriceConverter.class)
    Price price; //0 쌈, 1 보통, 2 비쌈
    @Convert(converter = CustomerNumConverter.class)
    CustomerNum customerNum; // 0 적음, 1 보통, 2 많음
    @Convert(converter = PlugNumConverter.class)
    PlugNum plugNum; // 0 적음, 1 보통, 2 많음
    @Convert(converter = TableHeightConverter.class)
    TableHeight tableHeight; //0 낮음, 1 보통, 2 높음
    @Convert(converter = LightnessConverter.class)
    Lightness lightness; // 0 어두움, 1 중간, 2 밝음
    @Convert(converter = LongStayConverter.class)
    LongStay longStay; // 0 가능, 1 보통, 2 눈치보임
    @Convert(converter = OpenStyleConverter.class)
    OpenStyle openStyle; //0 잘 지키는 편, 1 보통, 2 들쭉날쭉 지맘대로


}
