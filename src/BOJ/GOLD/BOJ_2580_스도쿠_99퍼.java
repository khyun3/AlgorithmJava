package BOJ.GOLD;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_2580_스도쿠_99퍼 {

    static class EmptyCell {
        final int r;
        final int c;
        Set<Integer> availableNumbers = new HashSet<>();

        public EmptyCell(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }

    static List<EmptyCell> emptyCells = new ArrayList<>(); //LinkedList로 풀면 터짐!
    static int[][] sudoku = new int[9][9];
    static boolean[][] rowUsed = new boolean[9][10];
    static boolean[][] colUsed = new boolean[9][10];
    static boolean[][] boxUsed = new boolean[9][10];
    static boolean solved = false;

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
                } else {
                    int number = sudoku[r][c];
                    rowUsed[r][number] = true;
                    colUsed[c][number] = true;
                    int regionIdx = getBoxIdx(r, c);
                    boxUsed[regionIdx][number] = true;
                }
            }
        }

        //2. 빈 셀 후보 숫자 계산해두기
        for (EmptyCell emptyCell : emptyCells) {
            int r = emptyCell.r;
            int c = emptyCell.c;
            int b = getBoxIdx(r, c);
            for (int i = 1; i < 10; i++) {
                if(isValid(r, c, b, i)) {
                    emptyCell.availableNumbers.add(i);
                }
            }
        }
        //3. 후보 숫자 개수 기준으로 내림차순 정렬
        emptyCells.sort(Comparator.comparing(emptyCell -> emptyCell.availableNumbers.size()));

        //4.스도쿠 채우기
        solveSudoku(0);
    }

    static void solveSudoku(int index) {
        if (index == emptyCells.size()) {
            printAnswer();
            System.exit(0);
        }

        EmptyCell emptyCell = emptyCells.get(index);
        int r = emptyCell.r;
        int c = emptyCell.c;
        int b = getBoxIdx(r, c);
        for (Integer number : emptyCell.availableNumbers) {
            if (isValid(r, c, b, number)) {
                placeNumber(r, c, b, number,true);
                solveSudoku(index + 1);
                placeNumber(r, c, b, number, false);
            }
        }
    }

    static void placeNumber(int r, int c, int b, Integer number, boolean isPlacing) {
        sudoku[r][c] = isPlacing ? number : 0;
        rowUsed[r][number] = isPlacing;
        colUsed[c][number] = isPlacing;
        boxUsed[b][number] = isPlacing;
    }

    static boolean isValid(int r, int c, int b, int number) {
        return !rowUsed[r][number] && !colUsed[c][number] && !boxUsed[b][number];
    }

    //0 ~ 9 구역 인덱스
    static int getBoxIdx(int r, int c) {
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
