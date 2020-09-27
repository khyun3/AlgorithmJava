package GOLD;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ_9251_LCS {
	
	public static void main(String[] args)throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		char [] a = br.readLine().toCharArray();
		char [] b = br.readLine().toCharArray();
		
		int r = a.length;
		int c = b.length;
		int [][] D = new int[r+1][c+1]; //증가하는 길이를 저장할 테이블
		
		System.out.println(LCS(a, b, D, r, c));
	}

	private static int LCS(char[] a, char [] b, int[][] d, int r, int c) {
		
		//점화식
		// 0										r=0, c=0
		// d[i][j] = d[i-1][j-1]+1;					xi==yj
		// d[i][j] = Math.max(d[i-1][j],d[i][j-1]   otherwise
		for (int i = 1; i <= r; i++) {		//string 1
			for (int j = 1; j <= c; j++) {	//string 2
				if(a[i-1]==b[j-1]) {
					d[i][j] = d[i-1][j-1]+1;	//대각
				}
				else {
					d[i][j] = Math.max(d[i-1][j], d[i][j-1]); //상, 좌 비교
				}
			}
		}
		
		return d[r][c];
	}
}