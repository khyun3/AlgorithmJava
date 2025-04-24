package BOJ.SILVER;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_13305_주유소 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        long[] distance = new long [n-1];
        long[] cost = new long [n];

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < n - 1; i++) {
            distance[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < n; i++) {
            cost[i] = Integer.parseInt(st.nextToken());
        }


        //이동하면 최소 금액이라는 것을 보장해야 한다.
        //1. 현재 도시에서 다음 도시로 이동할 때 최소 기름만 넣어본다.
        //2. 도착했을 때 이전 주유소 비용과 비교한다.
        //3. 더 낮은 비용으로 다음 도시까지 비용을 더한다.
        long minCost = cost[0];
        long totalPrice = minCost * distance[0];
        for (int i = 1; i < n - 1; i++) {
            minCost = Math.min(minCost, cost[i]);
            totalPrice += minCost * distance[i];
        }
        System.out.println(totalPrice);
    }
}