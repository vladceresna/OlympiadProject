import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int k = s.nextInt();
        ArrayList<Integer> p = new ArrayList<>();
        for (int x=0;x<n;x++){
            p.set(x,s.nextInt());
        }
        //n, k, p
        ArrayList<ArrayList<Integer>> a = new ArrayList<>();


    }
    public static int getTableSize(int n, int k) {//n=5,k=3 - int=20
        return (k+1)*n;
    }

}
