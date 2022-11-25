package com.company;

import Comparatory.arrivalComparator;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class tasksGenerator {

    public void writeTasks(ArrayList<Task> list){
        try(ObjectOutputStream writer = new ObjectOutputStream(new FileOutputStream("tasks.ser"))){
            writer.writeObject(list);
        }catch (IOException e){
            e.printStackTrace();
        }
    }
    public void generator(int n,int activeTime,int max){
        ArrayList<Task> tsaksList = new ArrayList<>();
        Random random = new Random();
        int i = 0;
        for(;i<n*0.70;i++){
            tsaksList.add(new Task(i,random.nextInt(1,max) ,random.nextInt(1,activeTime),false,0));
        }
        for(;i<n;i++){
            int tym = random.nextInt(1,activeTime);
            tsaksList.add(new Task(i,random.nextInt(1,max) ,tym, true, random.nextInt(tym,tym+100)));
        }

        Collections.sort(tsaksList,new arrivalComparator());
        writeTasks(tsaksList);
    }
    public ArrayList<Task> reader(){
        try(ObjectInputStream reader = new ObjectInputStream(new FileInputStream("tasks.ser"))){
            Object ob = reader.readObject();
            reader.close();
            return (ArrayList) ob;
        }catch (IOException e){
            e.printStackTrace();
            return null;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }

}
