package BOJ.SILVER;

import java.util.Scanner;

public class BOJ_9095_123더하기 {
	static int T,cnt, N;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		
		T = sc.nextInt();
		for (int t = 0; t < T; t++) {
			N = sc.nextInt(); 
			cnt = 0;
			recur(0, 0);
			System.out.println(cnt);
		}
	}
	private static void recur(int n, int sum) {
		
		if(sum>N) return;
		
		if(sum==N) {
			cnt++;
			return;
		}	
		//1
		recur(1,sum+1);
		//2
		recur(2,sum+2);
		//3
		recur(3,sum+3);
	}
}