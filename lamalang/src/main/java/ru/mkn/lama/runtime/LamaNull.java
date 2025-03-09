package ru.mkn.lama.runtime;

import com.oracle.truffle.api.interop.TruffleObject;

@SuppressWarnings("static-method")
public final class LamaNull implements TruffleObject {

    public static final LamaNull INSTANCE = new LamaNull();
    private LamaNull() {
    }

    boolean isNull() {
        return true;
    }
}