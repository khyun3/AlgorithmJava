package BOJ.BRONZE;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_10163_색종이 {
	static int[][] map;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = 0;
		map = new int[101][101];
		N = Integer.parseInt(br.readLine());
		int k = 1;

		// c, r c크기,r크기
		for (int n = 0; n < N; n++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int c = Integer.parseInt(st.nextToken());
			int r = Integer.parseInt(st.nextToken());

			int cc = Integer.parseInt(st.nextToken());
			int rr = Integer.parseInt(st.nextToken());

			// 색종이 그리기
			for (int i = r; i < r + rr; i++) {
				for (int j = c; j < c + cc; j++) {
					map[i][j] = k;
				}
			}
			k++; // 색종이의 카운트
		}

		k = 0;
		for (int n = 0; n < N; n++) {
			
			int cnt = 0;
			k++;
			for (int i = 0; i < 101; i++) {
				for (int j = 0; j < 101; j++) {
					if (map[i][j] == k) {

						cnt++;
					}
				}
			}
			System.out.println(cnt);
		}

	}
}
