package com.flavorsujung.isthereopen.domain.mappedenum;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public enum Alcohol {// 0 소주, 1 맥주, 2 막걸리, 3 와인, 4 보드카
    SOJU(0),
    BEER(1),
    MAKGEOLLI(2),
    WINE(3),
    VODKA(4);

    private final int alcohol;
    public static Alcohol valueOf(int alcohol) {
        for(Alcohol a : values())
            if(a.getAlcohol() == alcohol)
                return a;
        return null;
    }
}
