package BOJ.SILVER;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_13241_최소공배수 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");
        long a = Integer.parseInt(input[0]);
        long b = Integer.parseInt(input[1]);

        System.out.println(findLCM(a, b));
    }
    static long findLCM(long a, long b) {
        return a * b / findGCD(a, b);
    }
    static long findGCD(long a, long b) {
        while(b != 0) {
            long tmp = b;
            b = a % b;
            a = tmp;
        }
        return a;
    }
}