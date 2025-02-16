package BOJ.BRONZE;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_10810_공넣기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int n = Integer.parseInt(st.nextToken()); //바구니 수
        int m = Integer.parseInt(st.nextToken()); //공을 넣는 방법 수
        int[] baskets = new int[n];

        for (int z = 0; z < m; z++) {
            st = new StringTokenizer(br.readLine(), " ");
            put(baskets,
                    Integer.parseInt(st.nextToken()) - 1,
                    Integer.parseInt(st.nextToken()) - 1,
                    Integer.parseInt(st.nextToken()));
        }
        print(baskets);
    }

    static void put(int[] baskets, int i, int j, int k) {
        //만약 이미 공이 존재한다면 덮어 씌운다 == 기존 공을 빼고 새로운 공을 넣는다
        for (; i <= j; i++) {
            baskets[i] = k;
        }
    }

    static void print(int[] baskets) {
        StringBuilder sb = new StringBuilder();
        for (int basket : baskets) {
            sb.append(basket).append(" ");
        }
        System.out.print(sb);
    }
}
