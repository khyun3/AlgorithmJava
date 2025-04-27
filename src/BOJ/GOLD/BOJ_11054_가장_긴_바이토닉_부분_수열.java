package BOJ.GOLD;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_11054_가장_긴_바이토닉_부분_수열 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[][] numbers = new int[n][2]; //정방향, 역방향
        int[][] dp = new int[n][2];

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < n; i++) {
            int input = Integer.parseInt(st.nextToken());
            numbers[i][0] = numbers[n - i - 1][1] = input;
            dp[i][0] = dp[i][1] = 1;
        }

        int answer = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                //증가하는 가장 긴 부분 수열
                if (numbers[i][0] > numbers[j][0]) {
                    dp[i][0] = Math.max(dp[j][0] + 1, dp[i][0]);
                }
                //감소하는 가장 긴 부분 수열
                if (numbers[i][1] > numbers[j][1]) {
                    dp[i][1] = Math.max(dp[j][1] + 1, dp[i][1]);
                }
            }
        }

        for (int i = 0; i < n; i++) {
            //정방향 + 역방향 - 중복
            answer = Math.max(dp[i][0] + dp[n - i - 1][1] - 1, answer);
        }
        System.out.println(answer);
    }
}
