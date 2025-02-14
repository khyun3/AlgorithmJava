package BOJ.SILVER;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_1015_수열정렬 {
	static class A implements Comparable<A>{
		int idx;
		int num;
		
		@Override
		public int compareTo(A o) {
			if(this.num == o.num) return Integer.compare(this.idx,o.idx);
			else return Integer.compare(this.num,o.num);
		}
		public A(int idx, int num) {
			this.idx = idx;
			this.num = num;
		}
	} 
	public static void main(String[] args)throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		PriorityQueue<A> Arr = new PriorityQueue<>();
		for (int i = 0; i < N; i++) {
			Arr.offer(new A(i, Integer.parseInt(st.nextToken())));
		}
		
		int P[] = new int [N];
		for (int i = 0; i < N; i++) {
			A tmp= Arr.poll();
			P[tmp.idx] = i; 
		}
		//정렬된 배열   | Aidx |  P   |  Bidx |
		//B[0] = 1 |  2   | P[2] |   0   |
		//B[1] = 2 |  0   | P[0] |   1   |
		//B[2] = 3 |  1   | P[1] |   2   |
		
		for (int i = 0; i < N; i++) {
			sb.append(P[i]).append(" ");
		}
		System.out.print(sb);
	}
}