package BRONZE;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_13458_시험감독_re {
	public static void main(String[] args)throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		int N = Integer.parseInt(br.readLine());
		int [] An = new int [N];
		int B, C;
		
		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < N; i++) {
			An[i] = Integer.parseInt(st.nextToken());
		}

		st = new StringTokenizer(br.readLine()," ");
		B = Integer.parseInt(st.nextToken()); // 총감독 감시 수
		C = Integer.parseInt(st.nextToken()); // 부감독 감시 수		

		System.out.print(findMinSupervisor(An, N, B, C));
	}
	static long findMinSupervisor(int [] An, int N, int B, int C) {
		long ans = N;
		
		//총감독은 무조건 포함이다.
		for (int i = 0; i < N; i++) {
			//총감독을 1명 넣는다.
			An[i] -=B;
			//부감독을 넣는다.
			if(An[i]>0) {
				int sub = An[i]/C;
				ans +=sub;
				//1명 더 필요할 때
				if(C*sub < An[i]) 
					ans++;
			}
		}
		return ans;
	}
}
