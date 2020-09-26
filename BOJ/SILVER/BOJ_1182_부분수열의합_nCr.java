package SILVER;

import java.util.Scanner;

public class BOJ_1182_부분수열의합_nCr {
	//nCr
	static int N, S, answer;
	static int [] input;
	static int [] numbers;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		S = sc.nextInt();
		
		input = new int[N]; 
		
		for (int i = 0; i < N; i++) {
			input[i] = sc.nextInt();
		}
		
		//nC1, nC2 ... nCn까지
		for (int i = 1; i <= N; i++) {	//전부 실행하면 부분집합에서 공집합을 뺀것과 같다.
			numbers = new int[i];
			nCr(N, i, 0,0);
		}

		System.out.println(answer);
	}
	private static void nCr(int n, int r, int cnt, int start) {
		//기저
		if(cnt == r) {
			int tmp = 0;
			for (int i = 0; i < r; i++) {	//뽑은 애들을 다 더한다.
				tmp+=numbers[i];
			}
			if(tmp == S) answer++;			//뽑은 애들과 S와 같은지 확인
			//System.out.println("R = "+ r +" "+Arrays.toString(numbers));
			return;
		}
		
		for (int i = start; i < N; i++) {
			numbers[cnt] = input[i];
			nCr(n,r,cnt+1,i+1);
		}
	}
}