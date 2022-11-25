package com.company;

import java.util.ArrayList;
import java.util.Random;

public class symulation {

    public double[] startegy1(int p,int z,int N){
        int arrivalTime = 100000;
        ArrayList<processor> processors = new ArrayList<>();
        ArrayList<Integer> numbers = new ArrayList<>();
        int [] resoult = new int[N];
        double[] tab = new double[4];

        Random random = new Random();
        for (int i = 1;i<=N;i++){
            processors.add(new processor(i));
            numbers.add(i);
        }
        while (arrivalTime != 0){
            for (processor processor : processors){
                processor.minusTime();
            }
            for (processor processor : processors){
                zadania(processor,processors,numbers,z,p,tab);
                restart(N,numbers);
            }
            arrivalTime--;
        }
        for (int i = 0;i<N;i++){
            resoult[i] = processors.get(i).avgLoad/100000;
        }
        double wynik = 0;
        double odchylenie =0;
        for (int i = 0;i<N;i++){
            wynik+=resoult[i];
        }
        wynik = wynik/N;
        for (int i = 0;i<N;i++){
            odchylenie += Math.abs(resoult[i]-wynik);
        }
        odchylenie /= N;
        tab[0] = wynik;
        tab[1] = odchylenie;
        return tab;
    }

    private void zadania(processor processor,ArrayList<processor> processors,ArrayList<Integer> numbers,int z,int p,double[] tab){

            task tym = processor.newProcess();
            if (tym != null){
                Random random = new Random();
                for (int i =0;i<z;i++){
                    int pom = random.nextInt(0, numbers.size()-1);
                    tab[2] ++;
                    if (processors.get(numbers.get(pom)).getLoad() < p){
                        processors.get(numbers.get(pom)).add(tym);
                        tab[3]++;
                        return;
                    }
                    numbers.remove(pom);
                }
                processor.add(tym);
                return;
            }
    }

    private void restart(int n,ArrayList<Integer> list){
        list.clear();
        for (int i = 1;i<n;i++){
            list.add(i);
        }
    }
    private void zadania2(processor processor,ArrayList<processor> processors,ArrayList<Integer> numbers,int p,double[] tab){

        task tym = processor.newProcess();
        if (tym != null){
            if (processor.getLoad() < p){
                processor.add(tym);
                return;
            }else {
                Random random = new Random();
                while (numbers.size()>1){
                    int pom = random.nextInt(0, numbers.size()-1);
                    tab[2]++;
                    if (processors.get(numbers.get(pom)).getLoad() < p) {
                        processors.get(numbers.get(pom)).add(tym);
                        tab[3]++;
                        return;
                    }
                    numbers.remove(pom);
                }
                processor.add(tym);
                return;
            }
        }
    }
    public double[] startegy2(int p,int N){
        int arrivalTime = 100000;
        ArrayList<processor> processors = new ArrayList<>();
        ArrayList<Integer> numbers = new ArrayList<>();
        int [] resoult = new int[N];
        double[] tab = new double[4];
        Random random = new Random();
        for (int i = 1;i<=N;i++){
            processors.add(new processor(i));
            numbers.add(i);
        }
        while (arrivalTime != 0){
            for (processor processor : processors){
                processor.minusTime();
            }
            for (processor processor : processors){
                zadania2(processor,processors,numbers,p,tab);
                restart(N,numbers);
            }
            arrivalTime--;
        }
        for (int i = 0;i<N;i++){
            resoult[i] = processors.get(i).avgLoad/100000;
        }
        double wynik = 0;
        double odchylenie = 0;
        for (int i = 0;i<N;i++){
            wynik+=resoult[i];
        }
        wynik = wynik/N;
        for (int i = 0;i<N;i++){
            odchylenie += Math.abs(resoult[i]-wynik);
        }
        odchylenie /= N;
        tab[0] = wynik;
        tab[1] = odchylenie;
        return tab;
    }
    private void asking(ArrayList<processor> processors,ArrayList<Integer> numbers,int p,int r,double[] tab){

        while (numbers.size()>1){
            //System.out.println(numbers.size());
            processor tym = null;
            for (int i = 0;i<numbers.size();i++){
                tab[2] ++;
                if (processors.get(numbers.get(i)).getLoad()<p && processors.get(numbers.get(i)).getLoad()>r){
                    numbers.remove(i);
                }else if (processors.get(numbers.get(i)).getLoad()<r){

                    tym = processors.get(numbers.get(i));
                    numbers.remove(i);
                    break;
                }else {
                    numbers.remove(i);
                }
            }
            if (tym!= null) {
                for (int i = 0; i < numbers.size(); i++) {
                    if (processors.get(numbers.get(i)).getLoad() > p) {
                        tym.add(processors.get(numbers.get(i)).remove());
                        tab[3]++;
                        numbers.remove(i);
                    } else if (processors.get(numbers.get(i)).getLoad() > r) {
                        numbers.remove(i);
                    }
                }
            }

        }
    }
    public double[] startegy3(int p,int N,int r){
        int arrivalTime = 100000;
        ArrayList<processor> processors = new ArrayList<>();
        ArrayList<Integer> numbers = new ArrayList<>();
        int [] resoult = new int[N];
        double[] tab = new double[4];

        Random random = new Random();
        for (int i = 1;i<=N;i++){
            processors.add(new processor(i));
            numbers.add(i);
        }
        while (arrivalTime != 0){
            for (processor processor : processors){
                processor.minusTime();
            }

            for (processor processor : processors){
                zadania2(processor,processors,numbers,p,tab);
                restart(N,numbers);
                asking(processors,numbers,p,r,tab);
                restart(N,numbers);
            }
            arrivalTime--;
        }
        for (int i = 0;i<N;i++){
            resoult[i] = processors.get(i).avgLoad/100000;
        }
        double wynik = 0;
        for (int i = 0;i<N;i++){
            wynik+=resoult[i];
        }
        wynik = wynik/N;
        double odchylenie = 0;
        for (int i = 0;i<N;i++){
            odchylenie += Math.abs(resoult[i]-wynik);
        }
        odchylenie /= N;
        tab[0] = wynik;
        tab[1] = odchylenie;
        return tab;
    }
}
