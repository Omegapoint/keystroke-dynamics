package com.github.davstromb.model;

import java.time.LocalDateTime;

public interface NativeEvent {

    public LocalDateTime time();

    public String name();

}
