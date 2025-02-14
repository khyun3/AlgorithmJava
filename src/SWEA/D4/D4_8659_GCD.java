package SWEA.D4;

import java.util.Scanner;

public class D4_8659_GCD {
	static int T, K;
	public static void main(String[] args)throws Exception {
		Scanner sc = new Scanner(System.in);
		long [] fibo = new long [93];
		fibo[0] = 0;
		fibo[1] = 1;
		T = sc.nextInt();
		for (int i = 2; i < fibo.length; i++) {
			fibo[i] = fibo[i-1] + fibo[i-2];
		}
		for (int t = 1; t <=T; t++) {
			K = sc.nextInt();
			System.out.println("#"+t+" "+fibo[K+2]+" "+fibo[K+1]);
		}
	}
}
