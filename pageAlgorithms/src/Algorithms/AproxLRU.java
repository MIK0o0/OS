package Algorithms;

import com.company.Call;

import java.util.ArrayList;

public class AproxLRU {
    public int[] alruAlgo(ArrayList<Call> list) {
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
                tab.get(i).setLicznik(1);
                return 0;
            }
        }
        boolean isDdone = false;
        if (tab.size() >= size) {
            while (!isDdone) {
                for (int i = 0; i < tab.size(); i++) {
                    if (tab.get(i).getLicznik() == 1) {
                        tab.get(i).setLicznik(0);
                    } else {
                        tab.remove(i);
                        isDdone=true;
                        break;
                    }
                }
            }
        }
        tab.add(c);
        return 1;
    }

}
