package BOJ.SILVER;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;

/*
* 숫자 카드는 정수 하나가 적혀져 있는 카드이다. 상근이는 숫자 카드 N개를 가지고 있다.
* 정수 M개가 주어졌을 때, 이 수가 적혀있는 숫자 카드를 상근이가 가지고 있는지 아닌지를 구하는 프로그램을 작성하시오.

* 첫째 줄에 상근이가 가지고 있는 숫자 카드의 개수 N(1 ≤ N ≤ 500,000)이 주어진다.
* 둘째 줄에는 숫자 카드에 적혀있는 정수가 주어진다.
* 숫자 카드에 적혀있는 수는 -10,000,000보다 크거나 같고, 10,000,000보다 작거나 같다. 두 숫자 카드에 같은 수가 적혀있는 경우는 없다.
* 셋째 줄에는 M(1 ≤ M ≤ 500,000)이 주어진다.
* 넷째 줄에는 상근이가 가지고 있는 숫자 카드인지 아닌지를 구해야 할 M개의 정수가 주어지며, 이 수는 공백으로 구분되어져 있다.
* 이 수도 -10,000,000보다 크거나 같고, 10,000,000보다 작거나 같다
* */

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
