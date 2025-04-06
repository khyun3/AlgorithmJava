package BOJ.SILVER;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1912_연속합_RE {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int sum = 0;
        int max = -Integer.MAX_VALUE;
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        for (int i = 0; i < N; i++) {
            sum += Integer.parseInt(st.nextToken());
            if (sum < 0) {
                max = Math.max(max, sum);
                sum = 0;
            } else {
                max = Math.max(max, sum);
            }
        }
        System.out.println(max);
    }
}
