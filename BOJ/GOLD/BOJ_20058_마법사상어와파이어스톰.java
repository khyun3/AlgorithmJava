package GOLD;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_20058_마법사상어와파이어스톰 {
	static int N, Q, L, map[][]; //2^N칸, 마법시전 횟수, 범위, 맵
	static int dr[] = {-1,1,0,0}, dc[] = {0,0,-1,1};
	static int rmIce, maxCell;
	public static void main(String[] args)throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		N = (int)Math.pow(2.0,Double.parseDouble(st.nextToken()));
		Q = Integer.parseInt(st.nextToken());
		
		map = new int [N][N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine()," ");
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}//입력 끝
		
		//마법 시전할 때, L값
		st = new StringTokenizer(br.readLine()," ");
		while(st.hasMoreTokens()) {
			//2^L크기의 격자
			L = (int)Math.pow(2.0, Double.parseDouble(st.nextToken()));
			//L*L크기의 격자를 회전
			rotation(L);
			descIce();
		}
		//단지
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if(map[i][j]!=0) {
					rmIce += map[i][j];
					map[i][j] = 0;
					bfs(i,j);
				}
			}
		}
		System.out.println(rmIce +"\n"+ maxCell);
	}
	private static void bfs(int r, int c) {
		Queue<int []> que = new LinkedList<int[]>();
		que.offer(new int [] {r,c});
		int cnt = 1;
		while(!que.isEmpty()) {
			int cur[] = que.poll();
			for (int d = 0; d < 4; d++) {
				int nr = cur[0] + dr[d];
				int nc = cur[1] + dc[d];
				
				if(nr<0 || nr>=N || nc<0 || nc>=N || map[nr][nc]==0) continue;
				rmIce+=map[nr][nc];
				map[nr][nc] = 0;
				que.offer(new int[] {nr,nc});
				cnt++;
			}
		}
		maxCell = Math.max(cnt, maxCell);
	}
	private static void descIce() {
		int mtmp[][] = new int [N][N];
	
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				int cnt = 0;
				if(map[i][j]<=0) continue;
				
				for (int d = 0; d < 4; d++) {
					int nr = i + dr[d]; 
					int nc = j + dc[d];
					if(nr<0 || nr>=N || nc<0 || nc>=N) continue;
					if(map[nr][nc]>0)cnt++;
				}
				if(cnt<3) mtmp[i][j] = map[i][j]-1;
				else mtmp[i][j] = map[i][j];
			}
		}
		map = mtmp;
	}
	private static void rotation(int l) {
		int tmp[][] = new int [l][l];
		if(l==N) {
			for (int i = 0; i < l; i++) {
				for (int j = 0; j < l; j++) {
					tmp[j][l-1-i] = map[i][j];
				}
			}
			return;
		}
		int ptmp[][] = new int [l][l];
		int r=0,c=0, n=N-l;
		
		boolean start = true;
		while(true) {
			if(c==n) {
				r+= l;
				c = 0;
			}
			else if(!start) {c+=l;}
				
			for (int i = 0; i <l ; i++) {
				for (int j = 0; j < l; j++) {
					ptmp[i][j] = map[i+r][j+c];
				}
			}
			for (int i = 0; i < l; i++) {
				for (int j = 0; j < l; j++) {
					tmp[j][l-1-i] = ptmp[i][j];
				}
			}
			for (int i = 0; i < l; i++) {
				for (int j = 0; j < l; j++) {
					map[i+r][j+c] = tmp[i][j];
				}
			}
			if(r==n && c==n) break;
			start = false;
		}
	}
}