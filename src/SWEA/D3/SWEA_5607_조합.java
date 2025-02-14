package SWEA.D3;

import java.util.Scanner;

public class SWEA_5607_조합 {
	//페르마의 소정리
	//p가 소수이고  a가 p로 나누어지지 않으면,
	//a^(p-1) = 1(mod p)이다.  == a^(p-1)을 p로 나눈 나머지가 1이다.
	
	static final long P = 1234567891L; //소수
	public static void main(String[] args) {
		long answer = 0;
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		for (int t = 1; t <= T; t++) {
			int N = sc.nextInt(); //1<= N <= 1000000
			int R = sc.nextInt(); //0<= R <= N
			
			//nCr => n!/r!(n-r)!
			//A = n!,  B = r!(n-r)!이라 하자
			//A*B^-1를 구하면 된다. 
			
			//페르마의 소정리를 사용하여 분수를 나머지 연산할 수 있도록 바꾸자
			//B^(p-1) = 1(mod P)
			//=B*B^(p-2) = 1(mod P)
			//=B^(p-2) = B^-1(mod P)
			
			//따라서 우리는  AB^-1 % P를 다음과 같이 쓸 수 있다.
			
			//AB^-1%p  = AB^(p-2)%P 
			//=(A%P)(B^(p-2)%P)%P <<최종 식ㅋㅋㅋㅋㅋㅋ
			
			//=========================================
			//A구하기
			long A = 1;
			for (int i = 1; i <= N; i++) { // N!(mod P)
				A *=i;
				A %=P;
			}
			//B구하기
			long B = 1;
			for (int i = 1; i <= R; i++) { // R!(mod P)
				B *=i;
				B %=P;
			}
			//R!(N-R)!구하기
			for (int i = 1; i <= N-R; i++) {//(N-R)!(mod P) * R!
				B *=i;
				B %=P;
			}
			
											   //B^(p-2)(mod P) 구하기. p는 1234567891
			System.out.println("#"+t+" "+(A * sq(B, P-2))%P);
			
		}
	}
	
	private static long sq(long B, long p) {
		if(p==0) { 
			return 1;
		}
		if(p%2 == 1) {//홀수
			return (sq(B, p-1) *B) % P;
		}
		long half = sq(B, p/2) % P;
		return (half*half) %P;
	}
}