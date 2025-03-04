package BOJ.SILVER;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ_1929_소수구하기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        //1
        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int M = Integer.parseInt(input[1]);
        boolean[] isPrime = initPrimes(M);

        //2
        for (int i = N; i <= M; i++) {
            //3
            if (isPrime[i]) {
                sb.append(i).append("\n");
            }
        }
        System.out.println(sb);
    }

    static boolean[] initPrimes(int end) {
        end += 1;
        boolean[] primes = new boolean[end];
        Arrays.fill(primes, true);
        //0, 1은 소수가 아니다.
        primes[0] = false;
        primes[1] = false;

        //4. 에라토스테네스의 체
        int last = (int) Math.sqrt(end) + 1;
        for (int i = 2; i <= last; i++) {
            if (primes[i]) {
                for (int j = i * i; j < end; j += i) {
                    primes[j] = false;
                }
            }
        }
        return primes;
    }
}
