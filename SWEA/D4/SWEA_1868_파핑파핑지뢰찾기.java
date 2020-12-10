package D4;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class SWEA_1868_파핑파핑지뢰찾기 {
	
	static int M, N, answer;	
	static int [] dr = {-1,1,0,0,-1,-1,1,1}, dc = {0,0,-1,1,-1,1,-1,1};
	static char map[][];
	public static void main(String[] args)throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		
		for (int t = 1; t <= T; t++) {
			N = Integer.parseInt(br.readLine());
			map = new char [N][];
			answer = 0;
			for (int i = 0; i < N; i++) {
				map[i] = br.readLine().toCharArray();
			}
			
			int cnt = 0; //8방검사할 cnt
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					cnt = 0;
					if(map[i][j]=='.') {
						for (int d = 0; d < 8; d++) {//먼저 8방 모두 .인 부분을 찾아야함 
							int nr = i + dr[d];
							int nc = j + dc[d];
							if(!check(nr,nc) || map[nr][nc]!='*') cnt++;
						}
						if(cnt==8){//만약에 8방 모두 .이면 dfs 고고
							answer++;
							dfs(i,j);
						}
					}
				}
			}
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if(map[i][j]=='.') answer++;
				}
			}
			//print();
			sb.append('#').append(t).append(' ').append(answer).append('\n');
		}
		System.out.print(sb);
	}
	private static boolean check(int nr, int nc) {
		if(nr>=0 && nr<N && nc>=0 && nc<N) return true;
		return false;
	}
	
	private static void dfs(int r, int c) {
		int cnt = 0;
		for (int d = 0; d < 8; d++) {
			int nr = r + dr[d];
			int nc = c + dc[d];
			if(!check(nr,nc)) continue;
			if(map[nr][nc]=='*') cnt++;
		}
		map[r][c] = (char)(cnt+'0');
		if(cnt==0) { //해당 칸에 지뢰가 없다면 모든방향 dfs
			for (int d = 0; d < 8; d++) {
				int nr = r + dr[d];
				int nc = c + dc[d];
				if(!check(nr,nc) || map[nr][nc]!='.') continue;
				dfs(nr,nc);
			}
		}
	}
//	static void print() {
//		System.out.println();
//		for (int i = 0; i < N; i++) {
//			for (int j = 0; j < N; j++) {
//				System.out.print(map[i][j]+" ");
//			}
//			System.out.println();
//		}
//	}
}
