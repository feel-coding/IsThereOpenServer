package com.flavorsujung.isthereopen.domain.mappedenum;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public enum OpenState {
    CLOSE(0),
    BREAK(1),
    OPEN(2),
    UNKNOWN(3);

    private final int state;

    public static OpenState valueOf(int state) {
        for(OpenState openState : values())
            if(openState.getState() == state)
                return openState;
        return null;
    }
}
