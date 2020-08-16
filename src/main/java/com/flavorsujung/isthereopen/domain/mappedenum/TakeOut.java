package com.flavorsujung.isthereopen.domain.mappedenum;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public enum TakeOut {
    UNABLE(0),
    POSSIBLE(1);
    private final int takeout;
    public static TakeOut valueOf(int takeout) {
        for(TakeOut t : values())
            if(t.getTakeout() == takeout)
                return t;
        return null;
    }
}
