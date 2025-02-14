package BOJ.GOLD;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ_10026_적록색약 {
	static int N, res1, res2;
	static char [][] map;
	static boolean[][] visitedRedGreen;
	static boolean[][] visitedNormal;
	static int[] dr = {-1,1,0,0};
	static int[] dc = {0,0,-1,1};
	public static void main(String[] args)throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		map = new char [N][];
		visitedRedGreen = new boolean [N][N];
		visitedNormal = new boolean [N][N];
		
		for (int i = 0; i < N; i++) {
			map[i] = br.readLine().toCharArray(); //char
		}
		//적록 색약과 일반 사람들이 보는 구역을 나눠서 해당 구역의 개수를 구한다.
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if(!visitedNormal[i][j] && map[i][j]=='R') {
					res1++;
					normal(i,j,'R');
				}
				else if(!visitedNormal[i][j] && map[i][j]=='G') {
					res1++;
					normal(i,j,'G');
				}
				else if(!visitedNormal[i][j] && map[i][j]=='B') {
					res1++;
					normal(i,j,'B');
				}
				
				//적록색약
				if(!visitedRedGreen[i][j] && (map[i][j]=='R' || map[i][j]=='G')){
					res2++;
					RG(i,j,'G');
				}
				else if(!visitedRedGreen[i][j] && map[i][j]=='B'){
					res2++;
					RG(i,j,'B');
				}
			}
		}
		System.out.println(res1+" "+res2);
	}
	private static void normal(int r, int c, char k) {
		visitedNormal[r][c] = true;
		for (int i = 0; i < 4; i++) {
			int nr = r + dr[i];
			int nc = c + dc[i];
			
			if(!check(nr,nc)) continue;
			
			if(!visitedNormal[nr][nc] && map[nr][nc]==k) {
				visitedNormal[nr][nc] = true;
				normal(nr,nc,k);
			}
		}
	}
	
	private static void RG(int r, int c, char k) {
		visitedRedGreen[r][c] = true;
		for (int i = 0; i < 4; i++) {
			int nr = r + dr[i];
			int nc = c + dc[i];
			
			if(!check(nr,nc)) continue;
			if(visitedRedGreen[nr][nc]) continue;
			
			if(k=='G') {
				if(map[nr][nc]=='G' || map[nr][nc] == 'R') {
					visitedRedGreen[nr][nc] = true;
					RG(nr,nc,k);
				}
			}
			if(k=='B') {
				if(map[nr][nc]=='B') {
					visitedRedGreen[nr][nc] = true;
					RG(nr,nc,k);
				}
			}
		}
	}
	private static boolean check(int nr, int nc) {
		if(nr>=0 && nr<N && nc>=0 && nc<N) return true;
		return false;
	}
}
