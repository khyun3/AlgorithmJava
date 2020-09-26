package GOLD;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_2206_벽부수고이동하기 {
	static class Point{
		int r,c, item, cnt;

		public Point(int r, int c, int item, int cnt) {
			this.r = r;
			this.c = c;
			this.item = item;
			this.cnt = cnt;
		}

	}
	static int N, M, answer =-1;
	static char[][] map;
	static int[] dr = {-1,1,0,0};
	static int[] dc = {0,0,-1,1};
	static boolean[][][] v; //visited 배열 //1번은 아이템 사용한 경우 경로를 표시 0번은 아이템 사용아직 안했을 때
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new char[N][];
		v = new boolean[2][N][M];
		for (int i = 0; i < N; i++) {
			map[i] = br.readLine().toCharArray();
		}
		//입력 끝
		//벽은 1개만 뿌실 수 있다.
		//최단경로는 bfs다.
		bfs(new Point(0,0,0,1)); //cnt는 자기 자신도 경로에 포함하므로 1
		System.out.println(answer);
	}
	private static void bfs(Point p) {
		Queue<Point> que = new LinkedList<>(); 		//우선 que를 만든다.
		que.offer(p); //point를 offer한다.
		
		if(p.r==N-1 && p.c==M-1) answer=1;
		
		while(!que.isEmpty()) {
			Point cur = que.poll();	//가장 앞에있는 객체를 뺀다.
			for (int d = 0; d < 4; d++) {	//4방 탐색을한다.
				int nr = cur.r + dr[d];
				int nc = cur.c + dc[d];
				
				if(!check(nr,nc)) continue;	//맵안에 있다면
				if(nr==N-1 && nc == M-1) {
					answer= cur.cnt+1;
					return;
				}
				if(map[nr][nc]=='0' && !v[cur.item][nr][nc]) {
					v[cur.item][nr][nc] = true;	//아이템 사용 했다면 1, 아니면: 0
					que.offer(new Point(nr,nc,cur.item,cur.cnt+1));
				}
				if(map[nr][nc]=='1' && !v[1][nr][nc] && cur.item==0) { //지금 칸이 벽이고, 방문 x고, 아이템 사용했는가?
					v[1][nr][nc] = true;
					que.offer(new Point(nr,nc,cur.item+1,cur.cnt+1));
				}
			}
		}
	}
	private static boolean check(int nr, int nc) {
		if(nr>=0 && nr<N && nc>=0 && nc<M) return true;
		return false;
	}
	static void print(int a) {
		System.out.println();
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if(v[a][i][j])
				System.out.print("T ");
				else
				System.out.print("F ");
			}
			System.out.println();
		}
	}
}
