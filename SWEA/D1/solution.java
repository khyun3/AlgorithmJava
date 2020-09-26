package D1;

import java.util.Scanner;

public class solution {
	public static void main(String args[])throws Exception{
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		for(int i=0; i<=a; i++)
			System.out.print((int)Math.pow(2, i)+" ");
	}
}