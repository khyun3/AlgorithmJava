package BOJ.SILVER;

import java.util.Scanner;

public class BOJ_10974_모든순열_nPr {
	static int N;
	static boolean [] isSelected;
	static int [] numbers;
	static StringBuilder sb;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		isSelected = new boolean[N];
		numbers = new int[N];
		nPr(N,0);
	}
	private static void nPr(int n, int cnt) {
		if(cnt==n) {
			sb = new StringBuilder();
			
			for (int i = 0; i < N; i++) {
				sb.append(numbers[i]).append(" ");
			}
			
			System.out.println(sb.toString());
			return;
		}
		for (int i = 0; i < N; i++) {
			if(isSelected[i]) continue;
			numbers[cnt] = i+1;
			isSelected[i] = true;
			nPr(n, cnt+1);
			isSelected[i] = false;
		}
	}
}
