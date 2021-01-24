package BRONZE;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class BOJ_13458_시험감독 {
	public static void main(String[] args)throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		int N = Integer.parseInt(br.readLine());
		HashMap<Integer, Integer> An = new HashMap<>();
		int B, C;
		
		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < N; i++) {
			int n = Integer.parseInt(st.nextToken());
			
			An.put(n, An.containsKey(n) ? An.get(n)+1 : 1);
		}

		st = new StringTokenizer(br.readLine()," ");
		B = Integer.parseInt(st.nextToken()); // 총감독 감시 수
		C = Integer.parseInt(st.nextToken()); // 부감독 감시 수		
		
		System.out.print(findMinSupervisor(An, N, B, C));
	}
	static long findMinSupervisor(HashMap<Integer, Integer> An, int N, int B, int C) {
		long ans = N;
		 for( HashMap.Entry<Integer, Integer> el : An.entrySet()) {
			 int key = el.getKey()-B;
			 int cnt = el.getValue();

			 if(key>0) {
				 long tmp = key/C;
				 if(tmp*C < key) {
					 tmp++;
				 }
				 ans += tmp * cnt;
			 }
	     }
		return ans;
	}
}
