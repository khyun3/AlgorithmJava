package GOLD;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ16928_뱀_사다리_게임 {

    static int [] board;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken()); //사다리 수
        int M = Integer.parseInt(st.nextToken()); //뱀 수

        board = new int [101];
        initBoard();
        for (int i = 0; i < N+M; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int x = Integer.parseInt(st.nextToken());
            int go = Integer.parseInt(st.nextToken());
            board[x] = go;
        }
        System.out.println(bfs());
    }
    static void initBoard() {
        for (int i = 1; i < 101; i++) {
            board[i] = i;
        }
    }
    static class Info {
        int idx;
        int cnt;

        public Info(int idx, int cnt) {
            this.idx = board[idx];
            this.cnt = cnt;
        }
    }
    static int bfs() {
        Queue<Info> que = new LinkedList<>();
        que.add(new Info(1, 0));

        while(!que.isEmpty()){
            Info curr = que.poll();

            for (int i = 6; i >= 1; i--) {
                int next = curr.idx + i;
                if(next < 100 && board[next] != -1) {
                    Info k = new Info(next, curr.cnt + 1);
                    que.offer(k);
                    if(next == board[next]) {
                        board[next] = -1;
                    }
                }
                else if((curr.idx + i) == 100){
                    return curr.cnt + 1;
                }
            }
        }
        return -1;
    }
}
