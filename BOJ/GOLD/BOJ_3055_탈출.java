package GOLD;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 빈곳. | 물* | 돌x | 비버굴D | 고슴도치S
//이동 불가 => "KAKTUS"

public class BOJ_3055_탈출 {
	static int R, C;
	static char [][] map;
	static int [] dr= {-1,1,0,0}, dc= {0,0,-1,1};
	public static void main(String[] args)throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		map = new char [R][];
		int sr = -1;
		int sc = -1;
		ArrayList<int []> wList = new ArrayList<>();
		for (int i = 0; i < R; i++) {
			map[i] = br.readLine().toCharArray();
			for (int j = 0; j < C; j++) {
				if(map[i][j]=='S') { //고슴도치 위치 저장
					sr = i;
					sc = j;
				}
				if(map[i][j]=='*') {
					wList.add(new int [] {i,j}); //물 위치는 여러 곳 가능
				}
			}
		}
		int answer = bfs(sr,sc, wList);
		System.out.println(answer== -1 ? "KAKTUS": answer);
	}
	static private int bfs(int sr, int sc, ArrayList<int []> wList) {
		Queue<int []> que = new LinkedList<int[]>();
		
		//물위치
		for (int i = 0; i < wList.size(); i++) {
			que.offer(new int [] {wList.get(i)[0], wList.get(i)[1],0, '*'});
		}
		//고슴도치 위치
		que.offer(new int [] {sr,sc,0,'S'});
		
		while(!que.isEmpty()) {
			int [] curr = que.poll();
			//물이 먼저 이동
			if(curr[3]=='*')
				for (int d = 0; d < 4; d++) {
					int nr = curr[0] + dr[d];
					int nc = curr[1] + dc[d];
					
					if(!check(nr,nc)|| map[nr][nc]=='*' || map[nr][nc]=='X'|| map[nr][nc]=='D') continue;
					map[nr][nc] = '*';
					que.offer(new int [] {nr,nc,curr[2]+1,'*'});
				}
			
			//고슴도치 이동
			if(curr[3]=='S')
				for (int d = 0; d < 4; d++) {
					int nr = curr[0] + dr[d];
					int nc = curr[1] + dc[d];
					
					if(!check(nr,nc)|| map[nr][nc]=='S' || map[nr][nc]=='*' || map[nr][nc]=='X') continue;
					if(map[nr][nc]=='D') return curr[2]+1;
					map[nr][nc] = 'S';
					que.offer(new int [] {nr,nc,curr[2]+1,'S'});
				}
//			print();
		}
		return -1;

	}
	static boolean check(int nr, int nc) {
		if(nr>=0 && nr<R && nc>=0 && nc<C) return true;
		return false;
	}
//	static void print() {
//		System.out.println();
//		for (int i = 0; i < R; i++) {
//			for (int j = 0; j < C; j++) {
//				System.out.print(map[i][j]+" ");
//			}
//			System.out.println();
//		}
//	}
}
