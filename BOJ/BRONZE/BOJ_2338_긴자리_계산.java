package BRONZE;

import java.math.BigInteger;
import java.util.Scanner;

public class BOJ_2338_긴자리_계산 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        BigInteger a = sc.nextBigInteger();
        BigInteger b = sc.nextBigInteger();

        String answer = String.format("%s\n%s\n%s", a.add(b),a.subtract(b),a.multiply(b));
        System.out.println(answer);
    }
}
