package SWEA.D4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class D4_8382_방향전환 {
	static int answer;
	static boolean visited[][];
	public static void main(String[] args)throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st =null;
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		
		for (int t = 1; t <= T; t++) {
			int xy[] = new int [4];
			answer = Integer.MAX_VALUE/5;
			visited= new boolean[201][201];
			st = new StringTokenizer(br.readLine()," ");
			for (int i = 0; i < 4; i++) {
				xy[i] = Integer.parseInt(st.nextToken())+100;
			}
			if(xy[0]!=xy[2] || xy[1] != xy[3]) {
				bfs(xy, 0);
				visited= new boolean[201][201];
				bfs(xy, 2);
			}
			else answer = 0;
			
			sb.append("#").append(t).append(" ").append(answer).append("\n");
		}
		System.out.print(sb);
	}
	
	static int dr[] = {-1,1,0,0}, dc[] = {0,0,-1,1};
	private static void bfs(int[] xy, int z) {
		Queue<int []> que = new LinkedList<int[]>();
		que.offer(new int [] {xy[0], xy[1], z, 0});
		visited[xy[0]][xy[1]] = true;;
		while(!que.isEmpty()) {
			int cur[] = que.poll();
			int k = cur[2];
			
			for (int i = k; i < k+2; i++) {
				int nr = cur[0]+dr[i];
				int nc = cur[1]+dc[i];
				
				if(nr<0 || nr>200 || nc<0 || nc>200 || visited[nr][nc]) continue;
				visited[nr][nc] = true;
				if(nr==xy[2] && nc==xy[3]) {
					answer = Math.min(cur[3]+1, answer);
					return;
				}
				que.offer(new int [] {nr,nc, cur[2]==0 ? 2 : 0 , cur[3]+1});
			}
		}
	}
}