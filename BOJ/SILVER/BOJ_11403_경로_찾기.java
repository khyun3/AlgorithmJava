package SILVER;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
//플로이드 와샬(Floyd-Warshall)
public class BOJ_11403_경로_찾기 {
    static int MAX;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        MAX = N+1;
        int[][] adjMtx = new int[N][N];

        init(N, br, adjMtx);
        FloydWarshall(N, adjMtx);
        print(N, adjMtx);
    }

    private static void init(int n, BufferedReader br, int[][] adjMtx) throws Exception {
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < n; j++) {
                adjMtx[i][j] = Integer.parseInt(st.nextToken());
                adjMtx[i][j] = adjMtx[i][j] == 0 ? MAX : adjMtx[i][j];
            }
        }
    }

    private static void FloydWarshall(int n, int[][] adjMtx) {
        for (int m = 0; m < n; m++) { //중간점
            for (int s = 0; s < n; s++) { //시작점
                for (int e = 0; e < n; e++) { //도착점
                    int k = adjMtx[s][m] + adjMtx[m][e];
                    if(adjMtx[s][e] > k) {
                        adjMtx[s][e] = k;
                    }
                }
            }
        }
    }

    private static void print(int n, int[][] adjMtx) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                sb.append(adjMtx[i][j] != MAX ? 1 : 0).append(" ");
            }
            sb.append("\n");
        }
        System.out.print(sb);
    }
}
