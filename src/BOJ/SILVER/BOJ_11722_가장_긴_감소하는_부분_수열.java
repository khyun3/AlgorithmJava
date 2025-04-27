package BOJ.SILVER;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_11722_가장_긴_감소하는_부분_수열 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] numbers = new int[n];
        int[] dp = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < n; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
            dp[i] = 1;
        }

        int answer = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                //감소하는 가장 긴 부분 수열
                if (numbers[i] < numbers[j]) {
                    dp[i] = Math.max(dp[j] + 1, dp[i]);
                }
            }
            answer = Math.max(dp[i], answer);
        }
        System.out.println(answer);
    }
}
