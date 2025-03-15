package BOJ.BRONZE;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_1037_약수 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        String[] input = br.readLine().split(" ");
        int min = Integer.MAX_VALUE;
        int max = 0;

        for (int i = 0; i < N; i++) {
            int in = Integer.parseInt(input[i]);
            min = Math.min(min, in);
            max = Math.max(max, in);
        }
        System.out.println(max * min);
    }
}
