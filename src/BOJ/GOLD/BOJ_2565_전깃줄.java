package BOJ.GOLD;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

public class BOJ_2565_전깃줄 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[][] line = new int[n][2]; // 0: A, 1: B

        for (int i = 0; i < n; i++) {
            String[] input = br.readLine().split(" ");
            line[i][0] = Integer.parseInt(input[0]);
            line[i][1] = Integer.parseInt(input[1]);
        }
        //1. a를 기준으로 ASC 정렬
        Arrays.sort(line, Comparator.comparingInt(a -> a[0]));

        int answer = solve(n, line);
        System.out.println(answer);
    }

    static int solve(int n, int[][] line) {
        int[] dp = new int[n];
        int max = 0;

        for (int i = 0; i < n; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                //2. 증가하는 부분 수열
                if (line[i][1] > line[j][1]) {
                    dp[i] = Math.max(dp[j] + 1, dp[i]);
                }
            }
            max = Math.max(dp[i], max);
        }

        //3. 제거해야 하는 라인수
        return n - max;
    }
}
