package com.flavorsujung.isthereopen.domain.mappedenum;

import javax.persistence.AttributeConverter;

public class MoodConverter implements AttributeConverter<Mood,Integer> {

    //저장하는 함수
    @Override
    public Integer convertToDatabaseColumn(Mood mood) {
        return mood.getMood();
    }

    //가져오는 함수
    @Override
    public Mood convertToEntityAttribute(Integer integer) {
        return Mood.valueOf(integer);
    }
}
