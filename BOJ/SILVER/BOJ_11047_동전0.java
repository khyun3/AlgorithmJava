package SILVER;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_11047_동전0 {
	static int N,K, min=Integer.MAX_VALUE;
	static int coin[];
	
	public static void main(String[] args)throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		coin = new int[N];
		for (int i = 0; i < N; i++) {
			coin[i] = Integer.parseInt(br.readLine());
		}
		
		dfs(0, K);
		System.out.println(min);
	}

	private static void dfs( int cnt, int res) {
		if(res==0) {
			min = Math.min(min, cnt);
			return;
		}
		if(res<0) return;
		
		for (int i = 0; i < N; i++) {
			if(res<coin[i]) break;
			dfs(cnt+res/coin[i], res - coin[i]*(res/coin[i]));
		}
	}
}