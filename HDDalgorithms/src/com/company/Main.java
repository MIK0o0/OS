package com.company;

import Algorytmy.*;

import java.io.IOException;
import java.util.ArrayList;

public class Main {
    public static int max = 180;

    public static void main(String[] args) throws IOException {
    tasksGenerator generator = new tasksGenerator();
    int n = 1000;
    int arrivalTime = 2;
    generator.generator(n,arrivalTime,max);
    ArrayList<Task> tasks = generator.reader();
    String main = "Liczba przesunięć głowicy dla n = " + n + ", czas pracy = " + arrivalTime + ", wielkość dysku = " + max + ", dla : ";
        System.out.println(main);



    FCFS fcfs = new FCFS();
    String fcfsString = "Algorytmu FCFS : "+fcfs.fcfsAlgo(tasks);
    System.out.println(fcfsString);

    SSTF sstf = new SSTF();
    String sstfString = "Algorytmu SSTF : " + sstf.sstfAlgo(tasks);
        System.out.println(sstfString);

    SCAN scan = new SCAN();
    String scamString = "Algorytmu SCAN : " + scan.scanAlgo(tasks);
        System.out.println(scamString);

    CSCAN cscan = new CSCAN();
    String cscamString = "Algorytmu CSCAN : " + cscan.cscanAlgo(tasks);
        System.out.println(cscamString);

    EDF edf = new EDF();
    String edfString = "Algorytmu EDF : " + edf.edfAlgo(tasks);
        System.out.println(edfString);

    FD_SCAN fd_scan =  new FD_SCAN();
    String fdString = "Algorytmu FD-SCAN : " + fd_scan.fdscanAlgo(tasks);
        System.out.println(fdString);

    Zapis zapis = new Zapis();
    zapis.zapis(main,fcfsString,sstfString,scamString,cscamString,edfString,fdString);

}

}
