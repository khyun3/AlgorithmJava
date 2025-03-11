package BOJ.SILVER;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ_10872_팩토리얼 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        System.out.println(factorial(N));
    }

    private static int factorial(int n) {
        int answer = 1;
        for (int i = 2; i <= n; i++) {
            answer *= i;
        }
        return answer;
    }
}
