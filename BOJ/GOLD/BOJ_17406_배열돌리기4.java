package GOLD;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_17406_배열돌리기4 {
	static int N, M, K, min = Integer.MAX_VALUE;
	static int[][] map, rtMap1, rtMap2;
	static int[] numbers;
	static boolean[] isSelected;
	static List<Point> list = new LinkedList<>();

	static class Point {
		int r;
		int c;
		int s;

		public Point(int r, int c, int s) {
			this.r = r;
			this.c = c;
			this.s = s;
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		// 맵 생성
		map = new int[N][M];
		rtMap1 = new int[N][M];
		rtMap2 = new int[N][M];
		numbers = new int[K];
		isSelected = new boolean[K];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		// k번 회전해야 하니까 그 정보를 저장
		for (int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine());
			// 여기서 리스트를 만들어 이거 넣어주는 리스트 ok?
			list.add(new Point(Integer.parseInt(st.nextToken()) - 1, Integer.parseInt(st.nextToken()) - 1,
					Integer.parseInt(st.nextToken())));
		}
		// 회전 함 수
		// nPn
		nPn(0);
		System.out.println(min);
	}

	private static void nPn(int cnt) { // npn을 뽑는 메서드 만듬
		if (cnt == K) {
			copy(); // 그리고 여기서 임시배열 2개를 map값 복사
			rotate(list, numbers); // 여기서 회전

			for (int i = 0; i < N; i++) {
				int sum = 0;
				for (int j = 0; j < M; j++) {
					if (K % 2 == 0)
						sum += rtMap1[i][j];
					else
						sum += rtMap2[i][j];
				}
				min = Math.min(min, sum);
			}
			return;
		}
		for (int i = 0; i < K; i++) {
			if (!isSelected[i]) {
				isSelected[i] = true;
				numbers[cnt] = i;
				nPn(cnt + 1);
				isSelected[i] = false;
			}
		}
	}

	private static void copy() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				rtMap1[i][j] = map[i][j];
				rtMap2[i][j] = rtMap1[i][j];
			}
		}
	}

	static void rotate(List<Point> p, int[] numbers) {
		int[] dr = { 0, 1, 0, -1 }; // 우 하 좌 상
		int[] dc = { 1, 0, -1, 0 };
		for (int k = 0; k < K; k++) {
			for (int s = 1; s <= p.get(numbers[k]).s; s++) {
				int r = p.get(numbers[k]).r - s; // 회전할 사각형
				int c = p.get(numbers[k]).c - s; // 시작점

				for (int d = 0; d < 4; d++) {
					for (int i = 0; i < s * 2; i++) { // 지금 사각형이 크기가 몇임?
						r = r + dr[d];
						c = c + dc[d];
						if (!check(r, c))continue;

						if (k % 2 == 1) {
							rtMap1[r][c] = rtMap2[r - dr[d]][c - dc[d]];
						} else{
							rtMap2[r][c] = rtMap1[r - dr[d]][c - dc[d]];
						}
					}
				}
			}
			if(k%2 == 1) {
				for (int i = 0; i < N; i++) {
					for (int j = 0; j < M; j++) {
						rtMap2[i][j] = rtMap1[i][j];
					}
				}
			}
			else {
				for (int i = 0; i < N; i++) {
					for (int j = 0; j < M; j++) {
						rtMap1[i][j] = rtMap2[i][j];
					}
				}
			}
		}
	}
	private static boolean check(int nr, int nc) {
		if (nr >= 0 && nr < N && nc >= 0 && nc < M)
			return true;
		return false;
	}
}