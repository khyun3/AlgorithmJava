package GOLD;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_7662_이중우선순위큐_fail {
	static int T, N;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		PriorityQueue<Long> dPQMax;
		PriorityQueue<Long> dPQMin;
		
		T = Integer.parseInt(br.readLine());
		
		for (int t = 0; t < T; t++) {
			dPQMax = new PriorityQueue<>();
			dPQMin = new PriorityQueue<>();
			
			N = Integer.parseInt(br.readLine());
			
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine()," ");
				char ch = st.nextToken().charAt(0);
				
				if(ch=='D') {
					long num = Long.parseLong(st.nextToken());

					if(!dPQMax.isEmpty() && num==1) { //num이 0보다 작으면 최소값 삭제
						dPQMax.poll();
					}
					else if(!dPQMax.isEmpty() && num==-1) {
						dPQMin.poll();
					}
				}
				else {
					long num = Long.parseLong(st.nextToken());
					dPQMin.offer(num);
				}
			}
		}
	}
}