package BOJ.SILVER;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_15650_N과M_2_RE {
    static StringBuilder sb = new StringBuilder();
    static int[] arr;
    static int M, N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        N = Integer.parseInt(input[0]);
        M = Integer.parseInt(input[1]);

        arr = new int[M];
        //1부터 N까지 자연수 중에서 중복 없이 M개를 고른 수열
        //고른 수열은 오름차순이어야 한다.
        nCr(0, 1);
        System.out.print(sb);
    }

    private static void nCr(int index, int start) {
        if (index == M) {
            for (int i : arr) {
                sb.append(i).append(" ");
            }
            sb.append("\n");
            return;
        }

        for (int i = start; i <= N; i++) {
            arr[index] = i;
            nCr(index + 1, i + 1);
        }
    }
}
