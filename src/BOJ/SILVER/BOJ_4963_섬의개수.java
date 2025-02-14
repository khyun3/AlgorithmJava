package BOJ.SILVER;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_4963_섬의개수 {
	static int W, H;
	static int [] R = {-1,-1,-1,0,0,1,1,1};
	static int [] C = {-1,0,1,-1,1,-1,0,1};
	static int [][] map, mapTemp;
	public static void main(String[] args)throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		while(true) {
			st = new StringTokenizer(br.readLine());
			W = Integer.parseInt(st.nextToken());
			H = Integer.parseInt(st.nextToken());
			if(W == 0 && H == 0) return;
			
			map = new int[H][W];
			mapTemp = new int [H][W];
			
			for (int i = 0; i < H; i++) {
				st = new StringTokenizer(br.readLine().trim());
				
				for (int j = 0; j < W; j++) {
					map[i][j] =Integer.parseInt(st.nextToken());
				}
			}
			int cnt = 1;
			for (int i = 0; i < H; i++) {
				for (int j = 0; j < W; j++) {
					if(map[i][j] == 1 && mapTemp[i][j]==0) {
						cnt++;
						bfs(i,j,cnt);
					}
				}
			}
			System.out.println(cnt-1);
		}	
	}
	private static void bfs(int r, int c, int k) {
		Queue<int [] > que = new LinkedList<>();
		que.offer(new int [] {r,c,k});
		while(!que.isEmpty()) {
			int [] data = que.poll();
			mapTemp[data[0]][data[1]] = k;

			for (int i = 0; i < 8; i++) {
				int nr = data[0]+R[i];   
				int nc = data[1]+C[i];
				if(!check(nr,nc)) continue;
				if(map[nr][nc] == 1 && mapTemp[nr][nc] == 0) {
					mapTemp[nr][nc] = k;
					que.offer(new int [] {nr,nc,k});
				}
			}
		}
	}
	private static boolean check(int nr, int nc) {
		if(0<=nr && nr<H && 0 <=nc && nc<W) return true;
		return false;
	}	
}