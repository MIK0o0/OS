package Algorytmy;

import Comparatory.piorytetComparator;
import com.company.Task;

import java.util.ArrayList;
import java.util.Collections;

public class EDF {
    public int edfAlgo(ArrayList<Task> list){
        ArrayList<Task> tasks = list;
        ArrayList<Task> queue = new ArrayList<>();
        ArrayList<Task> doneTasks = new ArrayList<>();
        int index = 0;
        int time = 0;
        int result = 0;
        int headSegment = 0;
        int afterDeadLine = 0;
        while (doneTasks.size() != list.size()){
            if (queue.isEmpty() && index < tasks.size()){
                queue.add(tasks.get(index));
                index++;
                if (time < queue.get(0).getArrivalTime()) {
                    time = queue.get(0).getArrivalTime();
                }
            }
            if (index < tasks.size()) {
                while (tasks.get(index).getArrivalTime() <= time ) {
                    queue.add(tasks.get(index));
                    index++;
                    if (index >= tasks.size()){
                        break;
                    }
                }
            }
            Collections.sort(queue,new piorytetComparator());
            if (queue.get(0).getArrivalTime() <= time) {
                if (queue.get(0).getDeadLine() < time && queue.get(0).getDeadLine()!=0){
                    afterDeadLine +=1;
                }
                int tym = Math.abs(headSegment - queue.get(0).getSegment());
                result += tym;
                time += tym;
                headSegment = queue.get(0).getSegment();
                doneTasks.add(queue.get(0));
                queue.remove(0);
            }else {
                result++;
                time++;
            }


        }
        System.out.print("After deadLine : "+afterDeadLine+"\t");        return result;
    }
}
