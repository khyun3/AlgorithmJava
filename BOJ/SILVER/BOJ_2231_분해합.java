package SILVER;

import java.util.Scanner;

public class BOJ_2231_분해합 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int k = 0;
		if(N>1000) k=N-1000;
		for (int i = k; i < N; i++) {
			char [] nstr = Integer.toString(i).toCharArray();
			int tmp = i;
			
			for (int j = 0; j < nstr.length; j++) {
				tmp+=Integer.parseInt(Character.toString(nstr[j]));
			}
			if(tmp==N) {
				System.out.println(i);
				return;
			}
			else if(i==N-1) {
				System.out.println(0);
				return;
			}
		}
	}
}