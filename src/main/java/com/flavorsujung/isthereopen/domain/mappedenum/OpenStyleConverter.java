package com.flavorsujung.isthereopen.domain.mappedenum;

import javax.persistence.AttributeConverter;

public class OpenStyleConverter implements AttributeConverter<OpenStyle,Integer> {
    @Override
    public Integer convertToDatabaseColumn(OpenStyle openStyle) {
        return openStyle.getStyle();
    }

    @Override
    public OpenStyle convertToEntityAttribute(Integer integer) {
        return OpenStyle.valueOf(integer);
    }
}
