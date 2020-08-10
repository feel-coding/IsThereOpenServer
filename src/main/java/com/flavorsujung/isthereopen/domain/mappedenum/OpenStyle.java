package com.flavorsujung.isthereopen.domain.mappedenum;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public enum OpenStyle {
    STABLE(0),
    NORMAL(1),
    UNSTABLE(2);
    @Getter
    private final int style;

    public static OpenStyle valueOf(int style) {
        for(OpenStyle openStyle : values())
            if(openStyle.getStyle() == style)
                return openStyle;
        return null;
    }
}
