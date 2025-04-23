package BOJ.GOLD;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_2580_스도쿠 {

    static class EmptyCell {
        final int r;
        final int c;
        List<Integer> availableNumbers;

        public EmptyCell(int r, int c) {
            this.r = r;
            this.c = c;
        }

        public void setAvailableNumbers(List<Integer> availableNumbers) {
            this.availableNumbers = availableNumbers;
        }
    }

    static List<EmptyCell> emptyCells = new LinkedList<>();
    static int[][] sudoku = new int[9][9];

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
                    emptyCells.add(new EmptyCell(r, c));
                }
            }
        }
        //빈셀에 들어갈 수 있는 숫자를 모두 검사하고 모두 가능하다면 체크해둔다.
        emptyCells.forEach(emptyCell -> emptyCell.setAvailableNumbers(getDuplicateNumbers(emptyCell.r, emptyCell.c)));
        emptyCells.sort(Comparator.comparing(emptyCell -> emptyCell.availableNumbers.size()));
        //백트레킹
        solveSudoku(0);
    }

    static void solveSudoku(int index) {
        if (index == emptyCells.size()) {
            printAnswer();
            System.exit(0);
        }

        int r = emptyCells.get(index).r;
        int c = emptyCells.get(index).c;
        for (Integer availableNumber : emptyCells.get(index).availableNumbers) {
            if (getAvailableNumbersInRegion(availableNumber, r, c) && getAvailableNumbersInRowAndCol(availableNumber, r, c)) {
                int prev = sudoku[r][c];
                sudoku[r][c] = availableNumber;
                solveSudoku(index + 1);
                sudoku[r][c] = prev;
            }
        }
    }

    static List<Integer> getDuplicateNumbers(int row, int col) {
        List<Integer> availableNumbers = new ArrayList<>();
        for (int candidate = 1; candidate < 10; candidate++) {
            if (getAvailableNumbersInRowAndCol(candidate, row, col)
                    && getAvailableNumbersInRegion(candidate, row, col)) {

                availableNumbers.add(candidate);
            }
        }
        return availableNumbers;
    }

    static boolean getAvailableNumbersInRowAndCol(int candidate, int row, int col) {
        for (int i = 0; i < 9; i++) {
            if (sudoku[i][col] == candidate) return false;
        }
        for (int i = 0; i < 9; i++) {
            if (sudoku[row][i] == candidate) return false;
        }
        return true;
    }

    static boolean getAvailableNumbersInRegion(int candidate, int row, int col) {
        //구역 체크, 3 x 3
        int startRow = (row / 3) * 3;
        int startCol = (col / 3) * 3;
        int endRow = startRow + 2;
        int endCol = startCol + 2;

        for (int r = startRow; r <= endRow; r++) {
            for (int c = startCol; c <= endCol; c++) {
                if (sudoku[r][c] == candidate) {
                    return false;
                }
            }
        }
        return true;
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
