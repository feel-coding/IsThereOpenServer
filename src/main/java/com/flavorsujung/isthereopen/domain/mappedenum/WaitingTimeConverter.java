package com.flavorsujung.isthereopen.domain.mappedenum;

import javax.persistence.AttributeConverter;

public class WaitingTimeConverter implements AttributeConverter<WaitingTime,Integer> {
    @Override
    public Integer convertToDatabaseColumn(WaitingTime waitingTime) {
        return waitingTime.getWaitingTime();
    }

    @Override
    public WaitingTime convertToEntityAttribute(Integer integer) {
        return WaitingTime.valueOf(integer);
    }
}
