package com.company;

import Algorithms.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

public class Main {
    public static int max = 120;

    public static void main(String[] args) throws IOException {
    callGenerator generator = new callGenerator();
    int n = 100000;
    int arrivalTime = 20000;
    generator.generator(n,arrivalTime,max);
    ArrayList<Call> calls = generator.reader();
    String main = "Liczba błedów strony dla n = " + n + ", czas pracy = " + arrivalTime + ", wielkość pamięci fizycznej = " + max + ", dla : ";
        System.out.println(main);


        FIFO fifo = new FIFO();
        int[] fifoTab = fifo.fifoAlgo(calls);
        String fifoString = "\nFIFO z 3 ramkami : " + fifoTab[0] + "\n     z 7 ramkami : " + fifoTab[1] + "\n     z 10 ramkami : " + fifoTab[2] + "\n     z 100 ramkami : " + fifoTab[3];
        System.out.println(fifoString);

        OPT opt = new OPT();
        int[] optTab = opt.optAlgo(calls);
        String optString = "\nOPT z 3 ramkami : " + optTab[0] + "\n     z 7 ramkami : " + optTab[1] + "\n     z 10 ramkami : " + optTab[2] + "\n     z 100 ramkami : " + optTab[3];
        System.out.println(optString);

        LRU lru = new LRU();
        int[] lruTab = lru.lruAlgo(calls);
        String lruString = "\nLRU z 3 ramkami : " + lruTab[0] + "\n     z 7 ramkami : " + lruTab[1] + "\n     z 10 ramkami : " + lruTab[2] + "\n     z 100 ramkami : " + lruTab[3];
        System.out.println(lruString);

        AproxLRU alru = new AproxLRU();
        int[] alruTab = alru.alruAlgo(calls);
        String alruString = "\nALRU z 3 ramkami : " + alruTab[0] + "\n     z 7 ramkami : " + alruTab[1] + "\n     z 10 ramkami : " + alruTab[2] + "\n     z 100 ramkami : " + alruTab[3];
        System.out.println(alruString);

        RAND rand = new RAND();
        int[] randTab = rand.randAlgo(calls);
        String randString = "\nRAND z 3 ramkami : " + randTab[0] + "\n     z 7 ramkami : " + randTab[1] + "\n     z 10 ramkami : " + randTab[2] + "\n     z 100 ramkami : " + randTab[3];
        System.out.println(randString);

    Zapis zapis = new Zapis();
    zapis.zapis(main,fifoString,optString,lruString,alruString,randString);
}
public static void display(int[] tab){
        for (int i : tab){
            System.out.println(i);
        }
}

}
