package BOJ.SILVER;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_14889_스타트와링크_RE {
    static int n, max, min = Integer.MAX_VALUE;
    static int[][] s;
    static boolean[] selected;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        //step 1. n 입력
        n = Integer.parseInt(br.readLine());
        selected = new boolean[n];

        //1,2,3,4가 있으면 1,2 / 1,3 / 1,4만 구해보면 된다.
        //2,3/2,4/3,4는 구할 필요가 없다. 따라서 start팀에 1명을 고정 시킨다.
        selected[0] = true;

        max = n / 2;
        s = new int[n][n];
        //step 2. s 행렬 입력
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < n; j++) {
                s[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        //step 3.
        //n / 2 만큼 고를 수 있는 가짓수를 구한다.
        solution(1, 1);
        System.out.println(min);
    }

    static void solution(int index, int start) {
        if (max == index) {
            clacDiff();
            //최소값이 0이라면 프로그램을 종료시킨다.
            if(min == 0) {
                System.out.println(0);
                System.exit(0);
            }
            return;
        }

        for (int i = start; i < n; i++) {
            selected[i] = true;
            solution(index + 1, i + 1);
            selected[i] = false;
        }
    }

    static void clacDiff() {
        int startTeamSum = 0;
        int linkTeamSum = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (selected[i] && selected[j]) {
                    startTeamSum += s[i][j] + s[j][i];
                } else if (!selected[i] && !selected[j]) {
                    linkTeamSum += s[i][j] + s[j][i];
                }
            }
        }
        int diff = Math.abs(startTeamSum - linkTeamSum);
        min = Math.min(diff, min);
    }
}
