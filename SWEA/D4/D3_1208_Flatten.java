package D4;

import java.util.Arrays;
import java.util.Scanner;

public class D3_1208_Flatten {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T, dump;
		T = sc.nextInt();
		int [] nArr = new int[100];
		for (int t = 1; t <= T; t++) {
			//덤프 횟수 입력받음 
			dump = sc.nextInt();
			
			//100개의 배열의 높이를 입력받음
			for (int i = 0; i < nArr.length; i++) {
				nArr[i] = sc.nextInt();
			}
			Arrays.sort(nArr);
			
			for (int j = 0; j < dump; j++) {
				nArr[0]++;
				nArr[99]--;
				//매번 최소와 최대를 찾는다. 즉, sort를 반복적으로 해야한다?
				Arrays.sort(nArr);
			}
		System.out.println("#"+t+" "+(nArr[99]-nArr[0]));	
		}
		sc.close();
	}
}
