package BOJ.BRONZE;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2480_주사위_세개 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int[] diceNumber = new int[3];
        for (int i = 0; i < 3; i++) {
            diceNumber[i] = Integer.parseInt(st.nextToken());
        }
        System.out.println(calPrice(diceNumber));
    }

    static int calPrice(int[] diceNumber) {
        int first = diceNumber[0];
        int second = diceNumber[1];
        int third = diceNumber[2];
        //같은 눈이 3개가 나오면 10,000원+(같은 눈)×1,000원의 상금을 받게 된다.
        if (first == second && second == third) {
            return 10000 + first * 1000;
        }
        //같은 눈이 2개만 나오는 경우에는 1,000원+(같은 눈)×100원의 상금을 받게 된다.
        if (first == second || first == third) {
            return 1000 + first * 100;
        } else if (second == third) {
            return 1000 + second * 100;
        }
        int largest;
        //모두 다른 눈이 나오는 경우에는 (그 중 가장 큰 눈)×100원의 상금을 받게 된다.
        largest = Math.max(first, second);
        largest = Math.max(largest, third);
        return largest * 100;
    }
}
