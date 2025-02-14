package BOJ.SILVER;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1780_종이의개수_RE {

	static int [] answer = new int[3];
	static int [][] paper;

	public static void main(String[] args)throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());

		paper = new int [N][N]; //3^7 = 2187칸
		init(br, N);
		solution(paper, N);
		System.out.println(String.format("%d\n%d\n%d",answer[0],answer[1],answer[2]));
	}
	public static void init (BufferedReader br,  int N) throws Exception {
		for (int [] row : paper){
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for(int i = 0; i < N; i++) {
				row[i] = Integer.parseInt(st.nextToken());
			}
		}
	}
	public static void solution(int [][] paper, int len) {

		if(isSame(paper)) {
			answer[paper[0][0]+1]++;
		}
		else {
			int startRow = 0;
			int startCol = 0;
			len = len / 3;
			for(int r = 0; r < 3; r++){
				for(int c = 0; c < 3; c++){
					solution(divide(paper, len, startRow, startCol), len);
					startCol +=len;
				}
				startRow+=len;
				startCol = 0;
			}
		}
	}
	//2. 같지 않다면 9등분 - method
	public static int [][] divide(int [][] paper, int len, int startRow, int startCol) {
		int [][] newPaper = new int [len][len];
		for(int r = 0; r < len; r++){
			for(int c = 0; c < len; c++) {
				newPaper[r][c] = paper[startRow+r][startCol+c];
			}
		}
		return newPaper;
	}

	//1. 모두 같은지 체크 - method
	public static boolean isSame(int [][] paper) {
		int comparedVal = paper[0][0];

		for (int [] row : paper) {
			for(int column : row) {
				if(comparedVal == column){
					continue;
				}
				else{
					return false;
				}
			}
		}
		return true;
	}
	public static void print(int [][] paper) {
		for (int [] row : paper) {
			for(int val : row) {
				System.out.print(val+" ");
			}
			System.out.println();
		}
	}
}