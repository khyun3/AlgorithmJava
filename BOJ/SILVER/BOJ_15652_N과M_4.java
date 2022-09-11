package SILVER;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_15652_N과M_4 {
    static int [] arr;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        arr = new int [m];

        solve(n, m, 0,0);
        System.out.print(sb);
    }
    static void solve(int n, int r, int s, int c) {
        if(c == r) {
            for (int x: arr) {
                sb.append(x).append(" ");
            }
            sb.append("\n");
            return;
        }

        for (int i = s; i < n; i++) {
            arr[c] = i+1;
            solve(n, r, i, c+1);
        }
    }
}
