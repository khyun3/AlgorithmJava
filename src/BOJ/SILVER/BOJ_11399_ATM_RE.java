package BOJ.SILVER;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_11399_ATM_RE {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int answer;

        int[] p = new int[n];
        int[] sum = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < n; i++) {
            p[i] = Integer.parseInt(st.nextToken());
        }

        //1. 오름차순 정렬
        Arrays.sort(p);

        //2. 걸린 시간 추가
        answer = sum[0] = p[0];
        for (int i = 1; i < n; i++) {
            sum[i] = sum[i - 1] + p[i];
            answer += sum[i];
        }

        //3. 정답 출력
        System.out.println(answer);
    }
}
