package SWEA.D3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class D3_3499_퍼펙트셔플 {
	static int T, N;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		T = Integer.parseInt(br.readLine().trim());		
		for (int t = 1; t <= T; t++) {
			StringBuilder sb = new StringBuilder();
            sb.append("#"+t+" ");
			N = Integer.parseInt(br.readLine());
			int p = 0, q = 0;
			String [] Left = new String[(N+1)/2];
			String [] Right =new String[N/2];
			
			st = new StringTokenizer(br.readLine());
			//카드를 입력 받는다.
			for (int i = 0; i < N; i++) {
				if((N+1)/2 > i) {
					Left[i] = st.nextToken();
				}
				else {
					Right[p] = st.nextToken();
					p++;
				}
			}
			p = 0;
			for (int i = 0; i < N; i++) {
				if(i%2 == 0) {
					sb.append(Left[p]+" ");
					p++;
				}
				else if(i%2 == 1){
					sb.append(Right[q]+" ");
					q++;
				}
			}
			System.out.println(sb.toString());
		}
	}
}