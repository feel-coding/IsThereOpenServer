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
    Integer customerNum; // 0 적음, 1 보통, 2 많음
    Integer plugNum; // 0 적음, 1 보통, 2 많음
    Integer tableHeight; //0 낮음, 1 보통, 2 높음
    Integer longStay; // 0 가능, 1 보통, 2 눈치보임
}
