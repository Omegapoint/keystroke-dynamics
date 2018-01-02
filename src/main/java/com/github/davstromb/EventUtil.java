package com.github.davstromb;

import com.github.davstromb.model.*;
import org.jnativehook.NativeInputEvent;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;

public class EventUtil {

    public static LocalDateTime getTimeStamp(NativeInputEvent e) {
        return Instant.ofEpochMilli(e.getWhen()).atZone(ZoneId.systemDefault()).toLocalDateTime();
    }

    public static LocalDateTime getTimeStamp(long nanoSeconds) {
        return Instant.ofEpochMilli(nanoSeconds).atZone(ZoneId.systemDefault()).toLocalDateTime();
    }


    public static NativeMouseEvent toMouseEvent(NativeInputEvent e, NativeMouseType type) {
        return NativeMouseEvent.builder()
                .withDatetime(e.getWhen())
                .withType(type)
                .build();
    }

    public static NativeKeyboardEvent toKeyEvent(NativeInputEvent e, NativeKeyType type) {

        String[] params = e.paramString().split(",");

        return NativeKeyboardEvent.builder()
                .withDatetime(e.getWhen())
                .withType(type)
                .withKeyCode(params[1].split("=")[1])
                .withKeyText(params[2].split("=")[1])
                .withKeyChar(params[3].split("=")[1])
                .withKeyLocation(params[4].split("=")[1])
                .withRawCode(params[5].split("=")[1])
                .withRawData(e.paramString())
                .build();
    }

    private static NativeMouseType getType(NativeInputEvent e) {
        return null;
    }


    public static NativeKeyboardEvent getNativeKeyboardEvent(NativeInputEvent e) {
        final String type = e.paramString().split(",")[0];

        switch (type) {
//            case "NATIVE_MOUSE_MOVED": return toMouseEvent(e, NativeMouseType.NATIVE_MOUSE_MOVED);
            case "NATIVE_KEY_PRESSED": return toKeyEvent(e, NativeKeyType.PRESSED);
            case "NATIVE_KEY_RELEASED": return toKeyEvent(e, NativeKeyType.RELEASED);
            case "NATIVE_KEY_TYPED": return toKeyEvent(e, NativeKeyType.TYPED);
            default: return null;
        }

    }

    public static String eventType(NativeInputEvent e) {
        final String type = e.paramString().split(",")[0];

        switch (type) {
            case "NATIVE_MOUSE_MOVED": return "MOUSE";
            case "NATIVE_KEY_PRESSED": return "KEYBOARD";
            case "NATIVE_KEY_RELEASED": return "KEYBOARD";
            case "NATIVE_KEY_TYPED": return "KEYBOARD";
            default: return null;
        }
    }

    public static NativeMouseEvent getNativeMouseEvent(NativeInputEvent e) {
        return new NativeMouseEvent(null, null);
    }
}
