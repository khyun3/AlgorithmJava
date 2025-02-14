package BOJ.SILVER;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_7576_토마토 {
	private static int N, M, answer = -1;
	private static int [] R = {-1,1,0,0};
	private static int [] C = {0,0,-1,1};
	private static int [][] map;
	static Queue<int []> start = new LinkedList<>();
	
	public static void main(String[] args)throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());	//열
		M = Integer.parseInt(st.nextToken());	//행
		
		map = new int[M][N];
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] == 1) {
					int k = 0;
					start.offer(new int [] {i,j,k});
				}
			}
		}	
		bfs();
		a:for (int i = 0; i < M; i++) {
			for (int j = 0; j < N; j++) {
				if(map[i][j] == 0) {
					answer = -1;
					break a;
				}
				else { 
					if(map[i][j]> answer) {
						answer = map[i][j];
					}
				}
			}
		}
		if(answer == 1) {
			answer = 0;
		}
		System.out.println(answer);
	}
	private static void bfs() {
		
		while(!start.isEmpty()) {
			int [] xy = start.poll();
			int r = xy[0];		//행
			int c = xy[1];		//열
			int cnt = xy[2];	//일 수
			for (int i = 0; i <4 ; i++) {
				int nr = r+R[i];
				int nc = c+C[i];
				if(!check(nr,nc))continue;
				if(map[nr][nc] == 0) {
					map[nr][nc]=cnt+1;
					start.offer(new int [] {nr,nc,cnt+1});
				}
			}
		}
	}
	private static boolean check(int nr, int nc) {
		if(0<=nr && nr<M && 0<=nc && nc<N) return true;
		return false;
	}
}