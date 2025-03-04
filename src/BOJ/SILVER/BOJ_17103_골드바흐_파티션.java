package BOJ.SILVER;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ_17103_골드바흐_파티션 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] primes = initPrimes();
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());

        for (int t = 0; t < N; t++) {
            int inputNum = Integer.parseInt(br.readLine());
            sb.append(findGoldbach(inputNum, primes)).append("\n");
        }
        System.out.println(sb);
    }

    private static int findGoldbach(int inputNum, int[] primes) {
        int resultCount = 0;
        //4
        for (int prime : primes) {
            //5
            if (prime > inputNum / 2) {
                break;
            }
            //6
            int b = inputNum - prime;
            //7
            if (Arrays.binarySearch(primes, b) >= 0) {
                //8
                resultCount++;
            }
        }
        return resultCount;
    }

    private static int[] initPrimes() {
        boolean[] isPrimes = new boolean[1000001];
        Arrays.fill(isPrimes, true);
        isPrimes[0] = isPrimes[1] = false;

        //소수의 성질, 에라토스테네스의 체로 소수 판별(1 ~ 100만까지)
        int lastNum = (int) Math.sqrt(1000001) + 1;
        for (int i = 2; i <= lastNum; i++) {
            if (isPrimes[i]) {
                for (int j = i * i; j < 1000001; j += i) {
                    isPrimes[j] = false;
                }
            }
        }
        return getPrimes(isPrimes);
    }

    private static int[] getPrimes(boolean[] isPrimes) {
        int count = 0;
        for (int i = 2; i < 1000001; i++) {
            if (isPrimes[i]) {
                count++;
            }
        }
        int[] primes = new int[count];
        int idx = 0;
        for (int i = 2; i < 1000001; i++) {
            if (isPrimes[i]) {
                primes[idx++] = i;
            }
        }
        return primes;
    }
}