package Algorithms;

import com.company.Call;

import java.util.ArrayList;

public class LRU {
    public int[] lruAlgo(ArrayList<Call> list) {
        int[] result = new int[4];
        ArrayList<Call> ramka3 = new ArrayList<>();
        ArrayList<Call> ramka7 = new ArrayList<>();
        ArrayList<Call> ramka10 = new ArrayList<>();
        ArrayList<Call> ramka100 = new ArrayList<>();
        for (int k = 0; k < list.size(); k++) {
            result[0] += check(ramka3,3,list.get(k));
            result[1] += check(ramka7,7,list.get(k));
            result[2] += check(ramka10,10,list.get(k));
            result[3] += check(ramka100,100,list.get(k));
        }
        return result;
    }
    public int check(ArrayList<Call> tab,int size, Call c){
        for (int i = 0; i < tab.size(); i++) {
            if (tab.get(i).equals(c)) {
                Call tym = tab.get(i);
                tab.remove(i);
                tab.add(tym);
                return 0;
            }
        }
        if (tab.size() >= size) {
            tab.remove(0);
        }
        tab.add(c);
        return 1;
    }
}

