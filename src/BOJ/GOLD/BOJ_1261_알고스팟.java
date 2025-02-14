package BOJ.GOLD;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class BOJ_1261_알고스팟 {
	static int N, M;
	static char[][] map;
	static boolean[][] visited;
	static int answer=0;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
			
		map = new char [M][];
		visited = new boolean[M][N];
		for (int i = 0; i < M; i++) {
			map[i] = br.readLine().toCharArray();
		}
		bfs(0,0,0);
		System.out.println(answer);
	}
	private static void bfs(int r, int c, int cnt) {
		int [] dr = {-1,1,0,0}; 
		int [] dc = {0,0,-1,1};
		Deque<int []> que = new LinkedList<>();
		que.offer(new int [] {r,c, cnt} );
		while(!que.isEmpty()) {
			int [] cur = que.poll();
			for (int i = 0; i < 4; i++) {
				int nr = cur[0] + dr[i]; 
				int nc = cur[1] + dc[i];
				
				if(!check(nr,nc)) continue;
				if(!visited[nr][nc] && map[nr][nc]=='0') {//갈수있으면 먼저 가본다.
					visited[nr][nc] = true;
					que.addFirst(new int[] {nr,nc,cur[2]});
				}
				else if(!visited[nr][nc] && map[nr][nc]=='1') {
					visited[nr][nc] = true;
					map[nr][nc] = (char)(cur[2]+1+'0');
					que.offer(new int [] {nr,nc,cur[2]+1});
				}
				if(nr==M-1 && nc==N-1) {
					answer=cur[2];
					return;
				}
				//print();
			}
		}
	}
	private static boolean check(int nr, int nc) {
		if(nr>=0 && nr<M && nc>=0 && nc<N) return true;
		return false;
	}
	static void print(){
		System.out.println();
		for (int i = 0; i < M; i++) {
			for (int j = 0; j < N; j++) {
				System.out.print(map[i][j]+" ");
			}
			System.out.println();
		}
	}
}