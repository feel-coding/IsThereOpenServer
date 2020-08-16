package com.flavorsujung.isthereopen.domain.mappedenum;

import javax.persistence.AttributeConverter;

public class EatAloneConverter implements AttributeConverter<EatAlone,Integer> {
    //저장하는 함수
    @Override
    public Integer convertToDatabaseColumn(EatAlone eatAlone) {
        return eatAlone.getEatAlone();
    }

    //가져오는 함수
    @Override
    public EatAlone convertToEntityAttribute(Integer integer) {
        return EatAlone.valueOf(integer);
    }
}
