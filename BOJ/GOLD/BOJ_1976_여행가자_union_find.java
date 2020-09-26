package GOLD;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1976_여행가자_union_find {
	static int N, M;
	static int[] parents, rank;
	static int[] path;
	static char[][] map;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;

		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());

		map = new char[N][N];
		parents = new int[N];
		rank = new int[N];
		path = new int[M];

		// 연결 정보 입력받기
		for (int i = 0; i < N; i++) {
			map[i] = br.readLine().toCharArray();
		}
		// 여행 경로 입력받기
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < M; i++) {
			path[i] = Integer.parseInt(st.nextToken());
		}

		makeSet();
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (map[i][j] == '1') {
					union(i, j);
				}
			}
		}
		boolean check = true;
		int temp = find(parents[path[0]-1]);
		for (int i = 1; i < M; i++) {
			if (temp != find(parents[path[i]-1])) {
				check = false;
				break;
			}
		}
		if(check)
			System.out.println("YES");
		else
			System.out.println("NO");
	}

	private static void makeSet() {
		for (int i = 0; i < N; i++) {
			parents[i] = i;
		}
	}

	private static void union(int a, int b) {
		a = find(parents[a]);
		b = find(parents[b]);

		if (a == b)
			return;
		if (rank[a] < rank[b]) {
			parents[a] = b;
		} else {
			parents[b] = a;
			if (rank[a] == rank[b]) {
				rank[a]++;
			}
		}

	}

	private static int find(int a) {
		if (parents[a] == a)
			return a;
		return parents[a] = find(parents[a]);

	}
}
