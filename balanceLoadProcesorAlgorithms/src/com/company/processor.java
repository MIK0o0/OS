package com.company;

import java.util.ArrayList;
import java.util.Random;

public class processor {
    private Random random = new Random();
    private ArrayList<task> processes;
    private int load;
    int number;
    public int avgLoad;

    public processor(int nr){
        this.number = nr;
        processes = new ArrayList<>();
        load = 0;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public ArrayList<task> getProcesses() {
        return processes;
    }

    public void setProcesses(ArrayList<task> processes) {
        this.processes = processes;
    }

    public int getLoad() {
        return load;
    }

    public void setLoad(int load) {
        this.load = load;
    }
    public void add(task process){
        processes.add(process);
        load+=process.getNeedPower();
    }
    public task remove(){
        task tym = processes.get(0);
        processes.remove(0);
        load-= tym.getNeedPower();
        return tym;
    }
    public task newProcess(){
        int tym = random.nextInt(0,17);
        if (tym == 5){
            return new task();
        }
        return null;
    }
    public void minusTime(){
        for (int i = 0;i<processes.size();i++) {
            processes.get(i).setLastingTime(processes.get(i).getLastingTime() - 1);
            if (processes.get(i).getLastingTime() <= 0) {
                load -= processes.get(i).getNeedPower();
                processes.remove(processes.get(i));
            } else
                avgLoad += processes.get(i).getNeedPower();
        }
        }

}
