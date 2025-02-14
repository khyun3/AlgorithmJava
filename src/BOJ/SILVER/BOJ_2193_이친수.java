package BOJ.SILVER;

import java.io.BufferedReader;
import java.io.InputStreamReader;

//다이나믹프로그래밍
//N
//1 1
//2 10
//3 100 101
//4 1000 1010 1001
//5 10000 10100 10101 10010 10001
//6 100000 100001 101000 101001 101010 100100 100101 100010
//결국 피보나치 수열
public class BOJ_2193_이친수 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        long n1 = 1, n2 = 1, n3 = 1;

        for (int i = 3; i <= N; i++) {
            n3 = n1 + n2;
            if(i >= 3) {
                n1 = n2;
                n2 = n3;
            }
        }
        System.out.println(n3);
    }
}
