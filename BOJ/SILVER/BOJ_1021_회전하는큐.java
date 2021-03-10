package SILVER;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class BOJ_1021_회전하는큐 {
	static int N, M;
	public static void main(String[] args)throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		LinkedList<Integer> dq = new LinkedList<>();
		
		for (int i = 1; i <= N; i++) {
			dq.offer(i);
		}
		//찾아야하는 순서
		st = new StringTokenizer(br.readLine()," ");
		int ans = 0;
		//찾기 시작
		while(st.hasMoreTokens()) {
			int num = Integer.parseInt(st.nextToken());
			int left = dq.indexOf(num)+1;
			int right = Math.abs(left-N);
			
			System.out.println("left : "+left + "  right : "+right);

			if(left<=right) {
				//왼쪽으로 돌려야 할 때,
				for (int i = 1; i < left; i++) {
					dq.offerLast(dq.pollFirst());
				}
			}
			else {
				for (int i =0; i <= right; i++) {
					dq.offerFirst(dq.pollLast());
				}
			}
			System.out.println("삭제 전 : "+dq.toString());
			dq.poll();
			N--;
			ans +=Math.min(left, right);
			System.out.println("삭제 후 : "+dq.toString()+"    " + ans+"\n");
		}
	}
}
