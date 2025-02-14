package BOJ.SILVER;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1932_정수삼각형 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());

        int[][] trg = new int[N][];
        int[][] dp = new int[N][];
        int answer;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int len = st.countTokens();
            trg[i] = new int[len];
            dp[i] = new int[len];
            for (int j = 0; j < len; j++) {
                trg[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dp[0][0] = trg[0][0];
        answer = trg[0][0];

        for (int i = 1; i < N; i++) {
            for (int j = 0; j <= i; j++) {
                if(j == 0) {
                    dp[i][j] =  trg[i][j] + dp[i-1][j];
                }
                else if(j == i) {
                    dp[i][j] =  trg[i][j] + dp[i-1][j-1];
                }
                else {
                    dp[i][j] = Math.max(trg[i][j] + dp[i-1][j-1], trg[i][j] + dp[i-1][j]);
                }
                answer = Math.max(dp[i][j], answer);
            }
        }
        System.out.println(answer);
    }
}
