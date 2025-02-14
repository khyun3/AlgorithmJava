package BOJ.SILVER;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BOJ_2635_수이어가기 {
	static int max=0;
	static List<Integer> list = new ArrayList<>();
	static List<Integer> ans = new ArrayList<>();
	public static void main(String[] args) {
		StringBuilder sb = new StringBuilder();
		Scanner sc = new Scanner(System.in);
		int N;
		N = sc.nextInt();
		if(N == 1) {System.out.println("4\n1 1 0 1");
		return;
		}
		for (int i = N/2; i < N; i++) {
			list.clear();
			list.add(N);
			recur(N, i, 0, 1); //1,2,3항,개수
		}
		sb.append(max).append("\n");
		for (int i : ans) {
			sb.append(i).append(" ");
		}
		System.out.println(sb);
	}
	private static void recur(int n, int n2, int n3, int cnt) {
		
		if(n2<0) {
			if(max<cnt) {
				ans.clear();
				max= cnt;
				ans.addAll(list);
			}
			return;
		}
		n3 = n-n2;
		list.add(n2);
		recur(n2, n3, 0, cnt+1);
	}
}