package BOJ.BRONZE;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1225_이상한_곱셈 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long answer = 0L;

        String input = br.readLine();
        StringTokenizer tokenizer = new StringTokenizer(input, " ");
        int [][] arr = new int [2][10];

        for (char c : tokenizer.nextToken().toCharArray()) {
            int tmp = c - '0';
            arr[0][tmp] += tmp;
        }

        for (char c : tokenizer.nextToken().toCharArray()) {
            int tmp = c - '0';
            arr[1][tmp] += tmp;
        }

        for (int i = 1; i < 10; i++) {
            for (int j = 1; j < 10; j++) {
                answer += (long) arr[0][i] * arr[1][j];
            }
        }

        System.out.println(answer);
    }
}
