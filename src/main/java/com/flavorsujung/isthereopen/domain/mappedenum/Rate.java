package com.flavorsujung.isthereopen.domain.mappedenum;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public enum Rate {
    WORST(0),
    BAD(1),
    SOSO(2),
    GOOD(3),
    BEST(4);

    private final int rate;

    public static Rate valueOf(int rate) {
        for(Rate p : values())
            if(p.getRate() == rate)
                return p;
        return null;
    }
}
