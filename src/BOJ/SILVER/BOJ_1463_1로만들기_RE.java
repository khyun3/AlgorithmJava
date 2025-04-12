package BOJ.SILVER;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ_1463_1로만들기_RE {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] dp = new int[N + 1];

        for (int i = 2; i <= N; i++) {
            //3가지 연산 배열
            int[] ops = new int[3];
            Arrays.fill(ops, Integer.MAX_VALUE);

            //3으로 나눠떨어질 때
            if (i % 3 == 0) ops[0] = dp[i / 3] + 1;
            //2로 나눠 떨어질 떄
            if (i % 2 == 0) ops[1] = dp[i / 2] + 1;
            //1을 뺐을 때
            ops[2] = dp[i - 1] + 1;

            //최소값 계산
            dp[i] = Math.min(ops[0], Math.min(ops[1], ops[2]));
        }
        System.out.print(dp[N]);
    }
}
