package GOLD;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_9019_DSLR {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        StringTokenizer st;
        for (int t = 0; t < T; t++) {
            st = new StringTokenizer(br.readLine(), " ");
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            sb.append(bfs(A, B)).append("\n");
        }
        System.out.print(sb);
    }

    static class CALC {
        int num;
        String ops;

        public CALC(int num, String ops) {
            this.num = num;
            this.ops = ops;
        }
    }

    static String bfs(int A, int B) {
        boolean[] isVisited = new boolean[10000];
        Queue<CALC> que = new LinkedList<>();
        que.offer(new CALC(A, ""));
        isVisited[A] = true;
        while (!que.isEmpty()) {
            CALC curr = que.poll();

            int d = D(curr.num);
            if (d == B) {
                return curr.ops.concat("D");
            }
            checkVisit(isVisited, que, new CALC(d, curr.ops.concat("D")));

            int s = S(curr.num);
            if (s == B) {
                return curr.ops.concat("S");
            }
            checkVisit(isVisited, que, new CALC(s, curr.ops.concat("S")));

            int l = LR(curr.num, "L");
            if (l == B) {
                return curr.ops.concat("L");
            }
            checkVisit(isVisited, que, new CALC(l, curr.ops.concat("L")));

            int r = LR(curr.num, "R");
            if (r == B) {
                return curr.ops.concat("R");
            }
            checkVisit(isVisited, que, new CALC(r, curr.ops.concat("R")));
        }
        return "err";
    }

    static void checkVisit(boolean[] isVisited, Queue<CALC> que, CALC next) {
        if (!isVisited[next.num]) {
            que.offer(next);
            isVisited[next.num] = true;
        }
    }

    static int D(int n) {
        return 2 * n % 10000;
    }

    static int S(int n) {
        if (n == 0) {
            return 9999;
        } else {
            return n - 1;
        }
    }

    static int LR(Integer n, String distance) {
        switch (distance) {
            case "R":
                return n / 10 + n % 10 * 1000;
            case "L":
                return (n * 10 + n / 1000) % 10000;
            default:
                return 0;
        }
    }
}