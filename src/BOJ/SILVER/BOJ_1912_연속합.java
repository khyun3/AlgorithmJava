package BOJ.SILVER;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1912_연속합 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int N = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine()," ");
		
		int sum = 0;
		int max = -Integer.MAX_VALUE;
		
		for (int i = 0; i <N; i++) {
			sum += Integer.parseInt(st.nextToken());
			
			//sum이 0보다 작아지면 0으로 초기화 
			if(sum<0) {
				max = Math.max(max, sum);
				sum = 0;
			}
			else {
				max = Math.max(max, sum);
			}
		}
		System.out.println(max);
	}
}