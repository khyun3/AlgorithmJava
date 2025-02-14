package BOJ.SILVER;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_1026_보물 {
	
	public static void main(String[] args)throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		int n = Integer.parseInt(br.readLine());
		int [] a = new int [n];
		int [] b = new int [n];
		
		st = new StringTokenizer(br.readLine()," ");
		for (int i = 0; i < n; i++) {
			a[i] = Integer.parseInt(st.nextToken());
		}
		st = new StringTokenizer(br.readLine()," ");
		for (int i = 0; i < n; i++) {
			b[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(a);
		Arrays.sort(b);
		int ans = 0;
		
		for (int i = 0; i < n; i++) {
			ans +=a[i]*b[n-i-1];
		}
		System.out.println(ans);
	}
}