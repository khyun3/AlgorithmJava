package BRONZE;

import java.math.BigInteger;
import java.util.Scanner;

public class BOJ_1271_엄청난_부자2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        BigInteger N = sc.nextBigInteger();
        BigInteger M = sc.nextBigInteger();

        System.out.println(N.divide(M) + " " + N.mod(M));
    }
}
