package com.github.davstromb;

public class AnalyticsService implements AnalyticsInterface {


    public AnalyticsService create() {
        return new AnalyticsService();
    }


    @Override
    public void appendKeystroke(Object o) {

    }
}
