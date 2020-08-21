package com.flavorsujung.isthereopen.domain.mappedenum;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public enum Rate {
    WORST(1),
    BAD(2),
    SOSO(3),
    GOOD(4),
    BEST(5);

    private final int rate;

    public static Rate valueOf(int rate) {
        for(Rate p : values())
            if(p.getRate() == rate)
                return p;
        return null;
    }
}
