package BOJ.BRONZE;

import java.util.Scanner;

public class BOJ_1259_팰린드롬수 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		while(true) {
			
			int num = sc.nextInt();
			if(num == 0) break;
			
			char [] arr = Integer.toString(num).toCharArray();
			
			int first = 0;
			int last = arr.length-1;
			boolean check = true;
			
			for (int i = 0; i <arr.length/2; i++) {
				if(arr[first]!=arr[last]) {
					check = false;
					break;
				}
				first++;
				last--;
			}
			
			if(check)sb.append("yes").append("\n");
			else sb.append("no").append("\n");
		}
		System.out.println(sb.toString());
	}
}