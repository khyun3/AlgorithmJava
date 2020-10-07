package SILVER;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1012_유기농배추 {
	static int T,M,N,K; //tc, 가로, 세로, 배추 수
	static int [][] map;
	static int [] dr = {-1,1,0,0};
	static int [] dc = {0,0,-1,1};		
			
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		T = Integer.parseInt(br.readLine());
		
		for (int t = 0; t < T; t++) {
			st = new StringTokenizer(br.readLine()," ");//M,N,K
			M = Integer.parseInt(st.nextToken()); 
			N = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			
			map = new int [N][M];
			
			int x,y;
			for (int i = 0; i < K; i++) {
				st = new StringTokenizer(br.readLine()," ");
				x = Integer.parseInt(st.nextToken());
				y = Integer.parseInt(st.nextToken());
				map[y][x]=1;
				
			}
			
			int cnt = 1;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if(map[i][j]==1) {
						map[i][j] = ++cnt;
						dfs(i,j, cnt);
					}
				}
			}
			
			System.out.println(--cnt);
		}
	}
	private static void dfs(int r, int c, int cnt) {
		
		for (int d = 0; d < 4; d++) {
			int nr = r+dr[d];
			int nc = c+dc[d];
			
			if(!check(nr,nc))continue;
			if(map[nr][nc]!=1) continue;
			
			map[nr][nc] = cnt;
			dfs(nr,nc,cnt);
		}
	}
	private static boolean check(int nr, int nc) {
		if(nr>=0 && nr<N && nc>=0 && nc<M) return true;
		return false;
	}
}