package BOJ.SILVER;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BOJ_2164_카드2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		
		Queue<Integer> que = new LinkedList<Integer>();
		for (int i = 1; i <= N; i++) {
			que.offer(i);
		}
		while(--N!=0) {
			que.poll(); //맨위 버리기
			que.offer(que.poll()); //맨위 뒤로
		}
		System.out.println(que.poll());
		sc.close();
	}
}