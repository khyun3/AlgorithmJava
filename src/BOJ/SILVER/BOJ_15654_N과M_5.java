package BOJ.SILVER;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_15654_N과M_5 {
    static StringBuilder sb = new StringBuilder();
    static int[] arr, pick;
    static boolean[] check;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        arr = new int[N];
        pick = new int[M];
        check = new boolean[N];

        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);

        solve(N, M, 0);
        System.out.print(sb);
    }

    private static void solve(int n, int m, int c) {
        if (c == m) {
            for (int x : pick) {
                sb.append(x).append(" ");
            }
            sb.append("\n");
            return;
        }

        for (int i = 0; i < n; i++) {
            if (check[i]) continue;
            check[i] = true;
            pick[c] = arr[i];
            solve(n, m, c + 1);
            check[i] = false;
        }
    }
}
