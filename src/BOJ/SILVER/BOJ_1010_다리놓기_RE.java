package BOJ.SILVER;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_1010_다리놓기_RE {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            String[] input = br.readLine().split(" ");
            int N = Integer.parseInt(input[0]);
            int M = Integer.parseInt(input[1]);

            int[][] pascalTriangle = initPascalTriangle(M);

            sb.append(pascalTriangle[M][N]).append("\n");
        }
        System.out.println(sb);
    }

    static int[][] initPascalTriangle(int n) {
        int[][] pascalTriangle = new int[n + 1][n + 1];

        for (int i = 0; i <= n; i++) {
            pascalTriangle[i][0] = 1;
            pascalTriangle[i][i] = 1;

            for (int j = 1; j < i; j++) {
                pascalTriangle[i][j] = pascalTriangle[i-1][j-1] + pascalTriangle[i-1][j];
            }
        }
        return pascalTriangle;
    }
}
