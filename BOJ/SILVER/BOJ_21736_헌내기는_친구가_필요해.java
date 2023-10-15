package SILVER;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

//그래프, bfs(유리), dfs
public class BOJ_21736_헌내기는_친구가_필요해 {
    static int N, M, answer;
    static char[][] map;
    static int [] doyeon = new int[2]; //도연의 좌표
    static final int[][] dirs = new int [][] {{0,1},{0,-1},{1,0},{-1, 0}}; //상하좌우

    public static void main(String[] args) throws Exception {
        //o는 빈공간, x는 벽, I는 도연, P는 사람

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new char[N][M];

        for (int x = 0; x < N; x++) {
            char[] cArr = br.readLine().toCharArray();
            map[x] = cArr;
            for (int y = 0; y < M; y++) {
                if(cArr[y] == 'I') {
                    doyeon[0] = x;
                    doyeon[1] = y;
                    map[x][y] = 'a';
                }
            }
        }
        bfs();
        System.out.println(answer > 0 ? answer : "TT");
    }
    static void bfs() {
        Queue<int[]> que = new LinkedList<>();
        que.offer(doyeon);

        while (!que.isEmpty()) {
            int[] loc = que.poll();

            for (int[] d : dirs) {
                int x = loc[0] + d[0];
                int y = loc[1] + d[1];

                if(checkNewDir(x,y) && (map[x][y] =='P' || map[x][y] =='O')) {
                    answer += map[x][y] == 'P' ? 1 : 0;
                    map[x][y] = 'a';
                    que.offer(new int [] {x,y});
                }
            }
        }
    }
    static boolean checkNewDir(int x, int y) {
        return x >= 0 && x < N && y >= 0 && y < M;
    }
}
