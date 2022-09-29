package GOLD;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

//TODO: 다익스트라(, 0-1BFS로 풀어보기
public class BOJ_13549_숨바꼭질_3 {
    static int MAX = 100001;
    static boolean[] visited = new boolean[MAX];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int n = Integer.parseInt(st.nextToken()); //수빈
        int k = Integer.parseInt(st.nextToken()); //동생
        System.out.println(solve(n, k));
    }

    static int solve(int n, int k) {
        Queue<int[]> que = new LinkedList<>();

        que.offer(new int[]{n, 0}); //수빈 위치(x), 걸린시간(t)
        visited[n] = true;

        while (!que.isEmpty()) {
            int[] cur = que.poll();
            int x = cur[0];
            int t = cur[1];

            if (x == k) {
                return t;
            }
            int xTelpo = x;
            while (xTelpo != 0 && xTelpo * 2 < MAX) {
                xTelpo *= 2;
                if (!visited[xTelpo]) {
                    if (xTelpo == k) {
                        return t;
                    }
                    que.offer(new int[]{xTelpo, t});
                    visited[xTelpo] = true;
                }
            }
            if (x - 1 >= 0 && !visited[x - 1]) {
                que.offer(new int[]{x - 1, t + 1});
                visited[x - 1] = true;
            }
            if (x + 1 < MAX && !visited[x + 1]) {
                que.offer(new int[]{x + 1, t + 1});
                visited[x + 1] = true;
            }

        }
        return -1;
    }
}
