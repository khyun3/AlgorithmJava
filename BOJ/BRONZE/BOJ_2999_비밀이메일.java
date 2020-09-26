package BRONZE;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ_2999_비밀이메일 {
	static int R, C, N;
	static char [] email;
	static char [][] map;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		email = br.readLine().toCharArray();
		N = email.length;
		
		for (int i = 1; i <= Math.sqrt(N); i++) {
			if(N%i==0) {
				R=i;		 //나눠지는 가장 큰 수를 구한다.
			}
		}
		C = N/R;
		int k = 0;
		map = new char[R][C];
		for (int i = 0; i < C; i++) {
			for (int j = 0; j < R; j++) {
				map[j][i] = email[k];
				k++;
			}
		}
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				sb.append(map[i][j]);
			}
		}
		System.out.println(sb.toString());
	}
}