package com.flavorsujung.isthereopen.domain.mappedenum;

import javax.persistence.AttributeConverter;

public class ToiletConverter implements AttributeConverter<Toilet,Integer> {
    @Override
    public Integer convertToDatabaseColumn(Toilet toilet) {
        return toilet.getToilet();
    }

    @Override
    public Toilet convertToEntityAttribute(Integer integer) {
        return Toilet.valueOf(integer);
    }
}
