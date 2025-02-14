package BOJ.SILVER;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class BOJ_18511_큰수구성하기2 {
	static int N[];
	static Integer K[];
	static boolean check;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		
		char [] ntmp = st.nextToken().toCharArray(); //문자열로 나눠서 받고
		N = new int [ntmp.length]; 					 //위 ntmp의 크기만큼 N을 선언한다
		for (int i = 0; i < ntmp.length; i++) {
			N[i] = ntmp[i] - '0';
		}
		int ktmp = Integer.parseInt(st.nextToken()); //k의 크기를 받고
		K = new Integer[ktmp+1]; 						 //k의 크기만큼 선언한다.
		
		st = new StringTokenizer(br.readLine()," "); 
		for (int i = 0; i < ktmp; i++) {			 //k의 수들을 K배열에 넣는다.
			K[i] = Integer.parseInt(st.nextToken());
		}
		K[ktmp] = 0;
		Arrays.sort(K, Collections.reverseOrder());
		//중복 순열
		nPr(0, new int [ntmp.length], false);
	}
	private static void nPr(int cnt, int[] num, boolean isSame) {
		if(check) return;
		System.out.println(Arrays.toString(num));
		if(cnt==N.length) {
			System.out.println(Arrays.toString(num));
			StringBuilder sb = new StringBuilder();
			for (int i : num) {
				sb.append(i);
			}
			System.out.println(Integer.parseInt(sb.toString()));
			check= true;
			return;
		}
		for (int i = 0; i < K.length; i++) {

			if(isSame) {//이전 수가 해당 자리수의 N과 같은가?
				if(N[cnt] > K[i]) { //전 수가 같다면 지금 자리수와 같거나 작아야 한다.
					num[cnt] = K[i];
					nPr(cnt+1, num, false);
				}
				else if(N[cnt] == K[i]) {
					nPr(cnt+1, num, true);
				}
			}
			else { //이전 수가 해당 자리수
				if(cnt==0) {
					if(N[cnt] > K[i]) { //전 수가 같다면 지금 자리수와 같거나 작아야 한다.
						num[cnt] = K[i];
						nPr(cnt+1, num, false);
					}
					else if(N[cnt] == K[i]) {
						nPr(cnt+1, num, true);
					}
				}
				else {
					num[cnt] = K[i];
					nPr(cnt+1, num, false);
				}
			}
		}
	}
}