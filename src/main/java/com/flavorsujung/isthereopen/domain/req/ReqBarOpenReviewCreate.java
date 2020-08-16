package com.flavorsujung.isthereopen.domain.req;

import com.flavorsujung.isthereopen.domain.mappedenum.OpenState;
import com.flavorsujung.isthereopen.domain.mappedenum.OpenStateConverter;
import com.flavorsujung.isthereopen.domain.mappedenum.PriceConverter;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Convert;
import java.util.Date;


@Getter
@Setter
public class ReqBarOpenReviewCreate {
    Long userSeq;
    @Convert(converter = OpenStateConverter.class)
    OpenState openState; //0 close, 1 break time, 2 open, 3 미확인
    Date lastUpdate;
}
