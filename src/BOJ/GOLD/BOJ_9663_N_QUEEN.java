package BOJ.GOLD;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_9663_N_QUEEN {
    static int n, answer;
    static boolean[] col, leftDiagonal, rightDiagonal;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        //1. n x n 체스판, n개의 퀸
        n = Integer.parseInt(br.readLine());
        //열과 대각에 놓을 수 있는지 체크 여부
        col = new boolean[n];
        leftDiagonal = new boolean[2 * n]; //왼쪽 윗 대각 row - col 이며 -(n - 1) ~ n - 1까지
        rightDiagonal = new boolean[2 * n];//오른쪽 윗 대각 row + col 이며 0 ~ 2 * n - 2까지

        //2. 놓을 수 있는 위치를 체크한다.
        solution(0);
        System.out.println(answer);
    }

    static void solution(int row) {
        if (row == n) {
            answer++;
            return;
        }

        for (int c = 0; c < n; c++) { // 행(row)은 고정, 열(column)을 순회
            if (!checkCoordinateOverlap(row, c)) {
                updateQueenState(true, row, c); //상태 업데이트
                solution(row + 1); // 다음 행으로
                updateQueenState(false, row, c); //상태 복원 - 백트레킹

            }
        }
    }

    static boolean checkCoordinateOverlap(int currRow, int currCol) {
        //사용중인 열인지 판단 ||           왼쪽 위 대각              ||         오른쪽 위 대각
        return col[currCol] || leftDiagonal[currRow - currCol + n] || rightDiagonal[currRow + currCol];
    }

    static void updateQueenState(boolean state, int r, int c) {
        col[c] = leftDiagonal[r - c + n] = rightDiagonal[r + c] = state;
    }
}
