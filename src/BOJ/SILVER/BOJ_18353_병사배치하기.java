package BOJ.SILVER;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_18353_병사배치하기 {
	public static void main(String[] args)throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		
		int [] arr = new int [N];
		int [] dp = new int [N];
		int max = 0;
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			dp[i] = 1;
			
			for (int j = 0; j < i; j++) {
				if(arr[j]>arr[i]) {
					dp[i] = Math.max(dp[j]+1, dp[i]);
				}
			}
			max = Math.max(max, dp[i]);
		}
		System.out.println(N-max);
	}
}