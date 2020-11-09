package SILVER;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_3187_양치기꿍 {
	static int R, C, sheep, wolf, vRes, kRes;
	static int [] dr = {-1,1,0,0}, dc={0,0,-1,1};
	static char [][] map;
	static boolean [][] visited;
	public static void main(String[] args)throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		map = new char[R][];
		visited = new boolean [R][C];
		
		for (int i = 0; i < R; i++) {
			map[i] = br.readLine().toCharArray();
		}
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if(map[i][j]!='#' && !visited[i][j]) {
					wolf = 0;
					sheep = 0;
					if(map[i][j]=='v') wolf++;
					if(map[i][j]=='k') sheep++;
					dfs(i,j);
					
					if(wolf>=sheep) vRes += wolf;
					else kRes +=sheep;
				}
			}
		}
		System.out.println(kRes +" "+ vRes);
	}
	private static void dfs(int r, int c) {
		visited[r][c] = true;
		for (int d = 0; d < 4; d++) {
			int nr = r + dr[d];
			int nc = c + dc[d];
			
			if(!check(nr,nc) || map[nr][nc]=='#' || visited[nr][nc]) continue;
			if(map[nr][nc]=='v') wolf++;
			if(map[nr][nc]=='k') sheep++;
			visited[nr][nc] = true;
			dfs(nr,nc);
		}
	}
	private static boolean check(int nr, int nc) {
		if(nr>=0 && nr<R && nc>=0 && nc<C) return true;
		return false;
	}
}