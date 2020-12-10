package SILVER;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_14716_현수막 {
	static int M, N, map[][];	
	static int [] dr = {-1,1,0,0,-1,-1,1,1}, dc = {0,0,-1,1,-1,1,-1,1};
	
	public static void main(String[] args)throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");

		M = Integer.parseInt(st.nextToken());//행
		N = Integer.parseInt(st.nextToken());//열
		
		map = new int [M][N];
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine()," ");
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		int cnt = 1;
		for (int i = 0; i < M; i++) {
			for (int j = 0; j < N; j++) {
				if(map[i][j]==1) {
					dfs(i,j, ++cnt);
				}
			}
		}
		System.out.println(cnt-1);
	}
	private static void dfs(int r, int c, int cnt) {
		map[r][c] = cnt;
		
		for (int i = 0; i < 8; i++) {
			int nr = r + dr[i];
			int nc = c + dc[i];
			
			if(!check(nr,nc) || map[nr][nc]!=1) continue;
			map[nr][nc] = cnt;
			dfs(nr,nc, cnt);
		}
	}
	private static boolean check(int nr, int nc) {
		if(nr>=0 && nr<M && nc>=0 && nc<N) return true;
		return false;
	}
}