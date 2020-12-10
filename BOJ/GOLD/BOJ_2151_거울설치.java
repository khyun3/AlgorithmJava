package GOLD;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class BOJ_2151_거울설치 {
	static int [] dr = {-1,-1,1,1}; //빛의 이동 방향은 대각 4방향
	static int [] dc = {-1,1,-1,1};
	static int N;
	static char [][] map;
	public static void main(String[] args)throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		map = new char [5][];
		
		int sr=-1,sc=-1; //문 1개의 좌표
		
		for (int i = 0; i < N; i++) {
			map[i] = br.readLine().toCharArray();
			
			if(sr==-1)
				for (int j = 0; j <N ; j++) {
					if(map[i][j] == '#')
						sr = i;
						sc = j;
				}
		}//방 정보 입력 완료
		
		bfs(sr,sc);
	}
	private static void bfs(int sr, int sc) {
		Queue<int []> que = new LinkedList<int[]>();
		que.offer(new int [] {sr,sc}); //que에 들어가는 좌표는 빛의 좌표라 하자 
		
		while(!que.isEmpty()) {
			int [] cur = que.poll();
			
			for (int i = 0; i < 4; i++) {
				int nr = cur[0] + dr[i];
				int nc = cur[1] + dc[i];

				//방안에 포함
				if(!check(nr,nc)) continue;
				//빛은 한 방향으로 직진한다. 따라서 벽을 만날 때 까지 직진해보자
				//거울을 놓을 수 있는 위치를 만났는가?
				//맞다면 우선 거울의 위치를 알아두자
				while(true) {
					
					if(map[nr][nc]=='!') {
						
					}
				}
			}
		}
	}
	private static boolean check(int nr, int nc) {
		if(nr>=0 && nr < N && nc>=0 && nc<N) return true;
		return false;
	}
}
