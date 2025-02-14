package BOJ.SILVER;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_17086_아기상어2 {
	static int N, M, map[][], max;
	static int[] dr = { -1, -1, -1, 0, 0, 1, 1, 1 }, dc = { -1, 0, 1, -1, 1, -1, 0, 1 };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		map = new int[N][M];
		Queue<int[]> bsq = new LinkedList<int[]>();
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 1)
					bsq.offer(new int[] { i, j, 0});
			}
		} // 맵 입력 끝
		bfs(bsq);
		System.out.println(max);
	}
	private static void bfs(Queue<int []> que) {
		while (!que.isEmpty()) {
			int size = que.size();
			for (int s = 0; s < size; s++) { 
				int[] cur = que.poll();
				max = Math.max(max, cur[2]);
				
				for (int i = 0; i < 8; i++) {
					int nr = cur[0] + dr[i];
					int nc = cur[1] + dc[i];

					if (!check(nr, nc) || map[nr][nc] != 0) continue;
					map[nr][nc] = cur[2]+1;
					que.offer(new int [] {nr,nc,cur[2]+1});
					
				}
			}
			print();
		}
	}
	private static boolean check(int nr, int nc) {
		if (nr >= 0 && nr < N && nc >= 0 && nc < M)
			return true;
		return false;
	}
	static void print() {
		System.out.println();
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				System.out.print(map[i][j]+" ");
			}
			System.out.println();
		}
	}
}
