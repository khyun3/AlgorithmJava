package BOJ.SILVER;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ_1629_곱셈 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");
        int a = Integer.parseInt(input[0]);
        int b = Integer.parseInt(input[1]);
        int c = Integer.parseInt(input[2]);

        System.out.println(pow(a, b, c));
    }

    static long pow(long base, long exp, long mod) {
        if (exp == 0) return 1;
        long half = pow(base, exp / 2, mod);
        long result = (half * half) % mod; //짝수일 경우
        if (exp % 2 != 0) { //홀수일 경우
            result = (result * base) % mod;
        }
        return result;
    }
}
