package SILVER;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_7569_토마토 { 
	static int M, N, H, answer; //열, 행, 높이
	static int [][][] map;
	static Queue<int []> que = new LinkedList<>();
	
	public static void main(String[] args)throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken()); 
		H = Integer.parseInt(st.nextToken());
		
		map = new int [H][N][M];
		
		for (int i = 0; i < H; i++) {
			for (int j = 0; j < N; j++) {
				st = new StringTokenizer(br.readLine()," ");
				for (int k = 0; k < M; k++) {
					map[i][j][k] = Integer.parseInt(st.nextToken());
					if(map[i][j][k]==1)
						que.offer(new int [] {i,j,k,0});
				}
			}
		}
		
		bfs();
		for (int i = 0; i < H; i++) {
			for (int j = 0; j < N; j++) {
				for (int k = 0; k < M; k++) {
					if(map[i][j][k]==0)
						answer = -1;
				}
			}
		}
		System.out.println(answer);
	}
	private static void bfs() {
		int [] dh = {-1,0,1};
		int [] dr = {-1,1,0,0};
		int [] dc = {0,0,-1,1};
		int nh, nr, nc;
		while(!que.isEmpty()) {
			int [] cur = que.poll();
			
			for (int h = 0; h < 3; h++) {//위 아래 
				nh = cur[0] + dh[h];
				
				if(nh<0 || nh>=H) continue;
				if(map[nh][cur[1]][cur[2]]!=0)continue;
				
				map[nh][cur[1]][cur[2]] = cur[3]+1;
				que.offer(new int [] {nh,cur[1],cur[2],cur[3]+1});
			}
			for (int i = 0; i < 4; i++) {//상하좌우
				nr = cur[1] + dr[i];
				nc = cur[2] + dc[i];
				
				if(!check(nr,nc))continue;
				if(map[cur[0]][nr][nc]!=0)continue;
				
				map[cur[0]][nr][nc] = cur[3]+1;
				que.offer(new int [] {cur[0],nr,nc,cur[3]+1});
			}
			answer=cur[3];
		}
	}
	private static boolean check(int nr, int nc) {
		if(nr>=0 && nr<N && nc>=0 && nc<M) return true;
		return false;
	}
//	static void print() {
//		System.out.println();
//		for (int i = 0; i < H; i++) {
//			for (int j = 0; j < N; j++) {
//				for (int k = 0; k < M; k++) {
//					System.out.print(map[i][j][k]+" ");
//				}
//				System.out.println();
//			}
//			System.out.println("h "+i);
//		}
//	}
}
