package com.github.davstromb;

import com.github.davstromb.model.NativeKeyLogEvent;

import java.io.IOException;

public interface NativeKeyLogger {

    void appendTrainingData(NativeKeyLogEvent nativeKeyLogEvent);
}
