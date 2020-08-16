package com.flavorsujung.isthereopen.domain.mappedenum;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public enum TableHeight {//0 낮음, 1 보통, 2 높음
    LOW(0),
    NORMAL(1),
    HIGH(2);
    private final int tableHeight;
    public static TableHeight valueOf(int tableHeight) {
        for(TableHeight height : values())
            if(height.getTableHeight() == tableHeight)
                return height;
        return null;
    }
}
