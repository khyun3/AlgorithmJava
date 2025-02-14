package BOJ.SILVER;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ_2579_계단_오르기 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] n = new int[N + 1];
        int[] dp = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            n[i] = Integer.parseInt(br.readLine());
        }
        dp[1] = n[1];
        if(N >= 2) {
            dp[2] = n[1] + n[2];

            for (int i = 3; i <= N; i++) {
                dp[i] = Math.max(dp[i - 2], dp[i - 3] + n[i - 1]) + n[i];
            }
        }
        System.out.print(dp[N]);
    }
}