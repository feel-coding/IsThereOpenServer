package com.flavorsujung.isthereopen.domain.mappedenum;

import javax.persistence.AttributeConverter;

public class RateConverter implements AttributeConverter<Rate,Integer> {
    @Override
    public Integer convertToDatabaseColumn(Rate rate) {
        return rate.getRate();
    }

    @Override
    public Rate convertToEntityAttribute(Integer integer) {
        return Rate.valueOf(integer);
    }
}
