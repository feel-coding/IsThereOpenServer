package com.flavorsujung.isthereopen.domain.mappedenum;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public enum Lightness {// 0 어두움, 1 중간, 2 밝음
    DARK(0),
    NORMAL(1),
    LIGHT(2);
    private final int lightness;
    public static Lightness valueOf(int lightness) {
        for(Lightness l : values())
            if(l.getLightness() == lightness)
                return l;
        return null;
    }
}
