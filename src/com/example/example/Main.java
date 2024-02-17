package com.example.example;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static int x1;
    public static int y1;
    public static int x2;
    public static int y2;
    public static ArrayList<Node> checkedNodes = new ArrayList<>();
    public static ArrayList<Vector> checkedVectors = new ArrayList<>();
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int m = s.nextInt();
        ArrayList<ArrayList<String>> nm = new ArrayList<>();
        for (int x=0;x<n;x++){
            nm.add(new ArrayList<>(Arrays.asList(s.nextLine().split(""))));
        }
        ArrayList<Node> nodes = new ArrayList<>();
        for (int nn=0;nn< nm.size();nn++){
            ArrayList<String> arrayList = nm.get(nn);
            for (int mm=0;mm<arrayList.size();mm++){//nn mm    nn-1, mm   nn, mm-1   nn+1, mm   nn, mm+1
                if (arrayList.get(mm).equals("F")) {
                    nodes.add(new Node(nn, mm, nm.get(nn).get(mm).equals("H"), getVectorsFromNode(nn,mm,nm)));
                }
            }
        }
        ArrayList<Node> gaps = new ArrayList<>();
        for (Node node:nodes){
            if (node.isGap()){
                gaps.add(node);
            }
        }
        ArrayList<Integer> lightestx = new ArrayList<>();
        ArrayList<Integer> lightesty = new ArrayList<>();
        int lightestlen = n*m;
        for (Node node:nodes){
            int lightlen = howLightPath(node, n*m);
            if (lightestlen>lightlen){
                lightestx.clear();
                lightesty.clear();
                lightestx.add(node.x);
                lightesty.add(node.y);
            }
            if (lightestlen==lightlen){
                lightestx.add(node.x);
                lightesty.add(node.y);
            }
        }
        System.out.println(lightestx.size());
        for (int i = 0;i<lightestx.size();i++){
            System.out.println(lightestx.get(i)+" "+lightesty.get(i));
        }
    }
    public static int howLightPath(Node node, int nonm){//weights sum
        boolean finded = false;
        for (Node node1: checkedNodes){
            if ((node1.x == node.x) && (node1.y == node.y)) finded = true;
        }
        if (!finded) for (Vector vector : node.getVectors()) {
            Node childNode = vector.getNodeTo();
            if (childNode.isGap()){
                return 1;
            }
            return 1+howLightPath(childNode, nonm);
        }
        return nonm;
    }
    public static ArrayList<Vector> getVectorsFromNode(int nn, int mm, ArrayList<ArrayList<String>> nm){
        Node nodeFrom = new Node(nn,mm, nm.get(nn).get(mm).equals("H"), null);
        ArrayList<Vector> vectors = new ArrayList<>();
        try {
            int x = nn - 1;
            int y = mm;

            boolean finded = false;
            for (Vector vector1: checkedVectors){
                if ((vector1.nodeFrom.x == nn) && (vector1.nodeFrom.y == mm)
                &&  (vector1.nodeTo.x == x) && (vector1.nodeTo.y == y)) finded = true;
            }
            if (!finded) {
                checkedVectors.add(new Vector(1, new Node(x, y, nm.get(x).get(y).equals("H"),null),nodeFrom));
                Vector vector = new Vector(1, new Node(x, y, nm.get(x).get(y).equals("H"), getVectorsFromNode(x, y, nm)),
                        nodeFrom);
                if (!nm.get(x).get(y).equals("F")) vectors.add(vector);
            }
        } catch (Exception e) {
        }
        try {
            int x = nn;
            int y = mm - 1;

            boolean finded = false;
            for (Vector vector1: checkedVectors){
                if ((vector1.nodeFrom.x == nn) && (vector1.nodeFrom.y == mm)
                        &&  (vector1.nodeTo.x == x) && (vector1.nodeTo.y == y)) finded = true;
            }
            if (!finded) {
                checkedVectors.add(new Vector(1, new Node(x, y, nm.get(x).get(y).equals("H"),null),nodeFrom));
                Vector vector = new Vector(1, new Node(x, y, nm.get(x).get(y).equals("H"), getVectorsFromNode(x, y, nm)),
                        nodeFrom);
                if (!nm.get(x).get(y).equals("F")) vectors.add(vector);
            }
        } catch (Exception e) {
        }
        try {
            int x = nn + 1;
            int y = mm;

            boolean finded = false;
            for (Vector vector1: checkedVectors){
                if ((vector1.nodeFrom.x == nn) && (vector1.nodeFrom.y == mm)
                        &&  (vector1.nodeTo.x == x) && (vector1.nodeTo.y == y)) finded = true;
            }
            if (!finded) {
                checkedVectors.add(new Vector(1, new Node(x, y, nm.get(x).get(y).equals("H"),null),nodeFrom));
                Vector vector = new Vector(1, new Node(x, y, nm.get(x).get(y).equals("H"), getVectorsFromNode(x, y, nm)),
                        nodeFrom);
                if (!nm.get(x).get(y).equals("F")) vectors.add(vector);
            }
        } catch (Exception e) {
        }
        try {
            int x = nn;
            int y = mm + 1;

            boolean finded = false;
            for (Vector vector1: checkedVectors){
                if ((vector1.nodeFrom.x == nn) && (vector1.nodeFrom.y == mm)
                        &&  (vector1.nodeTo.x == x) && (vector1.nodeTo.y == y)) finded = true;
            }
            if (!finded) {
                checkedVectors.add(new Vector(1, new Node(x, y, nm.get(x).get(y).equals("H"),null),nodeFrom));
                Vector vector = new Vector(1, new Node(x, y, nm.get(x).get(y).equals("H"), getVectorsFromNode(x, y, nm)),
                        nodeFrom);
                if (!nm.get(x).get(y).equals("F")) vectors.add(vector);
            }
        } catch (Exception e) {
        }
        return vectors;
    }
}
class Node{
    int x;
    int y;
    boolean gap;
    ArrayList<Vector> vectors;

    public Node(int x, int y, boolean gap, ArrayList<Vector> vectors) {
        this.x = x;
        this.y = y;
        this.gap = gap;
        this.vectors = vectors;
    }

    public boolean isGap() {
        return gap;
    }

    public void setGap(boolean gap) {
        this.gap = gap;
    }
    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public ArrayList<Vector> getVectors() {
        return vectors;
    }

    public void setVectors(ArrayList<Vector> vectors) {
        this.vectors = vectors;
    }
}
class Vector{
    int weight;
    Node nodeTo;
    Node nodeFrom;

    public Vector(int weight, Node nodeTo,Node nodeFrom) {
        this.weight = weight;
        this.nodeTo = nodeTo;
        this.nodeFrom = nodeFrom;
    }

    public Node getNodeTo() {
        return nodeTo;
    }

    public void setNodeTo(Node nodeTo) {
        this.nodeTo = nodeTo;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }
}
