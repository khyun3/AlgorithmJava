package SILVER;

import java.math.BigInteger;
import java.util.Scanner;

public class BOJ_2407_조합 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int r = sc.nextInt();
        nCr(n, r);
    }

    //n!/(n-r)!r!
    private static void nCr(int n, int r) {
        BigInteger numerator = calcNumerator(n, Math.max(r, n-r));
        BigInteger denominator = calcDenominator(Math.min(r, n-r));

        System.out.print(numerator.divide(denominator));
    }
    private static BigInteger calcNumerator(int n, int k) {
        BigInteger x = new BigInteger("1");
        for (int i = n; i > k; i--) {
            x = x.multiply(BigInteger.valueOf(i));
        }
        return x;
    }
    private static BigInteger calcDenominator(int k) {
        BigInteger y = new BigInteger("1");
        for (int i = 2; i <= k; i++) {
            y= y.multiply(BigInteger.valueOf(i));
        }
        return y;
    }
}