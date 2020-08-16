package com.flavorsujung.isthereopen.domain.mappedenum;

import javax.persistence.AttributeConverter;

public class TakeOutConverter implements AttributeConverter<TakeOut,Integer> {

    //저장하는 함수
    @Override
    public Integer convertToDatabaseColumn(TakeOut takeOut) {
        return takeOut.getTakeout();
    }

    //가져오는 함수
    @Override
    public TakeOut convertToEntityAttribute(Integer integer) {
        return TakeOut.valueOf(integer);
    }
}
