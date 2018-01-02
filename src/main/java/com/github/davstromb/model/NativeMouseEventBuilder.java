package com.github.davstromb.model;

import com.github.davstromb.EventUtil;

import java.time.LocalDateTime;

public class NativeMouseEventBuilder {


    private LocalDateTime dateTime;
    private NativeMouseType type;

    public NativeMouseEventBuilder() {}

    public NativeMouseEvent build() {
        return new NativeMouseEvent(dateTime, type);
    }

    public NativeMouseEventBuilder withDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
        return this;
    }

    public NativeMouseEventBuilder withDatetime(long nanoSeconds) {
        this.dateTime = EventUtil.getTimeStamp(nanoSeconds);
        return this;
    }

    public NativeMouseEventBuilder withType(NativeMouseType type) {
        this.type = type;
        return this;
    }
}
