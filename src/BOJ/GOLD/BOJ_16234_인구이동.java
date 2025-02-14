package BOJ.GOLD;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_16234_인구이동 {
	static int N,L,R,map[][], visited[][],answer;
	static int dir[][] = new int [][] {{-1,0},{1,0},{0,-1},{0,1}};
	public static void main(String[] args)throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		
		N = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		
		map = new int [N][N];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine()," ");
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}//입력끝
		
		//구역
		boolean loop = false;
		int cnt = 1;
		answer = -1;
		while(!loop) {
			
			visited = new int [N][N];
			loop = true;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if(visited[i][j]==0) {
						//i,j는 현재 방문 좌표
						 int tmp [] = bfs(i,j, cnt);
						 if(tmp[0]>1) {
							 change(tmp[1]/tmp[0], cnt);
							 loop=false;
						 }
					}
					cnt++;
				}
			}
			answer++;
		}
		System.out.print(answer);
	}
	static int[] bfs(int r, int c, int cnt) {
		Queue<int []> que = new LinkedList<int[]>();		
		visited[r][c] = cnt;
		que.offer(new int[] {r, c});
		int [] cur = null;
		int [] res = new int [] {1, map[r][c]};
		
		while(!que.isEmpty()) {
			cur = que.poll();
			
			for (int i = 0; i < 4; i++) {
				int nr = cur[0] + dir[i][0];
				int nc = cur[1] + dir[i][1];

				//땅 크기안에 들어와있고 아직 방문하지 않았다면
				if(!check(nr,nc)) continue;
				//L이상 R 이하이면
				if(visited[nr][nc]==0 && Math.abs(map[cur[0]][cur[1]]-map[nr][nc]) >= L && Math.abs(map[cur[0]][cur[1]]-map[nr][nc]) <= R) {
					que.offer(new int[] {nr,nc});
					res[0]++;
					res[1]+=map[nr][nc];
					visited[nr][nc] = cnt;
				}
			}
		}
		return res;
	}
	static boolean check(int nr, int nc) {
		return nr>=0 && nr<N && nc>=0 && nc<N;
	}
	static void change(int people, int cnt) {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if(cnt==visited[i][j]) {
					map[i][j] = people;
				}
			}
		}
	}
}
