package BOJ.SILVER;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_10844_쉬운_계단_수 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        long[][] dp = new long[n + 1][10]; //[1~N자리][0~9]

        //step 1. 초기 값 설정
        for (int i = 1; i < 10; i++) {
            dp[1][i] = 1;
        }

        //step 2. dp 배열 채우기
        for (int i = 2; i <= n; i++) {
            for (int j = 0; j < 10; j++) {
                if (j == 0) {
                    dp[i][j] = dp[i - 1][j + 1];
                } else if (j == 9) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = (dp[i - 1][j - 1] + dp[i - 1][j+1]) % 1000000000;
                }
            }
        }
        //step 3. 정답 출력
        long answer = 0;
        for (int i = 0; i < 10; i++) {
            answer += dp[n][i];
        }
        System.out.println(answer % 1000000000);
    }
}
