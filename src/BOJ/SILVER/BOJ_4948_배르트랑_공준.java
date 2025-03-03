package BOJ.SILVER;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Set;
import java.util.TreeSet;

public class BOJ_4948_배르트랑_공준 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //1. 미리 1부터 123456 * 2까지 소수를 판별해둔다.
        Set<Integer> primes = initPrimes();
        StringBuilder sb = new StringBuilder();
        //3. 테스트 케이스를 입력받고 입력받은 수까지의 소수 개수를 구한다.
        while(true) {
            String input = br.readLine();
            //4. 0이 들어오면 답을 출력하고 프로그램을 종료한다.
            if(input.equals("0")) {
                break;
            }
            int n = Integer.parseInt(input);
            int n2 = n*2;
            int primeCount = 0;
            for (Integer prime : primes) {
                if(n < prime && n2 >= prime) {
                    primeCount++;
                }
                if(prime >= n2) break;
            }
            sb.append(primeCount).append("\n");
        }
        System.out.println(sb);
    }

    //2. 많은 수의 소수를 판별해야 하므로 `에라토스테네스의 체 알고리즘`을 사용한다.
    static Set<Integer> initPrimes() {
        boolean[] isPrimes = new boolean[246913];
        Arrays.fill(isPrimes, true);
        isPrimes[0] = false;
        isPrimes[1] = false;

        int last = (int) Math.sqrt(246912) + 1;
        for (int i = 2; i <= last; i++) {
            if (isPrimes[i]) {
                isPrimes[i] = isPrime(i);
                int multi = 2;
                for (int j = i * multi; j <= 246912; j = i * multi) {
                    isPrimes[j] = false;
                    multi++;
                }
            }
        }
        Set<Integer> primes = new TreeSet<>();
        for (int i = 0; i < isPrimes.length; i++) {
            if (isPrimes[i]) {
                primes.add(i);
            }
        }
        return primes;
    }

    static boolean isPrime(int num) {
        if(num == 0 || num == 1) {
            return false;
        }
        if (num == 2 || num == 3) {
            return true;
        }
        int last = (int) Math.sqrt(num) + 1;
        for (int i = 2; i <= last; i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }
}
