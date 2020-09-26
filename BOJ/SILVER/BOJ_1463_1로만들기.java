package SILVER;

import java.util.Scanner;

public class BOJ_1463_1로만들기 {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int [] D = new int[N+1]; 
		
		D[0] = 0;
		D[1] = 0; //1일 때는 연산 x
		for (int i = 2; i <= N; i++) {
			int A = Integer.MAX_VALUE;
			int B = Integer.MAX_VALUE;
			
			if(i%3==0) B = D[i/3]+1;		//  /3
			else if(i%2==0) B = D[i/2]+1;	//  /2
			A = D[i-1]+1;					//  -1
				
			D[i] = Math.min(A, B);
		}
		System.out.println(D[N]);
	}
}
