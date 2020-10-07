package SILVER;

import java.util.Scanner;

public class BOJ_11727_2xN타일링2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		//2 x an +1 (짝수일 때)
		//2 x an -1 (홀수일 때)
		
		long an=0;
		for (int i = 0; i <= N; i++) {
			if(i%2==0) an = (2*an+1)%10007L;
			else an = (2*an-1)%10007L;
		}
		System.out.println(an);
	}
}