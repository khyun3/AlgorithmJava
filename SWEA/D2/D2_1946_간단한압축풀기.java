package D2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class D2_1946_간단한압축풀기 {
	static int T, N;
	static int [][] str;
	public static void main(String[] args)throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		StringBuilder sb;
		
		T = Integer.parseInt(br.readLine());
		
		for (int t = 1; t <= T; t++) {
			sb = new StringBuilder();
			N = Integer.parseInt(br.readLine());
			sb.append("#").append(t).append("\n");
			int cnt = 0;
			int ntmp = N;

			for (int i = 0; i < N; i++) {
				
			st =new StringTokenizer(br.readLine());
			char alpa = st.nextToken().charAt(0);
			int num = Integer.parseInt(st.nextToken());
			
				while(true) {
					if(num-- != 0) {
						sb.append(alpa);
						cnt++;
					}
					else
						break;
					if(cnt!=0 && cnt%10 == 0) {
						sb.append("\n");
					}
				}
					if(--ntmp == 0) {
						System.out.println(sb.toString());
						ntmp = N;
				}
			}
		}
	}
}