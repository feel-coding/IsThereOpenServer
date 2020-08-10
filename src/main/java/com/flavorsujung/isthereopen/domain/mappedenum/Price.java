package com.flavorsujung.isthereopen.domain.mappedenum;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public enum Price {
    CHEAP(0),
    NORMAL(1),
    EXPENSIVE(2);
    @Getter
    private final int price;

    public static Price valueOf(int price) {
        for(Price p : values())
            if(p.getPrice() == price)
                return p;
        return null;
    }
}
