package com.flavorsujung.isthereopen.domain.mappedenum;

import javax.persistence.AttributeConverter;

public class TableHeightConverter implements AttributeConverter<TableHeight,Integer> {

    //저장하는 함수
    @Override
    public Integer convertToDatabaseColumn(TableHeight tableHeight) {
        return tableHeight.getTableHeight();
    }

    //가져오는 함수
    @Override
    public TableHeight convertToEntityAttribute(Integer integer) {
        return TableHeight.valueOf(integer);
    }
}
