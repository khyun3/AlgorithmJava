package BOJ.BRONZE;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2566_최댓값 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int max = 0;
        int[] maxIdx = {1, 1};
        for (int r = 1; r < 10; r++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int c = 1; c < 10; c++) {
                byte currValue = Byte.parseByte(st.nextToken());
                if (currValue > max) {
                    max = currValue;
                    maxIdx[0] = r;
                    maxIdx[1] = c;
                }
            }
        }
        System.out.println(max);
        System.out.println(maxIdx[0] + " " + maxIdx[1]);
    }
}
