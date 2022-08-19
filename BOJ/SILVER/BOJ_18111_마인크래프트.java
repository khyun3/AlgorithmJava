package SILVER;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_18111_마인크래프트 {
    static class Res {
        int time;
        int height;

        public Res() {
            this.time = time = Integer.MAX_VALUE;
            this.height = height = 0;
        }

        @Override
        public String toString() {
            return time + " " + height;
        }
    }

    static int N, M, B, filling, removal;
    static int[][] land;
    static Res minRes;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());
        minRes = new Res();
        land = new int[N][M];
        setLand(br);
        solve();
        System.out.println(minRes.toString());
    }

    public static void setLand(BufferedReader br) throws IOException {
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            while (st.hasMoreTokens()) {
                for (int j = 0; j < M; j++) {
                    land[i][j] = Integer.parseInt(st.nextToken());
                }
            }
        }
    }

    public static void solve() {
        for (int h = 0; h <= 256; h++) {
            filling = 0;
            removal = 0;
            flatten(h);
            if (isPossible(h)) {
                minRes.time = filling + removal * 2;
                minRes.height = h;
            }
        }
    }

    private static boolean isPossible(int h) {
        int blocks = B + removal;
        int time = filling + removal * 2;
        if (filling <= blocks) {
            if (minRes.time > time) {
                return true;
            } else if (minRes.time == time && minRes.height < h) {
                return true;
            }
        }
        return false;
    }

    public static void flatten(int h) {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (land[i][j] == h) {
                    continue;
                } else if (land[i][j] < h) {
                    filling += h - land[i][j];
                } else {
                    removal += land[i][j] - h;
                }
            }
        }
    }
}
