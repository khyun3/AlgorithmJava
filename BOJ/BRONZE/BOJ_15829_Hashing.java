package BRONZE;

import java.io.BufferedReader;
import java.io.InputStreamReader;

//	  l-1
//H = 시그마 ai*r^i mod M 	(r=31, M=1234567891 
//    i=0
public class BOJ_15829_Hashing {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		char [] str = br.readLine().toCharArray();
		Long [] intStr = new Long[N];
		
		for (int i = 0; i < N; i++) {
			intStr[i] = str[i]-'a'+1L;
		}
		
		long hash = 0;
		long r = 1;
		long M = 1234567891;
		for (int i = 0; i < N; i++) {
			if(i!=0) r=r*31%M;
			hash = (hash + ((intStr[i]%M)*r)%M)%M;
		}
		System.out.println(hash);
	}
}