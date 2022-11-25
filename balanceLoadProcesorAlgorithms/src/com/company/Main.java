package com.company;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
	symulation symulation = new symulation();
    Zapis zapis = new Zapis();
    int p = 50;
    int z = 25;
    int r = 10;
    int N = 50;
    String main = "\nDla p = "+p+", dla z = "+z+", dla r = "+r+", dla N = "+N+" : ";
    double[] sym1 = symulation.startegy1(p,z,N);
    double[] sym2 = symulation.startegy2(p,N);
    double[] sym3 = symulation.startegy3(p,N,r);
    String symu1 = "Symulacja 1, średnie obciążenie : "+ sym1[0] + ", średnie odchylenie : "+Math.round(sym1[1]*1000)/1000d+", liczba porównań : "+sym1[2]+", liczba przemieszczeń : "+sym1[3];
    String symu2 = "Symulacja 2, średnie obciążenie : "+ sym2[0] + ", średnie odchylenie : "+Math.round(sym2[1]*1000)/1000d+", liczba porównań : "+sym2[2]+", liczba przemieszczeń : "+sym2[3];
    String symu3 = "Symulacja 3, średnie obciążenie : "+ sym3[0] + ", średnie odchylenie : "+Math.round(sym3[1]*1000)/1000d+", liczba porównań : "+sym3[2]+", liczba przemieszczeń : "+sym3[3];
    zapis.zapis(main,symu1,symu2,symu3);
        System.out.println(main);
        System.out.println(symu1);
        System.out.println(symu2);
        System.out.println(symu3);
    }
}
