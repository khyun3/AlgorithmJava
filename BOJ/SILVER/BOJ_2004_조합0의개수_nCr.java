package SILVER;

import java.util.Scanner;

public class BOJ_2004_조합0의개수_nCr {
	//ncr필요한거
	static int N,R; 
	static long answer;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		R = sc.nextInt();
		answer = findZeroCnt(nCr(N, R));
		System.out.println(answer);
	}

	private static long findZeroCnt(long res) {
		long cnt = 0L;
		String tmp = ""+res;
		for (int i = tmp.length()-1; i>=0; i--) {
			if(tmp.charAt(i) == '0') {
				cnt++;
			}
			else
				return cnt;
		}
		return cnt;
	}
	//n!/r!(n-r)!
	private static long nCr(int n, int r) {
		long nf=1L, nr=1L, res=0;
		for (long i = n; i>r; i--) {	//   n!/r!
			nf*=i;								
		}
		for (long i = n-r; i>0; i--) {	//	 (n-r)!
			nr*=i;
		}
		res = nf/nr; //zero
		
		return res;
	}
}