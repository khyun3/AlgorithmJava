package D3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class D3_1225_암호생성기 {
	private static int T;
	private static int N = 8;
	private static int [] arr = new int[N];
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		for (int t = 1; t <= 10; t++) {
			T = Integer.parseInt(br.readLine());
			int temp = 0; 
			int min = 100000;
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < arr.length; j++) {
				arr[j] = Integer.parseInt(st.nextToken());
				temp = arr[j]/120;
				if(min > temp) min = temp;
			}
			for (int i = 0; i <N; i++) {
				arr[i] -= 120*min;
			}
			
			a:while(true) {
				for (int j = 1; j <= 5; j++) {
					arr[0] = arr[0]-j;
					temp =  arr[0];
					
					for(int k = 0; k<N-1; k++) {
						arr[k] = arr[k+1];
					}
					arr[N-1] = temp;
					if(arr[N-1] <=0) {
						arr[N-1] = 0;
						break a;
					}
				}
			}
			System.out.print("#"+t+" ");
			for (int i = 0; i < arr.length; i++) {
				System.out.print(arr[i]+" ");
			}
			System.out.println();
		}
	}
}