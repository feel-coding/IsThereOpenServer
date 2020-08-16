package com.flavorsujung.isthereopen.domain.mappedenum;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public enum WaitingTime {
    SHORT(0),
    NORMAL(1),
    LONG(2);
    private final int waitingTime;

    public static WaitingTime valueOf(int waitingTime) {
        for(WaitingTime w : values())
            if(w.getWaitingTime() == waitingTime)
                return w;
            return null;
    }
}
