package BOJ.GOLD;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ_2239_스도쿠 {
	static int [][] sudoku; 
	static boolean flag;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args)throws Exception {
		sudoku = new int [9][9];
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for (int i = 0; i < 9; i++) {
			char [] tmp = br.readLine().toCharArray();
			for (int j = 0; j < 9; j++) {
				sudoku[i][j] = tmp[j]-'0';
			}
		}
		fillSudoku(0);
		System.out.print(sb);
	}
	static void fillSudoku(int cnt) {
		boolean[] check= new boolean[9];
		if(cnt==81) {
			flag = true;
			print(sudoku);
			return;
		}
			int r = cnt/9;
			int c = cnt%9;
			if(sudoku[r][c]!=0) fillSudoku(cnt+1);
			else {
				rcCheck(r, c, check);
				tBytCheck(r, c, check);
				for (int j = 0; j < 9; j++) {
					if(flag) return;
					if(check[j]) continue;
						sudoku[r][c] = j + 1; 
						fillSudoku(cnt + 1);
						sudoku[r][c] = 0;
				}
			}
	}
	static void rcCheck(int r,int c, boolean [] check) {
		for (int i = 0; i < 9; i++) {
			if(sudoku[i][c]!=0) {check[sudoku[i][c]-1] = true;}//행 탐색
			if(sudoku[r][i]!=0) {check[sudoku[r][i]-1] = true;}//열 탐색
		}
	}
	static void tBytCheck(int r, int c, boolean [] check) {
		int dr=0, dc=0;
		if(0<=r && 0<=c && r<=2 && c<=2) 	  {dr = 0; dc = 0;}
		else if(0<=r && 3<=c && r<=2 && c<=5) {dr = 0; dc = 3;}
		else if(0<=r && 6<=c && r<=2 && c<=8) {dr = 0; dc = 6;}
		else if(3<=r && 0<=c && r<=5 && c<=2) {dr = 3; dc = 0;}
		else if(3<=r && 3<=c && r<=5 && c<=5) {dr = 3; dc = 3;}
		else if(3<=r && 6<=c && r<=5 && c<=8) {dr = 3; dc = 6;}
		else if(6<=r && 0<=c && r<=8 && c<=2) {dr = 6; dc = 0;}
		else if(6<=r && 3<=c && r<=8 && c<=5) {dr = 6; dc = 3;}
		else if(6<=r && 6<=c && r<=8 && c<=8) {dr = 6; dc = 6;}

		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				if (sudoku[i + dr][j + dc] != 0) {
					check[sudoku[i + dr][j + dc] - 1] = true;
				}
			}
		}
	}
	static void print (int [][] sudoku) {
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				sb.append(sudoku[i][j]);
			}
			sb.append('\n');
		}
	}
}