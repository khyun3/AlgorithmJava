package BOJ.BRONZE;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ_24416_알고리즘수업_피보나치_수1 {
	 static int count1 = 0, count2 = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        fib(N);
        fibonacci(N);
        System.out.println(count1 + " " + count2);
    }

    static int fib(int n) {
        if (n == 1 || n == 2) {
            count1++;
            return 1;
        } else
            return fib(n - 1) + fib(n - 2);
    }

    static int fibonacci(int N) {
        int[] f = new int[N + 1];
        f[1] = 1;
        f[2] = 1;
        for (int i = 3; i <= N; i++) {
            f[i] = f[i - 1] + f[i - 2];
            count2++;
        }

        return f[N];

    }
}
