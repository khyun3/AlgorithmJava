package BOJ.SILVER;

import java.util.Scanner;

public class BOJ_1676_팩토리얼_0의_개수 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		final long  P = 1000000000L;
		int N = sc.nextInt();
		long fact = 1;
		int cnt = 0;
		
		for (int i = 1; i <= N; i++) {
			fact = (fact%P * i)%P;
			while (true) {
				if (fact % 10 == 0) {
					cnt++;
					fact /= 10;
				} else
					break;
			}
		}
		System.out.println(cnt);
	}
}