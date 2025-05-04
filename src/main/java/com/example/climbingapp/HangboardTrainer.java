package com.example.climbingapp;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import javafx.util.Duration;
import javafx.animation.*;

public class HangboardTrainer extends Application {

    private Label timerLabel;
    private TextField edgeSizeField;
    private Button startButton;
    private Button stopButton;
    private Button resetButton;

    private Timeline timeline;
    private int secondsElapsed = 0;

    @Override
    public void start(Stage primaryStage) {
        edgeSizeField = new TextField();
        edgeSizeField.setPromptText("Edge size (mm)");

        timerLabel = new Label("0s");
        timerLabel.setStyle("-fx-font-size: 24px;");

        startButton = new Button("Start Hang");
        stopButton = new Button("Stop Hang");
        resetButton = new Button("Reset Timer");
        stopButton.setDisable(true);

        startButton.setOnAction(e -> startHang());
        stopButton.setOnAction(e -> stopHang());
        resetButton.setOnAction(e -> resetTimer());

        VBox layout = new VBox(10, new Label("Edge Size (mm):"), edgeSizeField, timerLabel, startButton, stopButton, resetButton);
        layout.setStyle("-fx-padding: 20px;");

        Scene scene = new Scene(layout, 600, 400);
        primaryStage.setTitle("Hangboard Trainer");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void startHang() {
        secondsElapsed = 0;
        timerLabel.setText("0s");
        startButton.setDisable(true);
        stopButton.setDisable(false);

        timeline = new Timeline(new KeyFrame(Duration.seconds(1), e -> {
            secondsElapsed++;
            timerLabel.setText(secondsElapsed + "s");
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

    }

    public static void main(String[] args) {
        launch(args);
    }
}
