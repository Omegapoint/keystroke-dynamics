package com.github.davstromb.model;

import com.github.davstromb.EventUtil;

import java.time.LocalDateTime;

public class NativeKeyboardEventBuilder {

    private LocalDateTime dateTime;
    private NativeKeyType type;
    private String rawData;
    private String keyCode;
    private String keyText;
    private String keyChar;
    private String keyLocation;
    private String rawCode;

    public NativeKeyboardEvent build() {
        return new NativeKeyboardEvent(dateTime, type, rawData, keyCode, keyText, keyChar,keyLocation, rawCode);
    }

    public NativeKeyboardEventBuilder withDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
        return this;
    }

    public NativeKeyboardEventBuilder withDatetime(long nanoSeconds) {
        this.dateTime = EventUtil.getTimeStamp(nanoSeconds);
        return this;
    }


    public NativeKeyboardEventBuilder withType(NativeKeyType type) {
        this.type = type;
        return this;
    }

    public NativeKeyboardEventBuilder withRawData(String s) {
        this.rawData = s;
        return this;
    }

    public NativeKeyboardEventBuilder withKeyCode(String s) {
        this.keyCode = s;
        return this;
    }

    public NativeKeyboardEventBuilder withKeyText(String s) {
        this.keyText = s;
        return this;
    }

    public NativeKeyboardEventBuilder withKeyChar(String s) {
        this.keyChar = s;
        return this;
    }

    public NativeKeyboardEventBuilder withKeyLocation(String s) {
        this.keyLocation = s;
        return this;
    }

    public NativeKeyboardEventBuilder withRawCode(String s) {
        this.rawCode = s;
        return this;
    }
}
