package com.example.example.replychallenge;

import java.util.*;

public class Task4Maze {
    public static List<TestCase> testCases;
    public static void main(String[] args) {
        scanData();
        List<List<Variant>> cases = new ArrayList<>();
        for (TestCase testCase : testCases) {
            List<Variant> variants = new ArrayList<>();

            Ceil startCeil = testCase.ceils.get(0).findBy(0,0);
            for(Ceil ceil:startCeil.getCeilsToMove()) {
                variants.add(to(ceil,0));
            }

            cases.add(variants);
        }
        for (int caseI = 0; caseI < cases.size(); caseI++) {
            List<Variant> variants = cases.get(caseI);
            int minMovesCount = Integer.MAX_VALUE;
            Variant minVariant = null;
            for (Variant variant : variants) {
                if (variant.movesCount < minMovesCount) {
                    minMovesCount = variant.movesCount;
                    minVariant = variant;
                }
            }
            System.out.println("Case #"+caseI+":"+" "+minVariant.winner +" "+minMovesCount);
        }
    }
    public static Variant to(Ceil ceil, int movesCount){
        int winner = 0;
        if (ceil.getCeilsToMove().size() == 0){
            if(movesCount%2==0) winner = 2;
            else winner = 1;
            return new Variant(winner,movesCount);
        } else {
            for(Ceil nextCeil:ceil.getCeilsToMove()) {
            ceil = nextCeil;
            ceil.isEmpty = false;

        }
        return null;
    }
    public static void scanData() {
        Scanner s = new Scanner(System.in);
        int T = s.nextInt();
        //T test cases
        testCases = new ArrayList<>();
        for (int testI = 0; testI < T; testI++) {
            //Its one test case operation
            TestCase testCase = new TestCase(s.nextInt(),s.nextInt(),null,null);
            for (int i = 0; i < testCase.N; i++) {
                for (int j = 0; j < testCase.N; j++) {
                    testCase.ceils.add(new Ceil(j,i,(s.nextInt() == 0),testCase));
                }
            }
            for (int j = 0; j < testCase.M; j++) {
                testCase.availableSteps.add(new Step(s.nextInt(),s.nextInt()));
            }
            testCases.add(testCase);
        }
    }
}
class Ceil{
    int x;
    int y;
    boolean isEmpty;
    TestCase testCase;

    public Ceil(int x, int y, boolean isEmpty, TestCase testCase) {
        this.x = x;
        this.y = y;
        this.isEmpty = isEmpty;
        this.testCase = testCase;
    }
    Ceil top(){
        return findBy(x,y-1);
    }
    Ceil right(){
        return findBy(x+1,y);
    }
    Ceil bottom(){
        return findBy(x,y+1);
    }
    Ceil left(){
        return findBy(x-1,y);
    }
    Ceil findBy(int x, int y){
        for(Ceil ceil:testCase.ceils) if(ceil.x == x && ceil.y == y) return ceil;
        return null;
    }

    List<Ceil> getCeilsToMove(){
        List<Ceil> ceils = new ArrayList<>();
        for (Step availableStep:testCase.availableSteps){
            for (Ceil ceil:testCase.ceils){
                if(ceil.x == x+availableStep.x && ceil.y == y+availableStep.y && ceil.isEmpty){
                    ceils.add(ceil);
                }
            }
        }
        return ceils;
    }

}
class TestCase{
    int N;
    int M;
    List<Ceil> ceils;//N*N size
    List<Step> availableSteps;//M length

    public TestCase(int n, int m, List<Ceil> ceils, List<Step> availableSteps) {
        N = n;
        M = m;
        this.ceils = ceils;
        this.availableSteps = availableSteps;
    }
}
class Step{
    int x;//right or left if negative
    int y;//down or up if negative

    public Step(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
class Variant{
    int winner;
    int movesCount;

    public Variant(int winner, int movesCount) {
        this.winner = winner;
        this.movesCount = movesCount;
    }
}