package com.example.climbingapp;

import java.util.ArrayList;

public class TrainingDB {
    ArrayList<Double> edgeSizeArray = new ArrayList<>();
    ArrayList<Double> hangLengthArray = new ArrayList<>();

    public TrainingDB(){}

    public void save(TrainingProgram t){
        double edge = t.getEdgeSizemm();
        double length = t.getHangLengths();

        edgeSizeArray.add(edge);
        hangLengthArray.add(length);
    }





}

