package Algorytmy;

import com.company.Task;

import java.util.ArrayList;

public class FCFS {
    public int fcfsAlgo(ArrayList<Task> list){
        int wynik = 0;
        int headSegment = list.get(0).getSegment();
        for(Task t : list){
            wynik += Math.abs(headSegment - t.getSegment());
            headSegment = t.getSegment();
        }
        return wynik;
    }
}
