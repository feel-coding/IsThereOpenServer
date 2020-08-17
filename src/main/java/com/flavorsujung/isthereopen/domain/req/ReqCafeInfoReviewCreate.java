package com.flavorsujung.isthereopen.domain.req;

import com.flavorsujung.isthereopen.domain.mappedenum.*;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Convert;

@Getter
@Setter
public class ReqCafeInfoReviewCreate {
    Long userSeq;
    @Convert(converter = OpenStyleConverter.class)
    OpenStyle openStyle; //0 잘 지키는 편, 1 보통, 2 들쭉날쭉 지맘대로
    @Convert(converter = WaitingTimeConverter.class)
    WaitingTime waitingTime; // 0 짧은 편, 1 보통, 2 긴편
    @Convert(converter = PriceConverter.class)
    Price price; //0 쌈, 1 보통, 2 비쌈
    @Convert(converter = CustomerNumConverter.class)
    CustomerNum customerNum; // 0 적음, 1 보통, 2 많음
    @Convert(converter = PlugNumConverter.class)
    PlugNum plugNum; // 0 적음, 1 보통, 2 많음
    @Convert(converter = TableHeightConverter.class)
    TableHeight tableHeight; //0 낮음, 1 보통, 2 높음
    Lightness lightness; // 0 어두움, 1 중간, 2 밝음
    @Convert(converter = StayLongConverter.class)
    @Convert(converter = StayLongConverter.class)
    StayLong stayLong; // 0 가능, 1 보통, 2 눈치보임
}
