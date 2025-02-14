package SWEA.D3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class D3_10200_구독자전쟁 {
	
	//채널 P,T 중복 구독자 최대값 : a or b중에 작은 수
	//채널 P,T 중복 구독자 최소값 : 총인원 - a+b = -값이면 해당 값의 절대 값, +값이면 0명
	static int T, N, PN, CN;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = null;
		T = Integer.parseInt(br.readLine());
		
		for (int t = 1; t <= T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine().trim());
			N =  Integer.parseInt(st.nextToken());
			PN = Integer.parseInt(st.nextToken());
			CN = Integer.parseInt(st.nextToken());
			
			sb = new StringBuilder();
			sb.append("#").append(t).append(" ");
		
			//최대값
			sb.append(Math.min(PN, CN)).append(" ");
		 
			//최소값
			if(PN+CN>N) {
				sb.append(Math.abs(N-(PN+CN)));
			}
			else sb.append(0);
			System.out.println(sb.toString());
		}
	}
}