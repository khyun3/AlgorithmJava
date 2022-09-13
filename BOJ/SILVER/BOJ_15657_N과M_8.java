package SILVER;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_15657_N과M_8 {
    static int [] arr, pick;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        arr = new int [n];
        pick = new int [m];
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        solve(n, m, 0,0);
        System.out.print(sb);
    }
    static void solve(int n, int m, int s, int c) {
        if(m == c){
            for (int x: pick) {
                sb.append(x).append(" ");
            }
            sb.append("\n");
            return;
        }
        for (int i = s; i < n; i++) {
            pick[c] = arr[i];
            solve(n, m, i, c+1);
        }
    }
}