package SWEA.D4;

import java.util.Scanner;

public class D4_4301_콩많이심기 {
	static int T, N, M;
	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);		
		T = sc.nextInt();
		for (int t = 1; t <= T; t++) {
			N = sc.nextInt();
			M = sc.nextInt();
			
			int cnt = 0;
			for (int i = 0; i < M; i++) {
				for (int j = 0; j < N; j++) {
					if(i%4<2 && j%4<2) {
							cnt++;
					}
					else if(2<=i%4 && 2<=j%4) {
						cnt++;
					}
				}
			}
			System.out.println("#"+t+" "+cnt);
		}
	}
}