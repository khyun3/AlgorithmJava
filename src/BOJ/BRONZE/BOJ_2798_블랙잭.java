package BOJ.BRONZE;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2798_블랙잭 {
//조합문제
	static int N, M, answer=0, atmp=0;
	static int[] num;
	static int[] numbers;//뽑은카드
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());	//R
		
		st = new StringTokenizer(br.readLine());
		num = new int[N];
		for (int i = 0; i < N; i++) {
			num[i] = Integer.parseInt(st.nextToken());
		}
		
		numbers = new int[3];	//뽑은카드
		
		nCr(0,0);
		System.out.println(answer);
	}
	private static void nCr(int cnt, int start) {
		if(cnt == 3) {
			atmp = 0;
			for (int i : numbers) {
				atmp +=i;
			}
			if(atmp>answer && atmp<=M) answer = atmp;			
			return;
		}
		for (int i = start; i < N; i++) {
			numbers[cnt] = num[i];
			nCr(cnt+1,i+1);
		}
	}
}
