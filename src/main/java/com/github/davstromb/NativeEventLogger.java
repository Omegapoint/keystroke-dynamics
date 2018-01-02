package com.github.davstromb;

import com.github.davstromb.model.NativeKeyType;
import com.github.davstromb.model.NativeKeyboardEvent;
import com.github.davstromb.model.NativeMouseEvent;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;

import static java.nio.charset.StandardCharsets.UTF_8;

public class NativeEventLogger {

    public final static String KEYBOARD_EVENT_LOG = "events.log";

    public NativeEventLogger() {

    }

    public NativeKeyboardEvent persist(final NativeKeyboardEvent event) {
        if(event.type.equals(NativeKeyType.TYPED)) {
            return event;
        }

        final List<String> lines = new ArrayList<String>(){{add(event.toString());}};

        try {
            final Path path = Paths.get(getClass().getClassLoader().getResource(KEYBOARD_EVENT_LOG).toURI());
            Files.write(path, lines, UTF_8, StandardOpenOption.APPEND, StandardOpenOption.CREATE);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return event;
    }

    public NativeMouseEvent persist(NativeMouseEvent event) {

        return event;
    }
}
