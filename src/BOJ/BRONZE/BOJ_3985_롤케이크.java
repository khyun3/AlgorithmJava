package BOJ.BRONZE;

import java.util.Arrays;
import java.util.Scanner;

public class BOJ_3985_롤케이크 {
	static int L, N;
	static int [] cake;
	static int pMax=0, rMax=0;
	static int pPerson, rPerson;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		L = sc.nextInt();
		N = sc.nextInt();
		
		cake = new int[L];
		
		for (int i = 0; i < N; i++) {
			int P = sc.nextInt();
			int K = sc.nextInt();
			int tmp=0;
			if((K-P)>pMax) {
				pPerson = i+1;
				pMax = K-P;
			}
			
			for (int j = P; j <=K ; j++) {
				if(cake[j-1] !=0) {
					continue;
				}else {
					cake[j-1] = i+1;
					tmp++;
				}
				System.out.println(Arrays.toString(cake));
			}
			
			if(tmp>rMax) {
				rPerson = i+1;
				rMax = tmp;
			}
		}
		System.out.println(pPerson);
		System.out.println(rPerson);
	}
}