package SWEA.D4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class D4_2117_홈방범서비스 {
	static int T, N, M, max;
	static int[][] map;
	static boolean[][] visited;
	static int[] dr = {-1,1,0,0};
	static int[] dc = {0,0,-1,1};
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			st = new StringTokenizer(br.readLine()," ");
			N = Integer.parseInt(st.nextToken()); //도시의 크기
			M = Integer.parseInt(st.nextToken()); //집들의 지불 비용
			
			map = new int[N][N];
			max = 0;
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine()," ");
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			for (int k = 1; k <= N+1; k++) {
				int kCost = k*k+(k-1)*(k-1);
				int hCost = 1000000;
				
				for (int i = 0; i < N; i++) {
					for (int j = 0; j < N; j++) {
						visited = new boolean[N][N];
						
						if(k==1) {
							max = 1;
							continue;
						}
						int cnt = homeCnt(i, j, k); // r,c,cnt
						hCost = cnt*M;
						
						if(cnt>max && kCost <= hCost) {
							max = cnt;
						
						}
					}
				}
			}
			System.out.println("#"+t+" "+max);
		}
	}
	private static int homeCnt(int r, int c, int kn) { //k의 크기만큼 돌려본다.
		
		int cnt=0;
		Queue<int []> que = new LinkedList<>();
		que.offer(new int [] {r,c});
		if(map[r][c]==1) cnt++;
		visited[r][c]=true;

		for (int k = 1; k < kn; k++) {
			 int size = que.size();
			 
			for (int q = 0; q <size; q++) {
				int [] cur = que.poll();
				
				for (int i = 0; i < 4; i++) {
					int nr =cur[0]+ dr[i];
					int nc =cur[1]+ dc[i];

					if (!check(nr, nc))continue;
					if (visited[nr][nc])continue;

					if (map[nr][nc] == 1)cnt++;
					
					visited[nr][nc] = true;
					que.offer(new int[] {nr,nc});
				}
			}
		}
		return cnt;
	}
	private static boolean check(int nr, int nc) {
		if(nr>=0 && nr<N && nc>=0 && nc<N) return true;
		return false;
	}
	static void print() {
		System.out.println();
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if(visited[i][j]) 
					System.out.print("1 ");
				else
					System.out.print("0 ");
			}
			System.out.println();
		}
	}
}
