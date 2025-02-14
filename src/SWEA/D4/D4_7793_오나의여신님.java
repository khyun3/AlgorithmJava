package SWEA.D4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class D4_7793_오나의여신님 {
	
	static int T, N, M, answer;
	static char[][] map;
	static Queue<int []> dQue;
	static Queue<int []> sQue;
	static int[] dr = {-1,1,0,0};
	static int[] dc = {0,0,-1,1};
	
	public static void main(String[] args)throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			
			map = new char[N][];
			
			dQue = new LinkedList<>(); //악마
			sQue = new LinkedList<>(); //수연
			answer=0;
			for (int i = 0; i < N; i++) {
				map[i] = br.readLine().toCharArray();
				for (int j = 0; j < M; j++) {
					if(map[i][j] == 'S') {//수연 시작위치
						sQue.offer(new int [] {i,j});
					}
					else if(map[i][j] == '*'){//악마 시작위치
						dQue.offer(new int [] {i,j});
					}
				}
			}
			//bfs로 문제를 푼다.
			if((answer=goGoddess())==0) System.out.println("#"+t+" GAME OVER");
			else System.out.println("#"+t+" "+answer);
		}	
	}
	private static int goGoddess() {
		int cnt = 0, res = -1;
		
		a:while(true) {
			cnt++;
			//악마의 스킬이 먼저 퍼지게 해야함
			int dSize = dQue.size(); //해당 레벨 관리
			while(--dSize >= 0) {
				int [] dCur = dQue.poll();
				for (int i = 0; i < 4; i++) {
					int nr = dCur[0] + dr[i];
					int nc = dCur[1] + dc[i];
					
					if(!check(nr,nc)) continue;
					
					if(map[nr][nc] == '.') {
						map[nr][nc] = '*';
						dQue.offer(new int[]{nr,nc});
					}
				}
			}
			
			//수연이가 움직인다.
			int sSize = sQue.size();
			if(sSize == 0) break;
			while(--sSize >= 0) {
				
				int [] sCur = sQue.poll();
				for (int i = 0; i < 4; i++) {
					int nr = sCur[0] + dr[i];
					int nc = sCur[1] + dc[i];
					
					if(!check(nr,nc)) continue;
					if(map[nr][nc] == '.' ) {
						map[nr][nc] = 'S';
						sQue.offer(new int[]{nr,nc});
					}
					else if(map[nr][nc] == 'D') {
						res = cnt;
						break a;
					}
				}
			}
		}
		return res>-1 ? res : 0;
	}
	private static boolean check(int nr, int nc) {
		if(nr>=0 && nr<N && nc>=0 && nc<M) return true;
		return false;
	}
}