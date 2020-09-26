package BRONZE;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_9093_단어뒤집기 {
	public static void main(String[] args)throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb;
		int N = Integer.parseInt(br.readLine());


		for (int n = 0; n < N; n++) {
			sb = new StringBuilder();
			st = new StringTokenizer(br.readLine());
			
			while(st.hasMoreTokens()) {
				char [] subStr = st.nextToken().toCharArray();
				for (int i = subStr.length-1; i>=0 ; i--) {
					sb.append(subStr[i]);
				}
				sb.append(' ');
			}	
			System.out.print(sb);
		}
		
	}
}
