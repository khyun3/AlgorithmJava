package BOJ.BRONZE;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_27433_팩토리얼2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long N = Integer.parseInt(br.readLine());
        long fValue = 1;

        for (int i = 1; i <= N; i++) {
            fValue *= i;
        }

        System.out.println(fValue);
    }
}
