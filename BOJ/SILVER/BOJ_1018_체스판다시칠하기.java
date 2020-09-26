package SILVER;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1018_체스판다시칠하기 {
	static int R,C, min = Integer.MAX_VALUE;
	static char [][] map;
	public static void main(String[] args)throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		map = new char[R][];
		
		//나무 판
		for (int i = 0; i < R; i++) {
			map[i] = br.readLine().toCharArray(); 
		}
		
		
		//검사 ㄱ
		for (int i = 0; i <= R-8; i++) {
			for (int j = 0; j <= C-8; j++) {
				find(i,j);
			}
		}
		System.out.println(min);
	}
	private static void find(int r, int c) {
		char even = 'W';
		char odd = 'B';
		
		for (int k = 0; k < 2; k++) { //BW로 시작하는지 WB로 시작하는지 몰라
			int cnt = 0;
			if(k==1) {
				even = 'B';
				odd = 'W';
			}
			for (int i = r; i < r+8; i++) {		
				for (int j = c; j < c+8; j++) {
					if(i%2==0){//짝수행일 때
						if(j%2==0) {//짝수열이라면
							if(even!=map[i][j]) { cnt++; //필요한 색과 다르면 cnt+1
							}
						}
						else {//홀수열이라면
							if(odd!=map[i][j]) { cnt++; //필요한 색과 다르면 cnt+1
							}
						}
					}
					else { //홀수행일 때
						if(j%2==1) {//홀수열
							if(even!=map[i][j]) { cnt++; //필요한 색과 다르면 cnt+1
							}
						}
						else {//짝수열
							if(odd!=map[i][j]) { cnt++; //필요한 색과 다르면 cnt+1
							}
						}
					}
				}
			}
			min = Math.min(cnt, min);
		}
	}
}