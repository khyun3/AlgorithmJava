package SILVER;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_11660_구간_합_구하기_5 {
    static int [][] mtx, sec;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        mtx = new int [n+1][n+1];
        sec = new int [m][4];

        //행렬
        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 1; j <= n; j++) {
                mtx[i][j] = mtx[i][j-1] + Integer.parseInt(st.nextToken());
            }
        }
        //구간
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < 4; j++) {
                sec[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        System.out.print(solve(m));
    }
    static String solve(int m) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < m; i++) {
            int ar = sec[i][0];
            int ac = sec[i][1];
            int dr = sec[i][2];
            int dc = sec[i][3];
            int rCnt = dr - ar;
            int res = 0;
            for (int k = 0; k <= rCnt; k++) {
                res += mtx[ar+k][dc] - mtx[ar+k][ac-1];
            }
            sb.append(res).append("\n");
        }
        return sb.toString();
    }
}