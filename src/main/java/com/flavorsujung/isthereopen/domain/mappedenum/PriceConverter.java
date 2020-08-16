package com.flavorsujung.isthereopen.domain.mappedenum;

import javax.persistence.AttributeConverter;

public class PriceConverter implements AttributeConverter<Price,Integer> {
    @Override
    public Integer convertToDatabaseColumn(Price price) {
        return price.getPrice();
    }

    @Override
    public Price convertToEntityAttribute(Integer integer) {
        return Price.valueOf(integer);
    }
}
