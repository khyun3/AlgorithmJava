package SWEA.D3;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class D3_1226_미로1 {
	static int T, N = 16;
	static char [][] map;
	static boolean exit = false;
	static int [] dr = {-1,1,0,0};
	static int [] dc = {0,0,-1,1};

	public static void main(String[] args)throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for (int t = 1; t <= 10; t++) {
			map = new char[N][N];
			T = Integer.parseInt(br.readLine());
			exit = false;
			
			for (int i = 0; i < N; i++) {
				map[i] = br.readLine().toCharArray();
			}
			//우선 시작점을 찾자.
			boolean st = false;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if(map[i][j] == '2') {
						dfs(i,j);
						st = true;
						break;
					}
					if(st) break;
				}
			}
			if(exit) System.out.println("#"+t+" "+"1");
			else System.out.println("#"+t+" "+"0");
		}
	}
	private static void dfs(int i, int j) {
		for (int k = 0; k < 4; k++) {
			int nr = i+dr[k];	//4방향에 해당하는 좌표
			int nc = j+dc[k];
			
			if(exit) return;
			if(!check(nr,nc)) continue;
			if(map[nr][nc]=='3') { 
				exit = true;
				return;
			}
			if(map[nr][nc]!='0') {
				continue;
			}
			map[nr][nc] = '9';
			dfs(nr,nc);
		}	
	}
	private static boolean check(int nr, int nc) {
		if(0<=nr && nr<N && 0<=nc && nc<N) 
			return true;
		else
			return false;
	}
}
