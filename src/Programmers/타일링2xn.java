package Programmers;

import java.util.Arrays;

public class 타일링2xn {
	static long d[];
	public static void main(String[] args) {
		int n = 1;
		
			d = new long[4+1];
			d[1] = 1L;
			d[2] = 2L;
			System.out.println(solution(4));
		System.out.println(Arrays.toString(d));
		
		
	}
	static public int solution(int n) {
		int answer = 0;
		answer = (int)fibo(n);
		return answer;
	}
	static public long fibo(int n) {
		
		if(n <=1) return n;
		if(d[n]!=0) return d[n];
		else {
			d[n] = (fibo(n-1) + fibo(n-2))%1000000007;
			return d[n];
		}
	}
	
}
