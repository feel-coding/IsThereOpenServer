package com.flavorsujung.isthereopen.domain.mappedenum;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public enum EatAlone { // 0 가능, 1 약간 눈치보임, 2 불가능
    POSSIBLE(0),
    UNCOMFORTABLE(1),
    UNABLE(2);

    private final int eatAlone;

    public static EatAlone valueOf(int eatAlone) {
        for(EatAlone eat : values())
            if(eat.getEatAlone() == eatAlone)
                return eat;
        return null;
    }
}
