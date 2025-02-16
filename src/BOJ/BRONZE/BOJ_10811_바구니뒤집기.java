package BOJ.BRONZE;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_10811_바구니뒤집기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] token = br.readLine().split(" ");
        int n = Integer.parseInt(token[0]);
        int m = Integer.parseInt(token[1]);
        int[] baskets = makeBaskets(n);
        for (int i = 0; i < m; i++) {
            token = br.readLine().split(" ");
            reverse(baskets, Integer.parseInt(token[0]) - 1, Integer.parseInt(token[1]) - 1);
        }
        print(baskets);
    }

    static int[] makeBaskets(int n) {
        int[] baskets = new int[n];
        for (int i = 0; i < n; i++) {
            baskets[i] = i + 1;
        }
        return baskets;
    }

    static void reverse(int[] baskets, int i, int j) {
        //i ~ j 까지 역순으로 돌린다.
        for (; i <= j; i++) {
            int temp = baskets[i];
            baskets[i] = baskets[j];
            baskets[j] = temp;
            j--;
        }
    }

    static void print(int[] baskets) {
        StringBuilder sb = new StringBuilder();
        for (int b : baskets) {
            sb.append(b).append(" ");
        }
        System.out.print(sb);
    }
}
