package com.flavorsujung.isthereopen.domain.req;

import com.flavorsujung.isthereopen.domain.mappedenum.Mood;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ReqBarInfoReviewCreate {
    Integer userSeq;
    Integer openStyle; //0 잘 지키는 편, 1 보통, 2 들쭉날쭉 지맘대로
    Integer cleanness;
    Mood mood; //0 조용, 1 보통, 2 시끄러움
    Integer mainAlcohol; // 0 소주, 1 맥주, 2 막걸리, 3 와인, 4 보드카
    Integer price; //0 쌈, 1 보통, 2 비쌈
}
