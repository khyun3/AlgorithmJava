package D3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class D3_9229_한빈이와SpotMart {
	private static int T,N,M,answer, temp = 0;
	private static int [] a;
	private static int [] numbers = new int[2];
	public static void main(String[] args)throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		T = Integer.parseInt(br.readLine().trim());
		
		for (int t = 1; t <= T; t++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			a = new int[N];
			answer = -1;
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) { 
				a[i] = Integer.parseInt(st.nextToken());
			}
			nCr(0,0);
			System.out.println("#"+t+" "+answer);
		}
	}
	private static void nCr(int cnt, int start) {
		if(cnt == 2) {
			if(numbers[0]+numbers[1] <= M) {
				temp = numbers[0]+numbers[1];
				if(answer<temp) answer = temp;
			}
			return;
		}
		for (int i = start; i < N; i++) {
			numbers[cnt] = a[i];
			nCr(cnt+1,i+1);
		}
	}
}