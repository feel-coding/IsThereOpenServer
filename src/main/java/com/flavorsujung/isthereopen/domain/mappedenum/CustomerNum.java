package com.flavorsujung.isthereopen.domain.mappedenum;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public enum CustomerNum {// 0 적음, 1 보통, 2 많음
    UNCROWDED(0),
    NORMAL(1),
    CROWDED(2);
    private final int customerNum;
    public static CustomerNum valueOf(int customerNum) {
        for(CustomerNum num : values())
            if(num.getCustomerNum() == customerNum)
                return num;
        return null;
    }
}
