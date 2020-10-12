package SILVER;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_18310_안테나 {
	public static void main(String[] args)throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		int [] houses = new int [2000001];
		int max = 0;
		int min = Integer.MAX_VALUE;
		int mid = 0;
		
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		
		while(st.hasMoreTokens()) {
			int tmp = Integer.parseInt(st.nextToken());
			houses[tmp]++;
			max = Math.max(max, tmp);
			min = Math.min(min, tmp);
		}
		print(houses);
		
		mid = (max+min)/2;
		
		//오른쪽
		while(true) {
			
		}
		//왼쪽
		while(true) {
			
		}
	}

	private static void print(int [] a) {
		for (int i = 0; i < a.length; i++) {
			if(a[i] !=0) {
				System.out.print(i+" ");
			}
		}
		System.out.println();
		for (int i = 0; i < a.length; i++) {
			if(a[i] !=0) {
				System.out.print(a[i]+" ");
			}
		}
		System.out.println();

	}
}
