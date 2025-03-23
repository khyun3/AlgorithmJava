package BOJ.GOLD;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ_2447_별찍기10 {
    static char[][] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        arr = new char[N][N];
        for (int i = 0; i < N; i++) {
            Arrays.fill(arr[i], '*');
        }

        makeStarArr(N, 0, 0);
        print(N);
    }

    static void makeStarArr(int n, int sRow, int sColumn) {
        //기저조건
        if (n == 1) return;

        int len = n / 3;
        //9개의 구역으로 분할
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                //5번째 구역은 '*' -> ' '로 변경
                if (i == 1 && j == 1) {
                    changeChar(len, sRow + len * i, sColumn + len * j);
                } else {
                    //나머지 구역
                    makeStarArr(len, sRow + len * i, sColumn + len * j);
                }
            }
        }
    }

    static void changeChar(int len, int sRow, int sColumn) {
        for (int i = sRow; i < sRow + len; i++) {
            for (int j = sColumn; j < sColumn + len; j++) {
                arr[i][j] = ' ';
            }
        }
    }

    static void print(int n) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                sb.append(arr[i][j]);
            }
            sb.append("\n");
        }
        System.out.print(sb);
    }
}
