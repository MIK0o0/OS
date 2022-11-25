package Comparatory;

import com.company.Task;

import java.util.Comparator;

public class arrivalComparator implements Comparator<Task> {
    @Override
    public int compare(Task p1, Task p2) {
        int tym = p1.getArrivalTime() - p2.getArrivalTime();
        if (tym == 0){
            return 0;
        }else if (tym > 0){
            return 1;
        }else {
            return -1;
        }
    }
}
