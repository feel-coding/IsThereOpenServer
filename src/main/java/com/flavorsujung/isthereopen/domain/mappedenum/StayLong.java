package com.flavorsujung.isthereopen.domain.mappedenum;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public enum StayLong {
    // 0 가능, 1 보통, 2 눈치보임, 3 포장 전용
    POSSIBLE(0),
    NORMAL(1),
    UNCOMFORTABLE(2),
    TAKEOUT(3);

    private final int stayLong;
    public static StayLong valueOf(int stayLong) {
        for(StayLong stay : values())
            if(stay.getStayLong() == stayLong)
                return stay;
        return null;
    }
}
