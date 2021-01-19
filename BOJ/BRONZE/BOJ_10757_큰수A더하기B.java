package BRONZE;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_10757_큰수A더하기B {
	static char a[],b[];
	public static void main(String[] args)throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		char [] atmp = st.nextToken().toCharArray();
		char [] btmp = st.nextToken().toCharArray();
		int len = atmp.length > btmp.length ? atmp.length : btmp.length; 
		
		a = new char [len];
		b = new char [len];
		
		Arrays.fill(a, '0');
		Arrays.fill(b, '0');
		
		copy(atmp, btmp, len);
		System.out.println(Arrays.toString(a));
		System.out.println(Arrays.toString(b));
//		operation();
	}
	static void operation() {
		int len = (a.length >= b.length ? a.length : b.length)-1;

	}
	static void copy(char [] atmp, char [] btmp, int len){
		//a에 atmp를 뒤에서부터 복사한다.
		for (int i = 1; i<=len ; i++) {
			if(atmp.length-i >= 0)
				a[a.length-i] = atmp[atmp.length-i];
			
			if(btmp.length-i >= 0)
				b[b.length-i] = btmp[btmp.length-i];
			
		}
	}
}
