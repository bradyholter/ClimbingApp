package com.example.climbingapp;

import java.io.FileWriter;
import java.io.IOException;

public class CSVHandler {
    private static final String FILE_NAME = "sessions.csv";

    public static void saveSession(HangSession session) {
        try (FileWriter writer = new FileWriter(FILE_NAME, true)) {
            writer.write(session.toCSVString() + "\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
