package GOLD;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ_4811_알약 {
	static long d[] = new long [31];
	public static void main(String[] args)throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int in = -1;
		
		catalan();
		while(true) {
			in = Integer.parseInt(br.readLine());
			if(in == 0) break;
			sb.append(d[in-1]).append('\n');
		}
		System.out.print(sb);
	}
	private static void catalan() {
		d[0] = 1;
		for (int n = 1; n < 31; n++) {
			d[n] = (4*n+2) * d[n-1] /(n+2);
		}
	}
}