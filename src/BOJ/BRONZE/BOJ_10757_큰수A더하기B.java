package BOJ.BRONZE;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_10757_큰수A더하기B {
	static char a[],b[];
	static int [] ans;
	public static void main(String[] args)throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		char [] atmp = st.nextToken().toCharArray();
		char [] btmp = st.nextToken().toCharArray();
		int len = Math.max(atmp.length, btmp.length); 
		
		a = new char [len];
		b = new char [len];
		ans = new int [len+1];
		
		Arrays.fill(a, '0');
		Arrays.fill(b, '0');
		
		copy(atmp, btmp, len);
		operation(len);
		print();
	}
	static void operation(int len) {
		for (int i = 1; i<=len; i++) {
			int k = a[a.length-i]-'0' + b[b.length-i]-'0' + ans[ans.length-i];
			if(k>=10) {
				ans[ans.length-(i+1)]++;
				k -=10;
			}
			ans[ans.length-i]=k;
		}
	}
	static void copy(char [] atmp, char [] btmp, int len){
		for (int i = 1; i<=len ; i++) {
			if(atmp.length-i >= 0)
				a[a.length-i] = atmp[atmp.length-i];
			
			if(btmp.length-i >= 0)
				b[b.length-i] = btmp[btmp.length-i];
		}
	}
	static void print()throws Exception {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < ans.length; i++) {
			if(i==0 && ans[i] == 0) continue;
			sb.append(ans[i]);
		}
		System.out.print(sb);
	}
}