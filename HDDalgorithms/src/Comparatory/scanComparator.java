package Comparatory;

import com.company.Task;

import java.util.Comparator;

public class scanComparator implements Comparator<Task> {
private int headSegemnt;
public scanComparator(int headSegemnt){
        this.headSegemnt = headSegemnt;
        }
@Override
public int compare(Task p1, Task p2) {
        int tym = (p1.getSegment() - headSegemnt) - (p2.getSegment()- headSegemnt);
        if (tym == 0){
        return new arrivalComparator().compare(p1,p2);
        }else if (tym > 0){
        return 1;
        }else {
        return -1;
        }
        }
        }
