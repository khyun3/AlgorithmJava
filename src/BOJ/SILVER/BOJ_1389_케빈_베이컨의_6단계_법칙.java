package BOJ.SILVER;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
//BFS로 풀 수 있음
public class BOJ_1389_케빈_베이컨의_6단계_법칙 {
    static int [][] adjMtx;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        adjMtx = new int [N+1][N+1];
        initAdjMtx(br, N, M);
        floydWarshall(N);
        int ans = getMin(N);
        System.out.print(ans);
    }

    private static int getMin(int n) {
        int min = n*n+1;
        int ans = n+1;
        for (int i = 1; i <= n; i++) {
            int sum = 0;
            for (int j = 1; j <= n; j++) {
                if(i == j) continue;
                sum += adjMtx[i][j];
            }
            if(min > sum){
                min = sum;
                ans = i;
            }
        }
        return ans;
    }

    private static void floydWarshall(int n) {
        for (int m = 1; m <= n; m++) {
            for (int s = 1; s <= n; s++) {
                for (int e = 1; e <= n; e++) {
                    int sum = adjMtx[s][m] + adjMtx[m][e];
                    if(sum < adjMtx[s][e]){
                        adjMtx[s][e] = sum;
                    }
                }
            }
        }
    }

    private static void initAdjMtx(BufferedReader br, int n, int m) throws Exception {
        for (int i = 0; i < m; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            adjMtx[x][y] = 1;
            adjMtx[y][x] = 1;
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if(adjMtx[i][j] == 0 ) {
                    adjMtx[i][j] = n+1;
                }
            }
        }
    }
}
