package BOJ.SILVER;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_20529_가장_가까운_세_사람의_거리 {
    static int T, N, min;
    static String[] selected = new String[3];
    static String[] mbtis;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while (T-- > 0) {
            N = Integer.parseInt(br.readLine());
            min = Integer.MAX_VALUE;
            st = new StringTokenizer(br.readLine(), " ");
            mbtis = new String[N];

            //비둘기집 원리,
            // MBTI의 개수가 32개가 넘어가면 무조건 3개가 겹치는 MBTI가 존재한다.
            if(N > 32) {
                sb.append(0).append("\n");
                continue;
            }
            Map<String, Integer> mbtiMap = new HashMap<>();
            for (int i = 0; i < N; i++) {
                String mbti = st.nextToken();
                mbtiMap.putIfAbsent(mbti, 0);
                mbtiMap.computeIfPresent(mbti, (k,v) -> v + 1);
                mbtis[i] = mbti;
            }
            if(mbtiMap.values().stream().anyMatch(v -> v >= 3)) {
                sb.append(0).append("\n");
            }
            else {
                combination(0, 0);
                sb.append(min).append("\n");
            }
        }
        System.out.print(sb);
    }

    static void combination(int cnt, int start) {
        if(min == 0) return;
        if(cnt == 3) {
            int dist = dist(selected[0], selected[1])
                    + dist(selected[0], selected[2])
                    + dist(selected[1], selected[2]);
            min = Math.min(min, dist);
            return;
        }

        for (int i = start; i < mbtis.length; i++) {
            selected[cnt] = mbtis[i];
            combination(cnt+1, i + 1);
        }
    }
    static int dist(String a, String b) {
        int dist = 0;
        for (int i = 0; i < 4; i++) {
            if(a.charAt(i)!= b.charAt(i)) dist++;
        }
        return dist;
    }
}
