package BOJ.SILVER;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_1904_01타일 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        //N = 1 -> 1
        //N = 2 -> 2
        //N = 3 -> 3
        //N = 4 -> 5
        //즉, 피보나치 수열이다.
        System.out.println(fibo(N));

    }

    static int fibo(int N) {
        int a1 = 1;
        int a2 = 1;// 피보나치 수열의 1번(0), 2번(1) 값을 더한 첫 값.
        int answer = 1;
        for (int i = 2; i <= N; i++) {
            answer = (a1 + a2) % 15746;
            a1 = a2;
            a2 = answer;
        }
        return answer;
    }
}
