package SWEA.D2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class D2_1974_스도쿠검증 {
	static int T,S, answer = 1;
	static int [][] map;
	public static void main(String[] args)throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		T = Integer.parseInt(br.readLine());
		
		for (int t = 1; t <= T; t++) {
			answer = 1;
			map= new int [9][9];
			for (int i = 0; i < 9; i++) {
				st = new StringTokenizer(br.readLine().trim());
				S = 0;
				for (int j = 0; j < 9; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					S +=map[i][j];	//행 검사
				}
				if(S != 45) {
					answer = 0;
				}
			}
			if(answer == 1) {//열 검사
				for (int i = 0; i < 9; i++) {
					S = 0;
					for (int j = 0; j < 9; j++) {
						S += map[j][i];
					}
					if(S != 45) {
						answer = 0;
						break;
					}
				}
			}
			if(answer == 1) { //자기자신 + 8방 검사 9번
				int [] R = {-1,-1,-1,0,0,0,1,1,1};
				int [] C = {-1,0,1,-1,0,1,-1,0,1};
				a:for(int i = 1; i<=7; i+=3) {
					for (int j = 1; j <= 7; j+=3) {
						S=0;
						for (int k = 0; k < 9; k++) {
							S +=map[i+R[k]][j+C[k]];
						}
						if(S != 45) {
							answer = 0;
							break a;
						}
					}
				}
			}
			System.out.println("#"+t+" "+answer);
		}
	}
}