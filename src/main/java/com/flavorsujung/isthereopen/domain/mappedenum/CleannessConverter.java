package com.flavorsujung.isthereopen.domain.mappedenum;

import javax.persistence.AttributeConverter;

public class CleannessConverter implements AttributeConverter<Cleanness,Integer> {
    //저장하는 함수
    @Override
    public Integer convertToDatabaseColumn(Cleanness cleanness) {
        return cleanness.getCleanness();
    }

    //가져오는 함수
    @Override
    public Cleanness convertToEntityAttribute(Integer integer) {
        return Cleanness.valueOf(integer);
    }
}
