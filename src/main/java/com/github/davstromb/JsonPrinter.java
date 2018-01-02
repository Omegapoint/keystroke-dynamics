package com.github.davstromb;

public class JsonPrinter implements AnalyticsInterface{


    @Override
    public void appendKeystroke(Object o) {
        System.out.println(o);
    }
}
