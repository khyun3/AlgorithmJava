package SWEA.D2;

import java.util.Scanner;

public class D2_1970_쉬운거스름돈 {
	private static int T, N;
	private static int [] won = {50000,10000,5000,1000,500,100,50,10};
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		T = sc.nextInt();
		
		for (int t = 1; t <= T; t++) {
			N = sc.nextInt();
			sb.append("#"+t+"\n");
			for (int i = 0; i < won.length; i++) {
				sb.append(N/won[i]+" ");
				N = N%won[i];
			}
			System.out.println(sb);
			sb.delete(0,sb.length());
		}
		sc.close();
	}
}
