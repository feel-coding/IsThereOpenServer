package com.flavorsujung.isthereopen.domain.mappedenum;

import javax.persistence.AttributeConverter;

public class LightnessConverter implements AttributeConverter<Lightness,Integer> {
    //저장하는 함수
    @Override
    public Integer convertToDatabaseColumn(Lightness lightness) {
        return lightness.getLightness();
    }

    //가져오는 함수
    @Override
    public Lightness convertToEntityAttribute(Integer integer) {
        return Lightness.valueOf(integer);
    }
}

