package BOJ.SILVER;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_11050_이항계수1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int K = Integer.parseInt(input[1]);

        System.out.println(nCk(N, K));
    }

    static int nCk(int n, int k) {
        //n! / k!(n-k)!
        return factorial(n) / (factorial(k) * factorial(n - k));
    }


    static int factorial(int n) {
        int answer = 1;
        for (int i = 2; i <= n; i++) {
            answer *= i;
        }
        return answer;
    }

}
