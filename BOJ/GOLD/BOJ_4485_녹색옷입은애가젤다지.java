package GOLD;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_4485_녹색옷입은애가젤다지 {
	public static void main(String[] args)throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
        int t=1;
        
		while(true) {
			int N = Integer.parseInt(br.readLine());
			if(N==0) break; //while문 종료조건
			
			int [][] map = new int [N][N];
			
			StringTokenizer st = null;
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine()," ");
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			sb.append("Problem ").append(t++).append(": ").append(process(map, N)).append("\n");
		}
        System.out.println(sb);
	}

	private static int process(int[][] map, int n) {
		int [][] dist = new int [n][n];			 //distance를 알고있는 행열
		
		Queue<int []> que = new LinkedList<int[]>();
		que.offer(new int[] {0,0}); //시작점
		
		//무한대로 거리 행열을 채운다.
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				dist[i][j] = Integer.MAX_VALUE;
			}
		}
		dist[0][0] = map[0][0]; //시작점
		
		
		int [] dr = {-1,1,0,0}, dc= {0,0,-1,1};
		
		while(!que.isEmpty()) {
			int curr[] = que.poll();
			
			for (int i = 0; i < 4; i++) {
				int nr = curr[0] + dr[i];
				int nc = curr[1] + dc[i];
				
				if(nr<0 || nr>=n || nc<0 || nc>=n) continue;
				
				//현재 선택된 정점까지 가중치 + 목적지 정점에 연결된 간선 가중치가 더 작으면 갱신
				int  weightSum = dist[curr[0]][curr[1]] + map[nr][nc]; 
				
				//만약에 더 작다면
				if(dist[nr][nc] > weightSum) {
					dist[nr][nc] = weightSum;
					que.offer(new int[] {nr,nc});
				}
			}
		}
		return dist[n-1][n-1];
	}
}