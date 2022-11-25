package com.company;

import java.util.Random;

public class task {
    private Random random = new Random();
    private int needPower;
    private int lastingTime;
    public task(){
        this.needPower = random.nextInt(1,50);
        this.lastingTime = random.nextInt(10,110);
    }

    public int getNeedPower() {
        return needPower;
    }

    public void setNeedPower(int needPower) {
        this.needPower = needPower;
    }

    public int getLastingTime() {
        return lastingTime;
    }

    public void setLastingTime(int lastingTime) {
        this.lastingTime = lastingTime;
    }

}
