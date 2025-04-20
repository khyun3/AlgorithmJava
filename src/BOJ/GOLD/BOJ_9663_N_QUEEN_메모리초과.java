package BOJ.GOLD;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class BOJ_9663_N_QUEEN_메모리초과 {
    static int n, answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        //1. n x n 체스판, n개의 퀸
        n = Integer.parseInt(br.readLine());

        //2. 놓을 수 있는 위치를 체크한다.
        solution(0, new ArrayList<>());
        System.out.println(answer);
    }

    static void solution(int row, List<int[]> queens) {
        if (row == n) {
            answer++;
            return;
        }

        for (int c = 0; c < n; c++) { // 행(row)은 고정, 열(column)을 순회
            boolean isOverlap = checkCoordinateOverlap(row, c, queens);
            if (!isOverlap) {
                queens.add(new int[]{row, c}); // 현재 행(row)과 열(column)에 퀸 추가
                solution(row + 1, queens); // 다음 행으로 이동
                queens.remove(row); // 마지막에 추가된 퀸 제거
            }
        }
    }

    static boolean checkCoordinateOverlap(int currRow, int currCol, List<int[]> queens) {
        for (int i = 0; i < currRow; i++) {
            int pr = queens.get(i)[0];
            int pc = queens.get(i)[1];
            boolean ld = pr - pc == currRow - currCol; //왼쪽 위 대각(북서)
            boolean rd = pr + pc == currRow + currCol; //오른쪽 위 대각(북동)
            //이전좌표와 겹치는 열인지 판단, 이전좌표와 겹치는 대각인지 판단
            if (pc == currCol || ld || rd) {
                return true;
            }
        }
        return false;
    }
}
