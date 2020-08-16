package com.flavorsujung.isthereopen.domain.mappedenum;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public enum Cleanness {//0 깨끗함, 1 보통, 2 더러움
    CLEAN(0),
    NORMAL(1),
    DIRTY(2);

    private final int cleanness;

    public static Cleanness valueOf(int cleanness) {
        for(Cleanness c : values())
            if(c.getCleanness() == cleanness)
                return c;
            return null;
    }
}
