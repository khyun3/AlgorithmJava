package D4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class D4_1953_탈주범검거 {
	
	static int N, M, R, C, L, answer; 
	static boolean [][] visited;
	static List<int [][]> tunnel;
	public static void main(String[] args)throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		
		tunnel = new ArrayList<>();
		tunnel.add(new int [][] {}); //0인덱스 채워두기
		tunnel.add(new int [][] {{-1,0},{1,0},{0,-1},{0,1}}); //상하좌우
		tunnel.add(new int [][] {{-1,0},{1,0}}); //상하
		tunnel.add(new int [][] {{0,-1},{0,1}}); //좌우
		tunnel.add(new int [][] {{-1,0},{0,1}}); //상우
		tunnel.add(new int [][] {{1,0},{0,1}});  //하우
		tunnel.add(new int [][] {{1,0},{0,-1}}); //하좌
		tunnel.add(new int [][] {{-1,0},{0,-1}}); //상좌
		
		for (int t = 1; t <= T; t++) {
			answer = 1;
			st = new StringTokenizer(br.readLine()," ");
			
			N = Integer.parseInt(st.nextToken()); //map 세로
			M = Integer.parseInt(st.nextToken()); //map 가로
			R = Integer.parseInt(st.nextToken()); //멘홀 뚜껑 좌표 R
			C = Integer.parseInt(st.nextToken()); //멘홀 뚜껑 좌표 C
			L = Integer.parseInt(st.nextToken()); //탈출 후 소요된 시간 L
			
			int [][] map = new int [N][M];
			visited = new boolean [N][M];
			
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine()," ");
				for (int j = 0; j < M; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			bfs(map);
			sb.append('#').append(t).append(' ').append(answer).append('\n');
		}
		System.out.print(sb);
	}
	private static void bfs(int [][] map) {
		Queue<int []> que = new LinkedList<int[]>();
		que.offer(new int [] {R,C,1,map[R][C]}); //좌표, 이동수, 이동가능한 방향
		visited[R][C] = true;
		
		while(!que.isEmpty()) {
			int [] curr = que.poll();
			if(curr[2]==L) break;
			int [][] d=  tunnel.get(curr[3]); //터널에서 해당 터널의 형태를 가지고온다.
			for (int i = 0; i < d.length; i++) {
				int nr = curr[0] + d[i][0];
				int nc = curr[1] + d[i][1];
				
				if(!check(nr,nc) || visited[nr][nc] || map[nr][nc]==0)continue;
				if(!go(d[i][0],d[i][1],map[nr][nc])) continue;
				
				que.offer(new int [] {nr,nc,curr[2]+1,map[nr][nc]});
				visited[nr][nc] = true;
				answer++;
			}
		}
	}
	private static boolean go(int dr, int dc, int b) {
		
		int [][] t2 = tunnel.get(b);
		for (int i = 0; i < t2.length; i++) {
			if(-dr== t2[i][0] && -dc==t2[i][1]) return true;
		}
		return false;
	}
	private static boolean check(int nr, int nc) {
		if(nr>=0 && nr<N && nc>=0 && nc<M) return true;
		return false;
	}
}