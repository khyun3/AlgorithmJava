package BOJ.SILVER;

import java.util.Scanner;

public class BOJ_9655_돌게임 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		if(n%2==0) System.out.println("CY");
		else System.out.println("SK");
	}
}
