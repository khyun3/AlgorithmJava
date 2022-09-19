package GOLD;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
//방문체크 다시할 것 (틀렸음)
public class BOJ_12851_숨바꼭질_2 {
    static int[] result = new int[] {Integer.MAX_VALUE, 0};
    static boolean[] visited = new boolean[100001];

    static class Seek {
        int x;
        int moveCnt;

        public Seek(int x, int moveCnt) {
            this.x = x;
            this.moveCnt = moveCnt;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        bfs(n, k);
        System.out.println(result[0] + "\n" + result[1]);
    }

    static void bfs(int n, int k) {
        Queue<Seek> que = new LinkedList<>();
        que.offer(new Seek(n, 0));
        visited[n] = true;

        while (!que.isEmpty()) {
            Seek curr = que.poll();
            visited[k] = false;
            if (curr.x == k) {
                if (curr.moveCnt < result[0]) {
                    result[0] = curr.moveCnt;
                    result[1] = 1;
                    break;
                }
            }

            int a = curr.x - 1;
            if (a >= 0 && !visited[a]) {
                que.offer(new Seek(a, curr.moveCnt + 1));
            }
            int b = curr.x + 1;
            if (b <= 100000 && !visited[b]) {
                que.offer(new Seek(b, curr.moveCnt + 1));
            }
            int c = curr.x * 2;
            if (c > 0 && c <= 100000 && !visited[c]) {
                que.offer(new Seek(c, curr.moveCnt + 1));
            }
            if(a >= 0) {visited[a] = true;}
            if(b <= 100000) {visited[b] = true;}
            if(c <= 100000) {visited[c] = true;}
        }
        while(!que.isEmpty()) {
            Seek next = que.poll();
            if (next.x == k && next.moveCnt == result[0]) {
                    result[1]++;
            }
        }
    }
}