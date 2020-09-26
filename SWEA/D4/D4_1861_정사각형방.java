package D4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class D4_1861_정사각형방 {
	static int T, N;
	static int [] dr = {0,0,-1,1};
	static int [] dc = {-1,1,0,0};
	static int [] answer = new int[2];
	static int [][] map;
	public static void main(String[] args)throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		T = Integer.parseInt(br.readLine());
		
		for (int t = 1; t <= T; t++) {
			N = Integer.parseInt(br.readLine());
			answer[0] = 9999;
			answer[1] = 1;
			map = new int[N][N];
			int temp=0;			
			for (int i = 0; i < map.length; i++) {
				st = new StringTokenizer(br.readLine().trim());
				for (int j = 0; j < map.length; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			for (int i = 0; i < map.length; i++) {
				for (int j = 0; j < map.length; j++) {
					temp = bfs(i,j);
					if(temp > answer[1]) {
						answer[0] = map[i][j];
						answer[1] = temp;
					}else if(temp == answer[1] && answer[0]>map[i][j]) {
						answer[0] = map[i][j];
					}
				}
			}
			System.out.println("#"+t+" "+ answer[0] +" "+ answer[1]);
		}
	}
	private static int bfs(int r, int c) {
		Queue<int[]> queue = new LinkedList<>();
		queue.offer(new int [] {r,c});
		int antemp = 1;
		while(!queue.isEmpty()) {
			int [] curr = queue.poll();
			int cr = curr[0];
			int cc = curr[1];
			
			for(int d = 0; d<4; d++) {
				int nr = cr+dr[d];
				int nc = cc+dc[d];
				if(!check(nr,nc)) continue;
				if(map[nr][nc]-1 == map[cr][cc]) {
					queue.offer(new int[] {nr,nc});
					antemp++;
				}
			}
		}
		return antemp;
	}
	private static boolean check(int r, int c) {
		if(0<=r && r<N && 0<=c && c<N)
			return true;
		else
			return false;
	}
}