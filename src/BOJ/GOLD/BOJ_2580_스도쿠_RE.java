package BOJ.GOLD;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_2580_스도쿠_RE {

    static List<int[]> emptyCells = new ArrayList<>();
    static int[][] sudoku = new int[9][9];
    static boolean[][] rowUsed = new boolean[9][10]; // 행 숫자 사용여부
    static boolean[][] colUsed = new boolean[9][10]; // 열 숫자 사용여부
    static boolean[][] boxUsed = new boolean[9][10]; // 3x3 구역 숫자 사용여부

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        //1. 스도쿠 판 입력
        for (int r = 0; r < 9; r++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int c = 0; c < 9; c++) {
                sudoku[r][c] = Integer.parseInt(st.nextToken());
                if (sudoku[r][c] == 0) {
                    //0인 위치 r, c를 저장해둔다.
                    emptyCells.add(new int[]{r, c});
                } else {
                    int number = sudoku[r][c];
                    rowUsed[r][number] = true;
                    colUsed[c][number] = true;
                    int boxIdx = getBoxIndex(r, c);
                    boxUsed[boxIdx][number] = true;
                }
            }
        }

        //2.스도쿠 채우기
        solveSudoku(0);
    }

    static void solveSudoku(int index) {
        if (index == emptyCells.size()) {
            printAnswer();
            System.exit(0);
        }

        int[] cell = emptyCells.get(index);
        int r = cell[0];
        int c = cell[1];
        int b = getBoxIndex(r, c);
        for (int number = 1; number < 10; number++) {
            if (!rowUsed[r][number] && !colUsed[c][number] && !boxUsed[b][number]) {
                sudoku[r][c] = number;
                rowUsed[r][number] = colUsed[c][number] = boxUsed[b][number] = true;

                solveSudoku(index + 1);
                //백트레킹
                sudoku[r][c] = 0;
                rowUsed[r][number] = colUsed[c][number] = boxUsed[b][number] = false;
            }
        }
    }

    //0 ~ 9 구역 인덱스
    static int getBoxIndex(int r, int c) {
        return (r / 3) * 3 + (c / 3);
    }

    static void printAnswer() {
        StringBuilder sb = new StringBuilder();
        for (int r = 0; r < 9; r++) {
            for (int c = 0; c < 9; c++) {
                sb.append(sudoku[r][c]).append(" ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}
