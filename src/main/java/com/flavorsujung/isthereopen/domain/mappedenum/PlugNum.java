package com.flavorsujung.isthereopen.domain.mappedenum;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public enum PlugNum { // 0 적음, 1 보통, 2 많음
    LITTLE(0),
    NORMAL(1),
    MANY(2);
    private final int plugNum;
    public static PlugNum valueOf(int plugNum) {
        for(PlugNum num : values())
            if(num.getPlugNum() == plugNum)
                return num;
        return null;
    }
}
