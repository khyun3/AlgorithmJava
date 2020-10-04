package SILVER;

import java.util.Scanner;

public class BOJ_11726_2xN타일링 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		final int P = 10007;
		
		int N = sc.nextInt();
		//2x1=1, 2x2=2, 2x3=3, 2x4=5, 2x5=8....
		
		int [] tail = new int[N+1];
		tail[0] = 1;
		tail[1] = 1;
		for (int i = 2; i <= N; i++) {
			tail[i] = ((tail[i-1])%P+tail[i-2]%P)%P;
		}
		System.out.println(tail[N]);
		sc.close();
	}
}
