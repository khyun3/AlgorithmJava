package BOJ.SILVER;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1149_RGB거리 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st;
        int[][] dp = new int[n][3];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int r = Integer.parseInt(st.nextToken());
            int g = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            if(i == 0) {
                dp[i][0] = r;
                dp[i][1] = g;
                dp[i][2] = b;
            }
            else {
                dp[i][0] = r + Math.min(dp[i-1][1], dp[i-1][2]);
                dp[i][1] = g + Math.min(dp[i-1][0], dp[i-1][2]);
                dp[i][2] = b + Math.min(dp[i-1][0], dp[i-1][1]);
            }
        }
        System.out.println(Math.min(dp[n-1][0], Math.min(dp[n-1][1], dp[n-1][2])));
    }
}
