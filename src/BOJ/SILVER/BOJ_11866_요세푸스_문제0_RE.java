package BOJ.SILVER;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;

public class BOJ_11866_요세푸스_문제0_RE {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder answer = new StringBuilder("<");
        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int K = Integer.parseInt(input[1]);
        solution(N, K, answer);
        System.out.println(answer);
    }

    private static void solution(int N, int K, StringBuilder answer) {
        ArrayDeque<Integer> que = new ArrayDeque<>();
        for (int i = 1; i <= N; i++) {
            que.offer(i);
        }

        while(!que.isEmpty()) {
            for (int i = 1; i < K; i++) {
                que.offer(que.poll());
            }
            answer.append(que.poll()).append(", ");
        }
        answer.delete(answer.length()-2, answer.length());
        answer.append(">");
    }
}