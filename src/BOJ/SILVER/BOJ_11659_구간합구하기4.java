package BOJ.SILVER;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_11659_구간합구하기4 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        //1. N과 M 입력
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        //2.부분합 구하기
        int[] subSum = new int[N+1];
        st = new StringTokenizer(br.readLine(), " ");

        for (int i = 1; i <= N; i++) {
            subSum[i] = subSum[i-1] + Integer.parseInt(st.nextToken());
        }

        //3. 구해둔 부분합 값 정답 빌더에 추가
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            sb.append(subSum[end] - subSum[start-1]).append("\n");
        }

        //4. 정답 출력
        System.out.print(sb);
    }
}
