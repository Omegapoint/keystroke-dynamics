package com.github.davstromb.model;

import java.time.LocalDateTime;

public class NativeMouseEvent implements NativeEvent{

    private final NativeMouseType type;
    private final LocalDateTime dateTime;

    public NativeMouseEvent(LocalDateTime dateTime, NativeMouseType type) {
        this.dateTime = dateTime;
        this.type = type;
    }

    public static NativeMouseEventBuilder builder() {
        return new NativeMouseEventBuilder();
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
        return "(" + dateTime + ":" + type + ")";
    }
}
