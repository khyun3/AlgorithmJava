package GOLD;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1987_알파벳Re {
	static int R, C, max;
	static int [][] map;
	static int [] dr = {-1,1,0,0};
	static int [] dc = {0,0,-1,1};
	static boolean [] alpa;
	public static void main(String[] args)throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		map = new int [R][C];
		
		for (int i = 0; i < R; i++) {
			char [] tmp =br.readLine().toCharArray();
			for (int j = 0; j < C; j++) {
				map[i][j] = tmp[j]-'A';
			}
		}

		alpa = new boolean[26];
		
		dfs(0, 0, 1); //시작 좌표, cnt
		System.out.println(max);
	}
	private static void dfs(int r, int c, int cnt) {
		alpa[map[r][c]] = true;
		
		max = Math.max(max, cnt);
		if(max>=26) return;
		
		for (int i = 0; i < 4; i++) {
			int nr = r + dr[i];
			int nc = c + dc[i];
			
			if(!check(nr,nc) || alpa[map[nr][nc]]) continue;
			dfs(nr, nc, cnt+1);
		}
		alpa[map[r][c]] = false;
	}
	private static boolean check(int nr, int nc) {
		if(nr>=0 && nr<R && nc>=0 && nc<C) return true;
		return false;
	}
}