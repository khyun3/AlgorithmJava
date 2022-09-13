package SILVER;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

//TODO : 백트레킹 조건
public class BOJ_15663_N과M_9 {
    static int [] arr, pick;
    static boolean [] check;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        arr = new int [n];
        pick = new int [m];
        check = new boolean[n];
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        solve(n, m, 0);

        System.out.print(sb);
    }
    static void solve(int n, int m, int c) {
        if(m == c) {
            for (int x : pick) {
                sb.append(x).append(" ");
            }
            sb.append("\n");
            return;
        }
        int eqCheck = 0;
        for (int i = 0; i < n; i++) {
            if(check[i] || eqCheck == arr[i]) continue;
            check[i] = true;
            pick[c] = arr[i];
            eqCheck = arr[i];
            solve(n,m, c+1);
            check[i] = false;
        }
    }
}