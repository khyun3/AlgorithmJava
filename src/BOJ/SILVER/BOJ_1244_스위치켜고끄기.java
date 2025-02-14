package BOJ.SILVER;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1244_스위치켜고끄기 {
	static int N, M, G, C;//스위치 수, 학생수, 성별,받은 숫자
	static int[] sw;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		

		//스위치 개수 입력
		N = Integer.parseInt(br.readLine());
		
		sw = new int[N+1];
		
		//스위치 상태 입력
		st = new StringTokenizer(br.readLine()," ");
		for (int i = 1; i < sw.length; i++) {
			sw[i] = Integer.parseInt(st.nextToken());
		}
		
		//학생 수 입력
		M = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine()," ");
			G = Integer.parseInt(st.nextToken()); //성별
			C = Integer.parseInt(st.nextToken()); //받은 숫자
			
			change(G,C);
		}
		
		//결과 출력
		StringBuilder sb = new StringBuilder();
		for (int i = 1; i <= N; i++) {
			if(i==1) {
				sb.append(sw[i]).append(" ");
				continue;
			}
			
			if(i%20==1) {
				sb.append('\n').append(sw[i]).append(" ");
			} else {
				sb.append(sw[i]).append(" ");
			}
		}
		System.out.println(sb.toString());
	}

	static void change(int g, int c) {
		//남자일 때
		if(g==1) {
			for (int i = c; i < sw.length; i+=c) {
				if(sw[i]==1) sw[i] = 0;
				else if(sw[i]==0) sw[i] = 1;
			}
		}
		//여자일 때
		else {
			//왼쪽 오른쪽 저장 변수 지정
			int left = c;
			int right = c;
			if(sw[c]==1) sw[c] = 0;
			else if(sw[c]==0) sw[c] = 1;
			
			while(true) {
				left--;
				right++;
				if(left<=0 || right>N) break;
				
				if(sw[left] == sw[right]) {
					if(sw[left]==1) sw[left] = 0;
					else if(sw[left]==0) sw[left] = 1;
					
					if(sw[right]==1) sw[right] = 0;
					else if(sw[right]==0) sw[right] = 1;	
				}
				else break;
			}
		}
	}
}