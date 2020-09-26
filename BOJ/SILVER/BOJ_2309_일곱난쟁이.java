package SILVER;

import java.util.Arrays;
import java.util.Scanner;

public class BOJ_2309_일곱난쟁이 {
	
	static int [] m = new int [9];
	static int [] select = new int [7];
	static boolean stop;
	static boolean [] isSelected = new boolean [9];
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		for (int i = 0; i < 9; i++) {
			m[i] = sc.nextInt();
		}
		
		ncr(0,0,0);
	}
	private static void ncr(int cnt, int start, int sum) {
		if(stop) return;
		
		if(cnt==7) {
			if(sum == 100) {
				stop = true;
				Arrays.sort(select);
				for (int i = 0; i < 7; i++) {
					System.out.println(select[i]);
				}
			}
			return;
		}
		
		for (int i = start; i < 9; i++) {
				select[cnt] = m[i];
				ncr(cnt+1, i+1, sum+m[i]);
		}
	}
}
