package com.github.davstromb;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.github.davstromb.model.NativeKeyLogEvent;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Collections;

public class NativeKeyLoggerService implements NativeKeyLogger {

    private static final String TRAINING_DATA_FILE = "trainingData.ndjson";

    private final ObjectMapper objectMapper;

    NativeKeyLoggerService() {
        objectMapper = new ObjectMapper();
        objectMapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);
    }

    @Override
    public void appendTrainingData(NativeKeyLogEvent nativeKeyLogEvent) {
        System.out.println(nativeKeyLogEvent.toString());
        try {
            Files.write(
                    Paths.get(TRAINING_DATA_FILE),
                    Collections.singletonList(objectMapper.writeValueAsString(nativeKeyLogEvent)),
                    StandardCharsets.UTF_8,
                    StandardOpenOption.CREATE,
                    StandardOpenOption.APPEND);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
