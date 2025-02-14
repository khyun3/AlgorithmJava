package BOJ.SILVER;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_2468_안전영역 {
	static int N,answer=0,H=0, atmp, cnt;
	static int [][] map, b;
	static int [] dr = {-1,1,0,0};
	static int [] dc = {0,0,-1,1};
	static Queue<int []> que= new LinkedList<>();
	public static void main(String[] args)throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		map = new int [N][N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(H<map[i][j]) {	//최대 높이를 구한다.
					H = map[i][j];
				}
			}
		}
		for (int i = 1; i < H; i++) {//물의 높이를 1씩 증가시켜서 bfs를 돌린다.
			cnt = 1;
			b = new int [N][N];
			for (int j = 0; j < N; j++) {
				for (int k = 0; k < N; k++) {
					if(map[j][k] > i && b[j][k]==0) {
						cnt++;
						bfs(j,k,i,cnt);// 필요한 정보 : r,c,물 높이, 단지
					}
					if(cnt> answer) answer = cnt;
				}
				
			}
		}
		if(answer == 0)
			System.out.println(1);
		else
			System.out.println(answer-1);
	}
	private static void bfs(int r, int c, int h, int k) {
		que.offer(new int[] {r,c});
		b[r][c]=k;
		while(!que.isEmpty()) {
			int [] cp = que.poll();
			
			for (int i = 0; i < 4; i++) {
				int nr = cp[0] + dr[i];
				int nc = cp[1] + dc[i];
				
				if(!check(nr, nc)) continue;
				if(map[nr][nc] > h && b[nr][nc] == 0) {
					b[nr][nc] = k;
					que.offer(new int [] {nr,nc});
				}
			}
		}
	}
	private static boolean check(int nr, int nc) {
		  if (nr>=0 && nr<N && nc>=0 && nc<N) {
		        return true;            
		    }
		    else
		        return false;
	}
}
