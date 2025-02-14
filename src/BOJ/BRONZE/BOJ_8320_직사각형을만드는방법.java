package BOJ.BRONZE;

import java.util.Scanner;

public class BOJ_8320_직사각형을만드는방법 {
	static int N, answer;
	static boolean sCheck;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();

		answer = 0;
		for (int i = 1; i <= N; i++) {
			for (int j = i; j * i <= N; j++) {
				answer++;
			}
		}
		System.out.println(answer);
	}
}
