package SWEA.D3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class D3_7272_안경이없어 {
	static int T;
	public static void main(String[] args)throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		T = Integer.parseInt(br.readLine());
		
		for (int t = 1; t <= T; t++) {
			char [] a, b;
			st = new StringTokenizer(br.readLine().trim());
			a = st.nextToken().toCharArray();
			b = st.nextToken().toCharArray();
			
			if(a.length == b.length) {
				//문자열의 각 원소를 경근이의 눈깔에 맞게 변경하자.
				for (int i = 0; i < a.length; i++) {
					if(a[i] == 'B') {
						a[i]='2';
					}
					else if(a[i] == 'A' || a[i]=='D'|| a[i]=='O'|| a[i]=='P'|| a[i]=='Q'|| a[i]=='R') {
						a[i]='1';
					}
					else {
						a[i] = '0';
					}
					if(b[i] == 'B') {
						b[i]='2';
					}
					else if(b[i] == 'A' || b[i]=='D'|| b[i]=='O'|| b[i]=='P'|| b[i]=='Q'|| b[i]=='R') {
						b[i]='1';
					}
					else {
						b[i] = '0';
					}
				}
			}
			else {
				System.out.println("#"+t+" "+"DIFF");
				continue;
			}
			if(Arrays.toString(a).equals(Arrays.toString(b))) {
				System.out.println("#"+t+" "+"SAME");
			}else {
				System.out.println("#"+t+" "+"DIFF");
			}
		}
	}
}