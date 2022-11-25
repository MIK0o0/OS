package Algorithms;

import com.company.Call;

import java.util.ArrayList;

public class OPT {
    public int[] optAlgo(ArrayList<Call> list) {
        int[] result = new int[4];
        ArrayList<Call> ramka3 = new ArrayList<>();
        ArrayList<Call> ramka7 = new ArrayList<>();
        ArrayList<Call> ramka10 = new ArrayList<>();
        ArrayList<Call> ramka100 = new ArrayList<>();
        for (int k = 0; k < list.size(); k++) {
            result[0] += check(ramka3, 3, list, k);
            result[1] += check(ramka7, 7, list, k);
            result[2] += check(ramka10, 10, list, k);
            result[3] += check(ramka100, 100, list, k);
        }
        return result;
    }

    public int check(ArrayList<Call> tab, int size, ArrayList<Call> list, int index) {
        for (int i = 0; i < tab.size(); i++) {
            if (tab.get(i).equals(list.get(index))) {
                return 0;
            }
        }
        if (tab.size() < size) {
            tab.add(list.get(index));
            return 1;
        }
        int farthesIndex = 0;
        int distance = 0;
        for (int i = 0; i < tab.size(); i++) {
            for (int k = index; k < list.size(); k++) {
                if (tab.get(i).equals(list.get(k))) {
                    int tym = k - index;
                    if (tym > distance) {
                        farthesIndex = i;
                        distance = tym;
                    }
                    break;
                }
            }
        }
        tab.remove(farthesIndex);
        tab.add(list.get(index));
        return 1;
    }
}
