package com.example.climbingapp;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class HangSession {
    private LocalDateTime timestamp;
    private String edgeSize;
    private double duration;

    public HangSession(LocalDateTime timestamp, String edgeSize, double duration) {
        this.timestamp = timestamp;
        this.edgeSize = edgeSize;
        this.duration = duration;
    }

    public String toCSVString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        return String.format("%s,%s,%.2f", timestamp.format(formatter), edgeSize, duration);
    }
}
