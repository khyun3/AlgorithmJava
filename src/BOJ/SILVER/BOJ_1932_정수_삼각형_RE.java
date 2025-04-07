package BOJ.SILVER;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1932_정수_삼각형_RE {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        int[][] maxTriangle = new int[N][];
        int lastColumnIndex = 0;

        //step 1. 정수 삼각형 숫자를 입력 받는다.
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            //step2. 행마다 1씩 증가하는 2차원 배열을 만든다.
            maxTriangle[i] = new int[i + 1];

            //step3. 지금까지 더해온 가장 큰 값을 DP배열에 넣는다.
            for (int j = 0; j <= i; j++) {
                int num = Integer.parseInt(st.nextToken());
                if (i == 0) { //최상단 입력일 경우
                    maxTriangle[i][0] = num;
                } else if (j == 0) { //왼쪽 경계일 경우
                    maxTriangle[i][j] = maxTriangle[i - 1][0] + num;
                } else if (j == i) {  //오른쪽 경계일 경우
                    maxTriangle[i][j] = maxTriangle[i - 1][lastColumnIndex] + num;
                    lastColumnIndex++;
                } else { //나머지
                    maxTriangle[i][j] = Math.max(maxTriangle[i - 1][j - 1], maxTriangle[i - 1][j]) + num;
                }
            }
        }
        //step4. 마지막 행의 가장 큰 값을 구해 출력한다.
        int answer = 0;
        for (int j = 0; j < maxTriangle[N - 1].length; j++) {
            answer = Math.max(answer, maxTriangle[N - 1][j]);
        }
        System.out.print(answer);
    }
}
