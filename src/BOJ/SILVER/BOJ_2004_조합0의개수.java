package BOJ.SILVER;

import java.util.Scanner;

public class BOJ_2004_조합0의개수 {
    public static void main(String[] args) {
        int N, R, K;
        Scanner scanner = new Scanner(System.in);
        N = scanner.nextInt();
        R = scanner.nextInt();
        K = N - R;
        int a2, a5, b2, b5, c2, c5; // a2*a5 / b2*b5*c2*c5 ==> nCr
        a2 = calcExponent(N, 2);
        a5 = calcExponent(N, 5);
        b2 = calcExponent(R, 2);
        b5 = calcExponent(R, 5);
        c2 = calcExponent(K, 2);
        c5 = calcExponent(K, 5);

        System.out.println(Math.min(a2 - b2 - c2 , a5 - b5 - c5));
    }
    public static int calcExponent(int n, int base) {
        int cnt = 0;
        while(n >= base) {
            cnt += n / base;
            n /= base;
        }
        return cnt;
    }
}
