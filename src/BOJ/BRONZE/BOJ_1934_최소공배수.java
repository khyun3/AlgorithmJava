package BOJ.BRONZE;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_1934_최소공배수 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        //1
        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            //2
            String[] input = br.readLine().split(" ");
            int a = Integer.parseInt(input[0]);
            int b = Integer.parseInt(input[1]);
            sb.append(findLCM(a, b)).append("\n");
        }
        System.out.println(sb);
    }

    static int findLCM(int a, int b) {
        return a * b / findGCD(a, b);
    }

    static int findGCD(int a, int b) {
        while (b != 0) {
            int tmp = b;
            b = a % b;
            a = tmp;
        }
        return a;
    }
}
