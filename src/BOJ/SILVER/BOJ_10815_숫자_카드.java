package BOJ.SILVER;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;

public class BOJ_10815_숫자_카드 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        br.readLine();
        Set<String> cardSet = new HashSet<>(List.of(br.readLine().split(" ")));

        int M = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        System.out.println(solution(M, cardSet, st));
    }

    static String solution(int M, Set<String> cardSet, StringTokenizer st) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < M; i++) {
            if (cardSet.contains(st.nextToken())) {
                sb.append(1).append(" ");
            } else {
                sb.append(0).append(" ");
            }
        }
        return sb.toString();
    }
}
