package BOJ.GOLD;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_11404_플로이드 {
	static final int INF = 10000001;
	public static void main(String[] args)throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine()); //정점 수
		int m = Integer.parseInt(br.readLine()); //간선 수
		StringTokenizer st = null;
		
		int [][] d = new int[N][N];
		int start,dest, weight; //출발, 도착, 가중치
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if(i==j) d[i][j] = 0;
				else d[i][j] = INF;
			}
		}
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			start = Integer.parseInt(st.nextToken())-1;
			dest = Integer.parseInt(st.nextToken())-1;
			weight = Integer.parseInt(st.nextToken());
			d[start][dest] = Math.min(d[start][dest], weight);
		}
		fw(d, N);
		print(d,N);
	}

	private static void print(int[][] d,int N) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if(d[i][j]>=10000001) d[i][j] = 0;
				sb.append(d[i][j]).append(" ");
			}
			sb.append('\n');
		}
		System.out.print(sb);
	}

	private static void fw(int[][] d, int N) {
		
		for (int k = 0; k <N ; k++) {//경
			for (int i = 0; i < N; i++) {//출
				for (int j = 0; j < N; j++) {//도
						d[i][j] = Math.min(d[i][j], d[i][k]+d[k][j]);
				}
			}
		}
	}
}