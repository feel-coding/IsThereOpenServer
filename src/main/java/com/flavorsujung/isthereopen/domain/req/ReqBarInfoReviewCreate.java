package com.flavorsujung.isthereopen.domain.req;

import com.flavorsujung.isthereopen.domain.mappedenum.*;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Convert;

@Getter
@Setter
public class ReqBarInfoReviewCreate {
    Long userSeq;
    @Convert(converter = OpenStyleConverter.class)
    OpenStyle openStyle; //0 잘 지키는 편, 1 보통, 2 들쭉날쭉 지맘대로
    @Convert(converter = CleannessConverter.class)
    Cleanness cleanness;
    @Convert(converter = MoodConverter.class)
    Mood mood; //0 조용, 1 보통, 2 시끄러움
    Integer mainAlcohol; // 0 소주, 1 맥주, 2 막걸리, 3 와인, 4 보드카
    @Convert(converter = PriceConverter.class)
    Price price; //0 쌈, 1 보통, 2 비쌈
}
