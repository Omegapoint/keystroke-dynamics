package com.github.davstromb.model;

import java.time.LocalDateTime;

public class NativeKeyboardEvent implements NativeEvent {


    public final LocalDateTime dateTime;
    public final NativeKeyType type;
    public final static String superType = "KEY";
    public final String rawData;
    private final String keyCode;
    private final String keyText;
    private final String keyChar;
    private final String keyLocation;
    private final String rawCode;

    public NativeKeyboardEvent(LocalDateTime dateTime,
                               NativeKeyType type,
                               String rawData,
                               String keyCode,
                               String keyText,
                               String keyChar,
                               String keyLocation,
                               String rawCode) {
        this.dateTime = dateTime;
        this.type = type;
        this.rawData = rawData;
        this.keyCode = keyCode;
        this.keyText = keyText;
        this.keyChar = keyChar;
        this.keyLocation = keyLocation;
        this.rawCode = rawCode;
    }

    public static NativeKeyboardEventBuilder builder() {
        return new NativeKeyboardEventBuilder();
    }

    public String superType() {
        return this.superType;
    }

    @Override
    public LocalDateTime time() {
        return this.dateTime;
    }

    @Override
    public String name() {
        return this.type.toString();
    }

    @Override
    public String toString() {
        return superType() + ";" + name() + ";" + time() + ";" + keyCode + ";" + keyText;
    }
}
