package BOJ.GOLD;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BOJ_2638_치즈_bfs {
	static int T, N, M, time = 0;
	static int[][] map;
	static boolean[][] visited;
	static boolean checker;
	static int[] R = { -1, 1, 0, 0 };
	static int[] C = { 0, 0, -1, 1 };

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();// 행
		M = sc.nextInt();// 열
		map = new int[N][M];

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				map[i][j] = sc.nextInt();
			}
		}
		do {
			visited = new boolean[N][M];
			bfs(0, 0);
		} while (checker);
		
		System.out.println(time);
	}

	private static void bfs(int r, int c) {
		Queue<int[]> que = new LinkedList<>();
		que.offer(new int[] { r, c });
		visited[r][c] = true;

		// 외부 공기 표시
		while (!que.isEmpty()) {
			int[] qd = que.poll();
			for (int i = 0; i < 4; i++) {
				int nr = qd[0] + R[i];
				int nc = qd[1] + C[i];

				if (!check(nr, nc))
					continue;
				if (map[nr][nc] == 0 && !visited[nr][nc]) {
					visited[nr][nc] = true;
					que.offer(new int[] { nr, nc });
				}
			}
		}
		// 외부 공기와 2칸 이상 접촉한 치즈를 구한다.
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j] == 1) {
					for (int k = 0; k < 4; k++) {
						if (visited[i + R[k]][j + C[k]]) {
							map[i][j]++;
						}
					}
				}
			}
		}
		// 치즈들을 삭제한다.
		checker = false;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j] >= 3) {
					map[i][j] = 0;
					checker = true;
				} else if (map[i][j] == 2)
					map[i][j] = 1;
			}
		}
		if (checker)
			time++;
	}

	private static boolean check(int nr, int nc) {
		if (0 <= nr && nr < N && 0 <= nc && nc < M)
			return true;
		else
			return false;
	}
}