package com.flavorsujung.isthereopen.domain.mappedenum;

import javax.persistence.AttributeConverter;

public class CustomerNumConverter implements AttributeConverter<CustomerNum, Integer> {
    //저장하는 함수
    @Override
    public Integer convertToDatabaseColumn(CustomerNum customerNum) {
        return customerNum.getCustomerNum();
    }

    //가져오는 함수
    @Override
    public CustomerNum convertToEntityAttribute(Integer integer) {
        return CustomerNum.valueOf(integer);
    }
}
