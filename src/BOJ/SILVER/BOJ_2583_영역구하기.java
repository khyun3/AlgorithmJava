package BOJ.SILVER;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;


public class BOJ_2583_영역구하기 {
	static int N, M, K;
	static int[][] map;
	static int res=0;
	static List<Integer> area = new ArrayList<>(); 
	static int [] dr = {-1,1,0,0}, dc = {0,0,-1,1};
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		StringBuilder sb = new StringBuilder();
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken()); 
		K = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		
		for (int k = 0; k < K; k++) {
			st = new StringTokenizer(br.readLine()," ");
			int R1,R2,C1,C2;
			C1 = Integer.parseInt(st.nextToken());
			R1 = Integer.parseInt(st.nextToken());
			C2 = Integer.parseInt(st.nextToken());
			R2 = Integer.parseInt(st.nextToken());
			
			for (int r = R1; r < R2; r++) {
				for (int c = C1; c < C2; c++) {
					map[r][c] = 1;
				}
			}
		}
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if(map[i][j]==0) {
					bfs(i,j, area.size()+2, 1);
				}
			}
		}
		sb.append(area.size()).append("\n");
		Collections.sort(area);
		for (int i : area) {
			sb.append(i).append(" ");
		}
		System.out.println(sb);
	}
	//개리맨더링, 프로세스 , 아기상어
	private static void bfs(int r, int c, int cnt, int k) {
		Queue<int []> que = new LinkedList<>();
		que.offer(new int [] {r,c,cnt, k});
		map[r][c] = cnt;
		while(!que.isEmpty()) {
			int [] cur = que.poll();
			for (int i = 0; i < 4; i++) {
				int nr = cur[0] + dr[i];
				int nc = cur[1] + dc[i];
				
				if(!check(nr,nc))continue;
				if(map[nr][nc]!=0) continue;
				
				map[nr][nc] = cur[2];
				que.offer(new int [] {nr,nc,cur[2],k++});
			}
		}
		area.add(k);
	}
	private static boolean check(int nr, int nc) {
		if(nr>=0 && nr<N && nc>=0 && nc<M) return true;
		return false;
	}
}