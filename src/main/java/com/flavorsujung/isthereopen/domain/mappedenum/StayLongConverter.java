package com.flavorsujung.isthereopen.domain.mappedenum;

import javax.persistence.AttributeConverter;

public class StayLongConverter implements AttributeConverter<StayLong,Integer> {

    //저장하는 함수
    @Override
    public Integer convertToDatabaseColumn(StayLong stayLong) {
        return stayLong.getStayLong();
    }

    //가져오는 함수
    @Override
    public StayLong convertToEntityAttribute(Integer integer) {
        return StayLong.valueOf(integer);
    }
}
