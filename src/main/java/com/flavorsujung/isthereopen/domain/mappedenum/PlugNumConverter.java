package com.flavorsujung.isthereopen.domain.mappedenum;

import javax.persistence.AttributeConverter;

public class PlugNumConverter implements AttributeConverter<PlugNum,Integer> {

    //저장하는 함수
    @Override
    public Integer convertToDatabaseColumn(PlugNum mood) {
        return mood.getPlugNum();
    }

    //가져오는 함수
    @Override
    public PlugNum convertToEntityAttribute(Integer integer) {
        return PlugNum.valueOf(integer);
    }
}
