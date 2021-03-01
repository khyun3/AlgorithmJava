package SILVER;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1010_다리놓기 {
	public static void main(String[] args)throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		int N,M;
		
		for (int t = 0; t < T; t++) {
			st = new StringTokenizer(br.readLine()," ");
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			
			//nCr = n!/r!(n-r)!
			sb.append(nCr(M,N));			
			sb.append("\n");
		}
		System.out.print(sb);
	}
	static long nCr(int n, int r) {
		int x,y = 0;
		long a=1,b=1;
		
		if(r > n-r) {
			x = r;
			y = n-r;
		}
		else {
			x = n-r;
			y = r;
		}
		
		for (int i = n; i > x; i--) {
			a*=i;
		}
		for (int i = 2; i <= y; i++) {
			b*=i;
		}
		return a/b;
	}
}
