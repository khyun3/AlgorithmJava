package BOJ.SPROUT;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_10807_개수_세기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        String intStr = br.readLine();
        int v = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(intStr, " ");
        int res = 0;
        //stream 사용보다 메모리, 속도 빠름
        for (int i = 0; i < N; i++) {
            if(v == Integer.parseInt(st.nextToken())) {
                res++;
            }
        }
        System.out.println(res);
    }
}
