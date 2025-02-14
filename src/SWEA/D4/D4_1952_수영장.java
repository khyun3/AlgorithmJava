package SWEA.D4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class D4_1952_수영장 {
	public static void main(String[] args)throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		
		int [] price = new int [4]; //1일권, 1달권, 3달권, 1년권
		int [] calendar = new int [13];
		int [] month = new int [13];
		int [] d = new int [13];
		
		for (int t = 1; t <= T; t++) {
			st = new StringTokenizer(br.readLine()," ");			
			int i=0;
			//가격 정보 입력
			while(st.hasMoreTokens()) price[i++] = Integer.parseInt(st.nextToken());
			st = new StringTokenizer(br.readLine()," ");
			
			i=1;
			//월 정보 입력
			while(st.hasMoreTokens()) calendar[i++] = Integer.parseInt(st.nextToken());
			//1일 vs 1달 
			for (int j = 1; j < 13; j++) {
				month[j] = Math.min(price[0]*calendar[j], price[1]);
			}
			//위 1일,1달 비교 값 vs 3달
			for (int j = 1; j < 13; j++) {
				d[j] = d[j-1] + month[j];
				if(j-3>=0) {
					d[j] = Math.min(d[j-3]+price[2], d[j]);
				}
			}
			
			d[12] = Math.min(d[12], price[3]); //1년권 
			sb.append("#").append(t).append(" ").append(d[12]).append("\n");
		}
		System.out.print(sb);
	}
}