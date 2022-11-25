package com.company;

import java.io.Serializable;

public class Task implements Serializable {
    private final static long serialVersionUID = -8420577340779607644L;
    private int number;
    public int arrivalTime;
    private int segmentNUM;
    private boolean piorytet;
    private int deadLine;

    public Task(int number, int segement, int arrivalTime, boolean piorytet,int deadLine) {
        this.number = number;
        this.arrivalTime = arrivalTime;
        this.segmentNUM = segement;
        this.piorytet = piorytet;
        this.deadLine = deadLine;
    }

    @Override
    public String toString() {
        return "Task{" +
                "number=" + number +
                ", arrivalTime=" + arrivalTime +
                ", segmentNUM=" + segmentNUM +
                ", piorytet=" + piorytet +
                '\n';
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }


    public int getArrivalTime() {
        return this.arrivalTime;
    }

    public void setArrivalTime(int arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    public int getSegment() {
        return segmentNUM;
    }

    public void setWaitingTime(int waitingTime) {
        this.segmentNUM = waitingTime;
    }

    public boolean isPiorytet() {
        return piorytet;
    }

    public void setPiorytet(boolean piorytet) {
        this.piorytet = piorytet;
    }

    public int getSegmentNUM() {
        return segmentNUM;
    }

    public void setSegmentNUM(int segmentNUM) {
        this.segmentNUM = segmentNUM;
    }

    public int getDeadLine() {
        return deadLine;
    }

    public void setDeadLine(int deadLine) {
        this.deadLine = deadLine;
    }
}
