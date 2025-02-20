package BOJ.BRONZE;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
[문제]
거스름돈의 액수가 주어지면 리암이 줘야할
 쿼터(Quarter, $0.25)의 개수,
 다임(Dime, $0.10)의 개수,
 니켈(Nickel, $0.05)의 개수,
 페니(Penny, $0.01)의 개수를 구하는 프로그램을 작성하시오.
 [조건]
 거스름돈은 항상 $5.00 이하이고,
 손님이 받는 동전의 개수를 최소로 하려고 한다.
 */
public class BOJ_2720_새탁소_사장_동혁 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < T; i++) {
            int c = Integer.parseInt(br.readLine());
            solution(c, sb);
        }
        System.out.println(sb);
    }

    static void solution(int changeAmount, StringBuilder sb) {
        int[] coins = {25, 10, 5, 1};
        for (int coin : coins) {
            sb.append(changeAmount / coin).append(" ");
            changeAmount %= coin;
        }
        sb.append("\n");
    }
}
