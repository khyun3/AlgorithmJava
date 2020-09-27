package GOLD;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ_17218_비밀번호만들기 {

	static char[] pw1, pw2;
	static int [][] D;
	public static void main(String[] args)throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		pw1 = br.readLine().toCharArray();
		pw2 = br.readLine().toCharArray();

		//LCS로 최장 공통 문자열을 구하자
		//table을 만든다.
		int r = pw1.length;
		int c = pw2.length;
		D = new int [r+1][c+1]; //+1해주는 이유는 초기 0값들을 1행과 1열에 배치하기 위함
		
		LCS(r,c);
		System.out.println(answer(r-1,c-1));
		
	}	
	private static String answer(int r,int c) {
		StringBuilder sb = new StringBuilder();
		int lcsLength = D[r+1][c+1];
		
		while(lcsLength!=0) {
			//같다면 대각으로 올라가라
			if(pw1[r]==pw2[c]) {
				sb.append(pw1[r]);		
																		//System.out.println("R : "+r+"  C : "+c+"  str : "+sb.toString());
				r-=1; c-=1;
				lcsLength -=1;
				continue;
			}
			//다르다면 
			if(pw1[r]!=pw2[c]) {
				if(D[r+1][c] >= D[r][c+1]) { //왼쪽값이 위쪽 값과 같거나 더 크면 왼쪽으로 이동
					c-=1;
				}
				else if(D[r+1][c] < D[r][c+1]){
					r-=1;
				}
			}
		}
		
		return sb.reverse().toString();
	}
	private static void LCS(int r, int c) {
		//점화식
		//0											i=0 or j=0
		//D[i][j] = D[i-1][j-1]+1					xi = yj
		//D[i][j] = Math.max(D[i-1][j],D[i,j-1])	otherwise(xi != yj ...)
		
		for (int i = 1; i <= r; i++) {
			for (int j = 1; j <=c; j++) {
				
				if(pw1[i-1] == pw2[j-1]) {
					D[i][j] = D[i-1][j-1]+1; //대각값
				}
				else {
					D[i][j] = Math.max(D[i-1][j], D[i][j-1]); //위,왼쪽 값
				}
				//출력해보기
				//print();
			}
		}
	}

	static void print() {
		System.out.println();
		System.out.print("    ");
		for (int i = 0; i < pw2.length; i++) {
			System.out.print(pw2[i]+" ");
		}
		System.out.println();
		
		int cnt = 0;
		for (int i = 0; i <= pw1.length; i++) {
			for (int j = 0; j <= pw2.length; j++) {
				if(i>0 && j==0 && cnt<pw1.length) {
					System.out.print(pw1[cnt]+" ");
					cnt++;
				}
				else if(i==0 && j==0) System.out.print("  ");
				System.out.print(D[i][j]+" ");
			}
			System.out.println();
		}
		
	}
}