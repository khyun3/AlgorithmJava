package GOLD;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_16236_아기상어 {
	static class BabyShark {
		int r; // r값
		int c; // c값
		int s; // 크기
		int f; // 먹은 물고기 수
		public BabyShark(int r, int c, int s, int f) {
			this.r = r;		this.c = c;
			this.s = s;		this.f = f;
		}
	}
	static class Point implements Comparable<Point> {
		int r; // 위쪽 방향이 우선순위임
		int c;
		int t;

		@Override
		public int compareTo(Point b) {
			if(this.t < b.t) return -1; //시간
			else if(this.t == b.t) {
				if(this.r < b.r) return -1; //r값
				else if(this.r == b.r) return Integer.compare(this.c, b.c);  //c값
				else return 1;
			}
			else return 1;
		}
		public Point(int r, int c, int t) {
			this.r = r; this.c = c; this.t = t;
		}
	}
	static int map[][], N, time;
	static int dr[] = { -1, 0, 0, 1 }, dc[] = { 0, -1, 1, 0 };
	static boolean visited[][];

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		N = Integer.parseInt(br.readLine());

		map = new int[N][N];
		visited = new boolean[N][N];
		BabyShark bs = null;

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 9) {
					bs = new BabyShark(i, j, 2, 0); // 아기상어의 위치를 초기화 시킨다.
					map[i][j] = 0;
				}
			}

		} // 맵입력 끝
		bfs(bs);
		System.out.println(time);
	}
	private static void bfs(BabyShark bs) {
		Queue<Point> que = new LinkedList<Point>();
		PriorityQueue<Point> pq = new PriorityQueue<Point>();
		que.offer(new Point(bs.r, bs.c, 1)); // r,c,시간
		visited[bs.r][bs.c] = true;
		while (!que.isEmpty()) {
			int size = que.size();
			for (int s = 0; s < size; s++) { //레벨별 관리
				Point cur = que.poll();
				// 4방으로 탐색
				for (int i = 0; i < 4; i++) {
					int nr = cur.r + dr[i];
					int nc = cur.c + dc[i];

					if (!check(nr, nc) || map[nr][nc] > bs.s || visited[nr][nc])
						continue; // 범위를 나가거나, 크기가 더 크거나, 이미 지나간 길이라면

					// 해당칸을 방문처리 한다.
					visited[nr][nc] = true;

					// 같은 거리에 먹을 수 있는 물고기를 모두 구함
					// 가장 가까운 물고기가 먹을 수 있다면
					if (map[nr][nc] != 0 && map[nr][nc] < bs.s) {
						pq.offer(new Point(nr,nc,cur.t));
					} else {
						// 이동만 가능하다면
						que.offer(new Point(nr, nc, cur.t + 1));
					}
				}
			}
			if(!pq.isEmpty()) {
				Point k= pq.poll();
				bs.f += 1;
				map[k.r][k.c] = 0; // 먹은 물고기가 있던 칸은 0로 바꿈
				if (bs.f == bs.s) { // 먹은 수와 크기가 동일하다면 크기를 키운다.
					bs.s += 1;
					bs.f = 0;
				}
				// 물고기를 먹었다면 아기상어를 해당 위치로 옮긴다.
				bs.r = k.r;
				bs.c = k.c;
				time = k.t;

				// 물고기를 1마리 먹었으므로 que를 초기화 시킨다.
				que.clear();
				pq.clear();
				// 이동한 위치를 que에 넣는다.
				que.offer(new Point(bs.r, bs.c, k.t + 1));
				clearVisited();
			}
		}
	}
	private static void clearVisited() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				visited[i][j] = false;
			}
		}

	}
	private static boolean check(int nr, int nc) {
		if (nr >= 0 && nr < N && nc >= 0 && nc < N)
			return true;
		return false;
	}
}