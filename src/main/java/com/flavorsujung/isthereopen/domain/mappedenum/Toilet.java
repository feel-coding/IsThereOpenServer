package com.flavorsujung.isthereopen.domain.mappedenum;

import lombok.RequiredArgsConstructor;
import lombok.Getter;

@RequiredArgsConstructor
@Getter
public enum Toilet {
    SEPARATION(0),
    ONE(1);

    private final int toilet;

    public static Toilet valueOf(int toilet) {
        for(Toilet p : values())
            if(p.getToilet() == toilet)
                return p;
        return null;
    }
}
