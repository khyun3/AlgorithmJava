package SILVER;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_18511_큰수구성하기 {
	static int max=-1, N, K[], kLen,nLen;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		
		int N = Integer.parseInt(br.readLine());
		nLen = Integer.toString(N).length();
		kLen =Integer.parseInt(br.readLine());
		
		K = new int[kLen];
		st = new StringTokenizer(br.readLine()," ");
		for (int i = 0; i < kLen; i++) {
			K[i] = Integer.parseInt(st.nextToken());
		}
		
		
	}
}