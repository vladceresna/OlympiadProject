package com.example.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String[][] tictactoeA = new String[3][3];
        String[][] tictactoeB = new String[3][3];
        for (int l = 0;l<3;l++){
            tictactoeA[l] = s.nextLine().split("");
        }
        for (int l = 0;l<3;l++){
            tictactoeB[l] = s.nextLine().split("");
        }
        int countOfChangesX = 0;
        int countOfChanges0 = 0;
        int countOfX = 0;
        int countOf0 = 0;
        int countOfXDo = 0;
        int countOf0Do = 0;
        for (int i = 0;i<tictactoeA.length;i++){
            for (int j = 0;j<tictactoeA[i].length;j++) {
                String a = tictactoeA[i][j];
                String b = tictactoeB[i][j];
                if (a.equals("X")) countOfXDo++;
                else if (a.equals("0")) countOf0Do++;
                if (b.equals("X")) countOfX++;
                else if (b.equals("0")) countOf0++;
                if (!a.equals(b)) {
                    switch (b){
                        case "X":
                            countOfChangesX++;
                            break;
                        case "0":
                            countOfChanges0++;
                            break;
                    }
                }
            }
        }
        if (countOfChanges0==0 && countOfChangesX==0){
            System.out.println("YES");
        }else if(countOfXDo>countOf0Do){
            if (countOfChangesX>0) System.out.println("NO");
            else if (countOfChanges0>0) System.out.println("YES");
        } else if (countOfXDo==countOf0Do){
            if (countOfChanges0>0) System.out.println("NO");
            else if (countOfChangesX>0) System.out.println("YES");
        } else if (countOfChanges0>1 || countOfChangesX>1){
            System.out.println("NO");
        }else {
            System.out.println("YES");
        }
    }
}
