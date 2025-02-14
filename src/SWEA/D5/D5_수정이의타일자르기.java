package SWEA.D5;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class D5_수정이의타일자르기 {
	static int N,M,answer;
	public static void main(String[] args)throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		
		for (int t = 1; t <= T; t++) {
			answer = 0;
			//N과 M을 입력받는다.
			st = new StringTokenizer(br.readLine()," ");
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			int [] tile = new int [33];
			
			//N개만큼 2^s의 값을 입력받음(수정이가 필요한 타일의 크기들)
			st = new StringTokenizer(br.readLine()," ");
		
			for (int i = 0; i < N; i++) {
				int k = Integer.parseInt(st.nextToken());
				tile[k]++;
			}
			
			
			sb.append("#").append(t).append(" ").append(answer).append("\n");
		}
	}
}
