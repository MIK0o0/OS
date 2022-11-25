package Comparatory;

import Comparatory.scanComparator;
import com.company.Task;

import java.util.Comparator;

public class fdcsanComparator implements Comparator<Task> {
    private int headSegemnt;

    public fdcsanComparator(int headSegemnt){
        this.headSegemnt = headSegemnt;
    }
    @Override
    public int compare(Task p1, Task p2) {

        if (p1.isPiorytet() && p2.isPiorytet()){
            return new scanComparator(headSegemnt).compare(p1, p2);
        }else if (!p1.isPiorytet() && !p2.isPiorytet()){
            return new scanComparator(headSegemnt).compare(p1, p2);
        }else if (!p1.isPiorytet() && p2.isPiorytet()){
            return 1;
        }else {
            return -1;
        }
    }
}
