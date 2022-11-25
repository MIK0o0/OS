package Comparatory;

import com.company.Task;

import java.util.Comparator;

public class piorytetComparator implements Comparator<Task> {
    @Override
    public int compare(Task p1, Task p2) {

        if (p1.isPiorytet() && p2.isPiorytet()){
            return new arrivalComparator().compare(p1, p2);
        }else if (!p1.isPiorytet() && !p2.isPiorytet()){
            return new arrivalComparator().compare(p1, p2);
        }else if (!p1.isPiorytet() && p2.isPiorytet()){
            return 1;
        }else {
            return -1;
        }
    }
}
