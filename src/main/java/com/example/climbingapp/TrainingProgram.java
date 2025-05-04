package com.example.climbingapp;

public class TrainingProgram {
    private double edgeSizemm;
    private double hangLengths;
    private TrainingDB myDB = new TrainingDB();

    public TrainingProgram(){
        edgeSizemm = 20;
        hangLengths = 15;
    }

    public TrainingProgram(double edgeSize, double hangLength){
        edgeSizemm = edgeSize;
        hangLengths = hangLength;
    }

    public double getEdgeSizemm() {
        return edgeSizemm;
    }

    public void setEdgeSizemm(double edgeSizemm) {
        this.edgeSizemm = edgeSizemm;
    }

    public double getHangLengths() {
        return hangLengths;
    }

    public void setHangLengths(double hangLengths) {
        this.hangLengths = hangLengths;
    }

    public void saveToDB(){
        myDB.save(this);
    }
}
