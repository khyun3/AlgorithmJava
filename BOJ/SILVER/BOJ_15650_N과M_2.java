package SILVER;

import java.util.LinkedList;
import java.util.Scanner;

public class BOJ_15650_N과M_2 {
    static StringBuilder sb = new StringBuilder();
    static int [] arr;
    static boolean [] check;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        arr = new int [m];
        check = new boolean[n];

        nCr(n, m, 0, 0);
        System.out.println(sb);
    }
    static void nCr(int n, int r, int start, int cnt) {
        if(cnt == r) {
            for (int x : arr) {
                sb.append(x).append(" ");
            }
            sb.append("\n");
            return;
        }

        for (int i = start; i < n; i++){
            if(check[i]) continue;
            check[i] = true;
            arr[cnt] = i+1;
            nCr(n, r, i, cnt+1);
            check[i] = false;
        }
    }
}
