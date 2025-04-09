package BOJ.SILVER;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_2156_포도주_시식 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //step 1. N을 입력받는다.
        int N = Integer.parseInt(br.readLine());
        int[] amountOfWine = new int[N];
        //step 2. 와인 배열을 입력받는다.
        for (int i = 0; i < N; i++) {
            amountOfWine[i] = Integer.parseInt(br.readLine());
        }

        //step 3. 와인을 마신 최대값 dp배열을 만든다.
        int[] dp = calculateMaxWine(amountOfWine, N);

        //step 4. 마지막 dp배열 값을 출력한다.
        System.out.println(dp[N - 1]);
    }

    static int[] calculateMaxWine(int[] amountOfWine, int N) {
        int[] dp = new int[N];

        dp[0] = amountOfWine[0];
        if (N > 1) {
            dp[1] = dp[0] + amountOfWine[1];
        }
        if (N > 2) {
            dp[2] = Math.max(amountOfWine[0] + amountOfWine[1],
                    Math.max(amountOfWine[0] + amountOfWine[2],
                            amountOfWine[1] + amountOfWine[2])
            );
        }

        for (int i = 3; i < N; i++) {
            //안마시고 건너뛸 때
            int a = dp[i - 1];
            //i-1과 i를 마실 때(연속 2개)
            int b = dp[i - 3] + amountOfWine[i - 1] + amountOfWine[i];
            //i만 마실 때(i-1건너 뛸 때)
            int c = dp[i - 2] + amountOfWine[i];
            dp[i] = Math.max(a, Math.max(b, c));
        }
        return dp;
    }
}
