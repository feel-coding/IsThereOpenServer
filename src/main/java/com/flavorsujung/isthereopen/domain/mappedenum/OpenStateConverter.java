package com.flavorsujung.isthereopen.domain.mappedenum;

import com.mysql.cj.x.protobuf.MysqlxCursor;

import javax.persistence.AttributeConverter;

public class OpenStateConverter implements AttributeConverter<OpenState,Integer> {

    @Override
    public Integer convertToDatabaseColumn(OpenState openState) {
        return openState.getState();
    }

    @Override
    public OpenState convertToEntityAttribute(Integer integer) {
        return OpenState.valueOf(integer);
    }
}
