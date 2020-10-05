package SILVER;

import java.util.Scanner;

public class BOJ_9461_파도반수열 {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		//1 1 1 2 2 3 4 5 7 9 12...
		//an = an-5 + an-1 (단, n>5)
		long [] pdv = new long [100];
		
		for (int i = 0; i < 100; i++) {
			if(i<=2) 	 pdv[i] = 1; //1,2,3항
			else if(i<=4)pdv[i] = 2; //4,5항
			else
				pdv[i] = pdv[i-5]+pdv[i-1]; //6항부터
		}
		
		int T = sc.nextInt();
		for (int t = 0; t < T; t++) {
			int N = sc.nextInt();
			System.out.println(pdv[N-1]);
		}
	}
}