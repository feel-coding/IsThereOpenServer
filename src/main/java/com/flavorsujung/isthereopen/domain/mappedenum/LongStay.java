package com.flavorsujung.isthereopen.domain.mappedenum;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public enum LongStay {
    // 0 가능, 1 보통, 2 눈치보임
    POSSIBLE(0),
    NORMAL(1),
    UNCOMFORTABLE(2);
    private final int longStay;
    public static LongStay valueOf(int longStay) {
        for(LongStay stay : values())
            if(stay.getLongStay() == longStay)
                return stay;
        return null;
    }
}
