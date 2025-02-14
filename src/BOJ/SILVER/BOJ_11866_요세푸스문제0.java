package BOJ.SILVER;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BOJ_11866_요세푸스문제0 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		int N = sc.nextInt();
		int K = sc.nextInt();
		
		Queue<Integer> que = new LinkedList<>();
		
		//que에 순서대로 넣는다.
		for (int i = 1; i <= N; i++) {
			que.offer(i);
		}
		sb.append("<");
		
		int j = 0;
		while(!que.isEmpty()) {
			if(j==K-1) {
				sb.append(que.poll()).append(", ");
				j=0;
				continue;
			}
			else que.offer(que.poll());
			j++;
		}
		System.out.println(sb.replace(sb.length()-2, sb.length()-1, ">"));
		sc.close();
	}
}
