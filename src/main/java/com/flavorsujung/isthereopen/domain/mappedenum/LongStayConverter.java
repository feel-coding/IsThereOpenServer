package com.flavorsujung.isthereopen.domain.mappedenum;

import javax.persistence.AttributeConverter;

public class LongStayConverter implements AttributeConverter<LongStay,Integer> {

    //저장하는 함수
    @Override
    public Integer convertToDatabaseColumn(LongStay longStay) {
        return longStay.getLongStay();
    }

    //가져오는 함수
    @Override
    public LongStay convertToEntityAttribute(Integer integer) {
        return LongStay.valueOf(integer);
    }
}
