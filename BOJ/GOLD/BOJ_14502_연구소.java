package GOLD;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_14502_연구소 {
	static int N, M, answer; //세로, 가로
	static List<int []> bList = new ArrayList<>();
	static int [] dr = {-1,1,0,0};
	static int [] dc = {0,0,-1,1};
	public static void main(String[] args)throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		int [][] map = new int [N][M];
		
		for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine()," ");
			for (int j = 0; j < M; j++) {
				int tmp =  Integer.parseInt(st.nextToken());
				map[i][j] = tmp;
				//시작점을 넣는다(바이러스 위치)
				if(tmp == 2) {
					bList.add(new int [] {i,j});
				}
			}
		}//입력 end
		
		go(map,0,0);
		System.out.println(answer);
	}

	private static void go(int [][] map, int cnt, int start) {
		if(cnt==3) {
			int [][] mapTmp = new int [N][M];
			
			for (int i = 0; i < N; i++) {
				for (int j = 0; j <M; j++) {
					mapTmp[i][j]= map[i][j];
				}
			}
			bfs(mapTmp);
			return;
		}
		for (int i = start; i < N*M; i++) {
			int nr = i/M;
			int nc = i%M;
			if(map[nr][nc]==0) {
				map[nr][nc]=9;
				go(map,cnt+1, i+1);
				map[nr][nc] = 0;
			}
		}
	}

	private static void bfs(int [][] map) {
		Queue<int []> que = new LinkedList<>();
		int [] cur = null;
		int cnt = 0;
		
		for (int[] l : bList) {
			que.offer(l);
		}
		while(!que.isEmpty()) {
			cur = que.poll();
			
			for (int i = 0; i < 4; i++) {
				int nr = cur[0] + dr[i];
				int nc = cur[1] + dc[i];
				
				if(!check(nr,nc) || map[nr][nc] !=0 ) continue;
				map[nr][nc] = 2;
				que.offer(new int [] {nr,nc});
			}
		}		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if(map[i][j]==0) cnt++;
			}
		}
		answer = Math.max(answer, cnt);
	}
	private static boolean check(int nr, int nc) {
		if(nr>=0 && nr<N && nc>=0 && nc<M ) return true;
		return false;
	}
}
