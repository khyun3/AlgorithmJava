package BOJ.SILVER;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_9461_파도반_수열 {
    static long[] paDoBan = new long[101];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        //1 1 1 2 2 n = 5까진 공식이 없음
        paDoBan[1] = paDoBan[2] = paDoBan[3] = 1;
        paDoBan[4] = paDoBan[5] = 2;
        for (int i = 5; i <= 100; i++) {
            paDoBan[i] = paDoBan[i - 5] + paDoBan[i - 1];
        }
        while (T-- > 0) {
            int N = Integer.parseInt(br.readLine());
            sb.append(paDoBan[N]).append("\n");
        }
        System.out.print(sb);
    }
}
