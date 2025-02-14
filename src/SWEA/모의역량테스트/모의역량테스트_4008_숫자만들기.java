package SWEA.모의역량테스트;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 모의역량테스트_4008_숫자만들기 {
	static int N, number[], oper[], max, min;
	public static void main(String[] args)throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		
		for (int t = 1; t <= T; t++) {
			N = Integer.parseInt(br.readLine());
			number = new int [N];
			oper= new int [4];
			min = Integer.MAX_VALUE;
			max = -Integer.MAX_VALUE;
			st = new StringTokenizer(br.readLine()," ");
			for (int i = 0; i < 4; i++) {
				oper[i] = Integer.parseInt(st.nextToken());
			}
			st = new StringTokenizer(br.readLine()," ");
			for (int i = 0; i < N; i++) {
				number[i] = Integer.parseInt(st.nextToken());
			}
			nCr(1,0,0,0,0,number[0]);
			sb.append('#').append(t).append(" ").append(max-min).append('\n');
		}
		System.out.print(sb);
	}
	private static void nCr(int cnt, int p, int m, int t, int d, int sum) {
		if(cnt==N) {
			max = Math.max(max, sum);
			min = Math.min(min, sum);
			return;
		}
		if(oper[0]>p) nCr(cnt+1, p+1,m,t,d,sum+number[cnt]);
		if(oper[1]>m) nCr(cnt+1, p,m+1,t,d,sum-number[cnt]);
		if(oper[2]>t) nCr(cnt+1, p,m,t+1,d,sum*number[cnt]);
		if(oper[3]>d) nCr(cnt+1, p,m,t,d+1,sum/number[cnt]);
	}
}