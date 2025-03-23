package BOJ.SILVER;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_15649_N과M_1 {
    static StringBuilder answer = new StringBuilder();
    static int N, M;
    static boolean[] visited;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        N = Integer.parseInt(input[0]);
        M = Integer.parseInt(input[1]);

        visited = new boolean[N];
        arr = new int[M];

        nPr(0);
        System.out.println(answer);
    }

    private static void nPr(int index) {
        if (index == M) {
            for (int item : arr) {
                answer.append(item).append(" ");
            }
            answer.append("\n");
            return;
        }
        for (int i = 0; i < N; i++) {
            //선택된 숫자를 제거하고 순서대로 나열
            if (!visited[i]) {
                arr[index] = i + 1;
                visited[i] = true;
                nPr(index + 1);
                visited[i] = false;
            }
        }
    }
}
