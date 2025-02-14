package BOJ.SILVER;

import java.util.Scanner;

public class BOJ_1436_영화감독숌 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int cnt = 1;
		int num = 666;
		
		String tmp;
		while(true) {
			
			if(cnt==N) {
				System.out.println(num);
				break;
			}
			
			num +=1;
			tmp = Integer.toString(num);
			if (tmp.contains("666")) {
				cnt++;
			}
		}
	}
}