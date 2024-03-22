package com.example.example.uoi;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int k = s.nextInt();
        ArrayList<Integer> r = new ArrayList<>();
        ArrayList<Integer> t = new ArrayList<>();

        for (int i = 0;i<n;i++){
            r.add(s.nextInt());
        }
        for (int i = 0;i<n;i++){
            t.add(s.nextInt());
        }
        boolean changes;
        do{
            changes=false;
            for (int i=0;i<r.size();i++){
                for (int j=0;j<r.size();j++){
                    int riv = r.get(i);
                    int rjv = r.get(j);
                    int tiv = t.get(i);
                    int tjv = t.get(j);
                    if (i<j){
                        if (riv<rjv){
                            r.set(i,rjv);
                            r.set(j,riv);
                            t.set(i,tjv);
                            t.set(j,tiv);
                        }
                        if (tiv>tjv){
                            r.set(i,rjv);
                            r.set(j,riv);
                            t.set(i,tjv);
                            t.set(j,tiv);
                        }
                    }
                }
            }

        }while(changes);
        int sumR = 0;
        int sumT = 0;
        for (int i = 0;i<k;i++){
            sumR+=r.get(i);
            sumT+=t.get(i);
            System.out.println(r.get(i)+" "+t.get(i));
        }
        System.out.println((sumR*1.0)/sumT);
    }
}