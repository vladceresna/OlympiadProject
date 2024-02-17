import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        ArrayList<Integer> countsOfNumbersList = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            countsOfNumbersList.add(s.nextInt());
        }
        ArrayList<Integer> rez = new ArrayList<>();
        for (int numbers = 0; numbers < countsOfNumbersList.size();numbers++){ //numbers 0,1,2...
            for (int countOfNumber = 0; countOfNumber < countsOfNumbersList.get(numbers);countOfNumber++) {//count 2,4,1...
                rez.add(numbers);
            }
        }

        ArrayList<Integer> rezWithMaxSum = new ArrayList<>(rez);//rez = 0,0,1,1,1,2,3,3...
        ArrayList<Integer> arrWithMaxSum = new ArrayList<>(rez);//rez = 0,0,1,1,1,2,3,3...
        int rezMaxSum = 0;
        int maxSum = 0;
        for (int indexOfElementNumber = 0;indexOfElementNumber<rez.size();indexOfElementNumber++){//iteration on numbers
            for (int indexOfReplacedNumber = 0;indexOfReplacedNumber<rez.size();indexOfReplacedNumber++) {//iteration on array
                int replacedNumber = arrWithMaxSum.get(indexOfReplacedNumber);
                arrWithMaxSum.set(indexOfReplacedNumber,arrWithMaxSum.get(indexOfElementNumber));
                arrWithMaxSum.set(indexOfElementNumber, replacedNumber);
                for (int i = 1;i<rez.size();i++) {
                    maxSum += concat(arrWithMaxSum.get(i - 1), arrWithMaxSum.get(i));
                }
            }
            if (maxSum>rezMaxSum){
                rezMaxSum = maxSum;
                maxSum = 0;
                rezWithMaxSum = arrWithMaxSum;
                arrWithMaxSum = new ArrayList<>(rez);
            }
        }
        for (int indexOfElementNumber = 0;indexOfElementNumber<rez.size();indexOfElementNumber++){//iteration on numbers

            for (int indexOfReplacedNumber = 0;indexOfReplacedNumber<rezWithMaxSum.size();indexOfReplacedNumber++) {//iteration on array
                int replacedNumber = arrWithMaxSum.get(indexOfReplacedNumber);
                arrWithMaxSum.set(indexOfReplacedNumber,arrWithMaxSum.get(indexOfElementNumber));
                arrWithMaxSum.set(indexOfElementNumber, replacedNumber);
                for (int i = 1;i<rezWithMaxSum.size();i++) {
                    maxSum += concat(arrWithMaxSum.get(i - 1), arrWithMaxSum.get(i));
                }
            }
            if (maxSum>rezMaxSum){
                rezMaxSum = maxSum;
                maxSum = 0;
                rezWithMaxSum = arrWithMaxSum;
                arrWithMaxSum = new ArrayList<>(rez);
            }
        }
        for (int i = rezWithMaxSum.size()-1; i>=0;i--){
            System.out.print(rezWithMaxSum.get(i)+" ");
        }
    }
    public static int concat(int a, int b) {
        return 10*a+b;
    }

}


/*
        11 10 13 00 03 33 =70
        1 0 3

        0 0 0 0 0 2 0 0 0 0
        5 5

        1 0 1 1 0 0 0 0 0 0
        3 2 0
 */