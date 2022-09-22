package BRONZE;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1292_쉽게_푸는_문제 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int idx = 0;
        int res = 0;
        for (int i = 1; i < 47; i++) {
            if (idx > 1000) break;
            for (int j = 1; j <= i; j++) {
                idx++;
                if (idx >= a && idx <= b) {
                    res += i;
                }
            }
        }
        System.out.println(res);
    }
}
