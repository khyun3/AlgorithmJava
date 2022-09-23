package BRONZE;

import java.io.BufferedReader;
import java.io.InputStreamReader;
//자바 BigInt로 풀면 시간초과
public class BOJ_14928_큰_수 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] input = br.readLine().toCharArray();
        long temp = 0;
        for (int i = 0; i < input.length; i++) {
            temp = (temp * 10 + (input[i] - '0')) % 20000303;
        }
        System.out.print(temp);
    }
}