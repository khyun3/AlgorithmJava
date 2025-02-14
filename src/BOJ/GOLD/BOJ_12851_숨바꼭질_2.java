package BOJ.GOLD;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_12851_숨바꼭질_2 {
    static int minMvCnt = 1000000, dupCnt;
    static boolean[] visited = new boolean[100001];

    static class Seek {
        int x;
        int mvCnt;

        public Seek(int x, int mvCnt) {
            this.x = x;
            this.mvCnt = mvCnt;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        bfs(n, k);
        System.out.println(minMvCnt + "\n" + dupCnt);
    }

    static void bfs(int n, int k) {
        Queue<Seek> que = new LinkedList<>();
        que.offer(new Seek(n, 0));

        while (!que.isEmpty()) {
            Seek cur = que.poll();
            visited[cur.x] = true;

            //최초 방문보다 이동 횟수가 많다면 종료
            if(minMvCnt < cur.mvCnt){
                break;
            }
            //동생과 만났다면
            if(cur.x == k){
                minMvCnt = cur.mvCnt;
                dupCnt++;
                continue;
            }
            //이동 방법 3가지
            int a = cur.x - 1;
            int b = cur.x + 1;
            int c = cur.x * 2;
            if (a >= 0 && !visited[a]) {
                que.offer(new Seek(a, cur.mvCnt + 1));
            }
            if (b <= 100000 && !visited[b]) {
                que.offer(new Seek(b, cur.mvCnt + 1));
            }
            if (c <= 100000 && !visited[c]) {
                que.offer(new Seek(c, cur.mvCnt + 1));
            }
        }
    }
}