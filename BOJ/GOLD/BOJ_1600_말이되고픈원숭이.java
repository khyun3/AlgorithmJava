package GOLD;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_1600_말이되고픈원숭이 {
	static int K, W, H, map[][];
	static boolean visited[][][];
	// 나이트가 움직일 수 있는 방향은 총 8개
	static int[] dnr = { -2, -2, -1, 1, 2, 2, 1, -1 }, dnc = { -1, 1, 2, 2, 1, -1, -2, -2 };

	// 나이트의 움직임 횟수를 지나거나 사방으로 움직였을 때
	static int[] dr = { -1, 1, 0, 0 }, dc = { 0, 0, -1, 1 };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		K = Integer.parseInt(br.readLine());

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		W = Integer.parseInt(st.nextToken()); // 열
		H = Integer.parseInt(st.nextToken()); // 행

		map = new int[H][W];
		visited = new boolean[K + 1][H][W];
		for (int i = 0; i < H; i++) { // 행
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < W; j++) {// 열
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		// print();
		System.out.println(bfs(0, 0, 0, K));
	}

	static int bfs(int r, int c, int cnt, int k) {
		visited[0][0][0]=true;
		Queue<int[]> que = new LinkedList<int[]>();
		que.offer(new int[] { r, c, cnt, k }); // 좌표, 움직인 횟수, k 남은 횟수
		int[] curr = null;

		while (!que.isEmpty()) {
			curr = que.poll();
			if (curr[0] == H - 1 && curr[1] == W - 1) {
				return curr[2];
			}

			if (!check(curr[0], curr[1]) || map[curr[0]][curr[1]] == 1 || visited[curr[3]][curr[0]][curr[1]]) continue;
			visited[curr[3]][curr[0]][curr[1]] = true;

			
			for (int i = 0; i < 4; i++) {
				int nr = curr[0] + dr[i];
				int nc = curr[1] + dc[i];
				que.offer(new int[] { nr, nc, curr[2] + 1, curr[3]});
			}
			
			if(curr[3]==0) continue;
			
			for (int i = 0; i < 8; i++) {
				int nr = curr[0] + dnr[i];
				int nc = curr[1] + dnc[i];
				que.offer(new int[] { nr, nc, curr[2] + 1, curr[3] - 1 });
			}
		}
		return -1;
	}

	static boolean check(int nr, int nc) {
		if (nr >= 0 && nr < H && nc >= 0 && nc < W) return true;
		return false;
	}
}