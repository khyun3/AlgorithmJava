package BOJ.GOLD;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2638_치즈_dfs {
	static int N, M, answer = 1; // 모눈종이 행,열
	static int[][] map;// 모눈종이
	static int[] dr = { -1, 1, 0, 0 }, dc = { 0, 0, -1, 1 };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine().trim());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		map = new int[N][M]; // 모눈종이 생성

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine().trim());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());// 모눈종이에 치즈 정보 입력
			}
		}

		// bfs나 dfs로 탐색하기 난 dfs로 풀거임
		// 필요한 파라메터 : 탐색을 시작할 행렬 좌표
		// 우리는 외부 공기를 탐색할 거기 떄문에 0,0부터 시작하자(가장자리는 치즈가 놓이지 못한다는 조건)
		// 대각은 확인하면 큰일남 4방탐색으로 진행해야함.
		
		int cnt = 0; // 치츠가 다 녹았니?
		while (cnt!=N*M) {
			dfs(0, 0);
			cnt = 0;
			
			// 2칸 이상 외부 공기에 닿은 친구들을 구하자.
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					
					if (map[i][j] == 1) {
						for (int d = 0; d < 4; d++) {
							int nr = i + dr[d];
							int nc = j + dc[d];
							if (map[nr][nc] == 9) {
								map[i][j]++;
							}
						}
					}
				}
			}
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if (map[i][j] >= 3) {
						map[i][j] = 0;
					}
					if (map[i][j] == 2) {
						map[i][j] = 1;
					}
					if (map[i][j] == 0) {
						cnt++;
					}
				}
			}
			if(cnt != N*M) {answer++;}
			print();
		}
		System.out.println(answer);
	}

	private static void dfs(int r, int c) {

		for (int i = 0; i < 4; i++) {
			int nr = r + dr[i];
			int nc = c + dc[i]; // 4방 탐색을 할거다.

			// 기저
			if (!check(nr, nc))
				continue;
			if (map[nr][nc] == 0) {
				map[nr][nc] = 9; // 외부 공기를 9로 바꾸자.

				// 유도
				dfs(nr, nc); // 다음 깊이로 탐색을 하자.
			}
		}
	}

	private static boolean check(int nr, int nc) {
		if (nr >= 0 && nc >= 0 && nr < N && nc < M)
			return true;
		return false;
	}

	private static void print() {
		System.out.println();
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				System.out.print(map[i][j]+" ");
			}
			System.out.println();
		}
	}
}
