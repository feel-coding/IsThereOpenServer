package com.flavorsujung.isthereopen.domain.mappedenum;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public enum Mood {
    SILENT(0),
    NORMAL(1),
    LOUD(2);
    @Getter
    private final int mood;

    public static Mood valueOf(int mood) {
        for(Mood m : values())
            if(m.getMood() == mood)
                return m;
        return null;
    }
}
