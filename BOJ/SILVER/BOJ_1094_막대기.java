package SILVER;

import java.util.Scanner;

public class BOJ_1094_막대기 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int X = sc.nextInt();
		//X를 2진수로 변경 했을 때 64자리까지 몇개의 1이 있는가?
		int cnt = 0;
		char [] xStr = Integer.toBinaryString(X).toCharArray();
		
		for (char c : xStr) {
			if(c=='1') cnt++;
		}
		System.out.println(cnt);
	}
}
