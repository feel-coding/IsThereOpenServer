package com.flavorsujung.isthereopen.domain.req;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class ReqCafeOpenReviewCreate {
    Integer userSeq;
    Integer openState; //0 close, 1 break time, 2 open, 3 미확인
    Date lastUpdate;
}
