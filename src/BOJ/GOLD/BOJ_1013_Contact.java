package BOJ.GOLD;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ_1013_Contact {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder answer = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            boolean yes = br.readLine().matches("(100+1+|01)+");
            answer.append(yes ? "YES\n": "NO\n");
        }
        System.out.print(answer);
    }
}
