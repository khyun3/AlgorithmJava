package D3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class D3_9940_순열 {
	static int T, N;
	static int [] input;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		boolean yes = true;
		T = Integer.parseInt(br.readLine());
		
		for (int t = 1; t <= T; t++) {
			yes = true;
			N = Integer.parseInt(br.readLine());
			input = new int[N];
			st = new StringTokenizer(br.readLine());
			
			for (int i = 0; i < N; i++) {
				input[i] = Integer.parseInt(st.nextToken());
			}
			Arrays.sort(input);
			for (int i = 0; i < N-1; i++) {
				if(input[i] == input[i+1]) {
					yes = false;
				}
				if(input[i]+1 != input[i+1] ) {
					yes = false;
				}
			}
			if(yes) {System.out.println("#"+t+" "+"Yes");} 
			else {System.out.println("#"+t+" "+"No");}
		}
	}
}