package com.example.climbingapp;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import javafx.util.Duration;
import javafx.animation.*;

import java.io.PrintStream;

public class HangboardTrainer extends Application {

    private Label timerLabel;
    private TextField edgeSizeField;
    private Button startButton;
    private Button stopButton;
    private Button resetButton;
    private Label climbingLabel;
    private Label textLabel;

    private Timeline timeline;
    private double secondsElapsed = 0.00;

    @Override
    public void start(Stage primaryStage) {
        edgeSizeField = new TextField();
        edgeSizeField.setPromptText("Edge size (mm)");

        timerLabel = new Label("0.00s");
        timerLabel.setStyle("-fx-font-size: 40px;");

        textLabel = new Label("Enter Edge Size(mm): ");

        startButton = new Button("Start Hang");
        stopButton = new Button("Stop Hang");
        resetButton = new Button("Reset Timer");
        climbingLabel = new Label("Climbing App: ");
        stopButton.setDisable(true);

        startButton.setOnAction(e -> startHang());
        stopButton.setOnAction(e -> stopHang());
        resetButton.setOnAction(e -> resetTimer());

        Pane layout = new Pane(climbingLabel, textLabel, edgeSizeField, timerLabel, startButton, stopButton, resetButton);
        textLabel.relocate(10, 160);
        edgeSizeField.relocate(135, 157);
        climbingLabel.relocate(10, 10);
        timerLabel.relocate(210, 40);
        startButton.relocate(10, 200);
        stopButton.relocate(10, 240);
        resetButton.relocate(100, 200);
        layout.setStyle("-fx-padding: 20px;");

        Scene scene = new Scene(layout, 500, 400);
        primaryStage.setTitle("Hangboard Trainer");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void startHang() {
        secondsElapsed = 0.00;
        timerLabel.setText("0.00s");
        startButton.setDisable(true);
        stopButton.setDisable(false);

        timeline = new Timeline(new KeyFrame(Duration.millis(10), e -> {
            secondsElapsed += 0.01;
            timerLabel.setText(String.format("%.2fs", secondsElapsed));
        }));
        timeline.setCycleCount(Animation.INDEFINITE);
        timeline.play();
    }

    private void stopHang() {
        if (timeline != null) {
            timeline.stop();
        }
        stopButton.setDisable(true);
        startButton.setDisable(false);
    }

    private void resetTimer() {
        if (timeline != null) {
            timeline.stop();
        }
        timerLabel.setText("0.00s");
        stopButton.setDisable(true);
        startButton.setDisable(false);
    }

    public static void main(String[] args) {
        launch(args);
    }
}
