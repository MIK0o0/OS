package com.company;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Zapis {
    public void zapis(String s1,String s2,String s3, String s4) throws IOException {
        FileWriter fileWriter = new FileWriter("tasks.txt",true);
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
        PrintWriter printWriter = new PrintWriter(bufferedWriter);
        String tym = s1 + "\n" + s2 + "\n" + s3 + "\n" + s4 + "\n";
        printWriter.println(tym);
        bufferedWriter.close();
    }
    public void zapis(String s1) throws IOException {
        FileWriter fileWriter = new FileWriter("tasks.txt",true);
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
        PrintWriter printWriter = new PrintWriter(bufferedWriter);
        String tym = s1 + "\n";
        printWriter.println(tym);
        bufferedWriter.close();
    }
    public void zapis2(String s1) throws IOException {
        FileWriter fileWriter = new FileWriter("tasks2.txt",true);
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
        PrintWriter printWriter = new PrintWriter(bufferedWriter);
        String tym = s1 + "\n";
        printWriter.println(tym);
        bufferedWriter.close();
    }
}
