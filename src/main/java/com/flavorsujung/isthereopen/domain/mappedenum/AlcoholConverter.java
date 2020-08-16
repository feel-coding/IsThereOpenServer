package com.flavorsujung.isthereopen.domain.mappedenum;

import javax.persistence.AttributeConverter;

public class AlcoholConverter  implements AttributeConverter<Alcohol,Integer> {
    //저장하는 함수
    @Override
    public Integer convertToDatabaseColumn(Alcohol alcohol) {
        return alcohol.getAlcohol();
    }

    //가져오는 함수
    @Override
    public Alcohol convertToEntityAttribute(Integer integer) {
        return Alcohol.valueOf(integer);
    }
}
