package SWEA.D3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//요리사
public class D3_4012_요리사 {
	static int N, T, answer = Integer.MAX_VALUE;
	static int [][] table;
	static int [] selected;
	static boolean [] isSelected;
	public static void main(String[] args)throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		T = Integer.parseInt(br.readLine());
		
		for (int t = 1; t <= T; t++) {
			answer = Integer.MAX_VALUE;
			N = Integer.parseInt(br.readLine());
			table = new int [N][N];
			isSelected = new boolean[N];
			
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					table[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			nCr(0,0);
			System.out.println("#"+t+" "+answer);
		}
	}
	private static void nCr(int cnt, int start) {
		if(cnt == N/2) {
			int a = 0;
			int b = 0;
			int [] c = new int[N/2];
			int [] uc = new int[N/2];
			int cnt1 = 0, cnt2 = 0;
			
			for (int i = 0; i < N; i++) {
				if(isSelected[i])
					c[cnt1++] = i;
				else
					uc[cnt2++] = i;
			}
			
			for (int i = 0; i < c.length; i++) {
				for (int j = 0; j < c.length; j++) {
					if(i!=j)
						a += table[c[i]][c[j]];
				}
			}
			for (int i = 0; i < uc.length; i++) {
				for (int j = 0; j < uc.length; j++) {
					if(i!=j)
						b += table[uc[i]][uc[j]];
				}
			}
			answer = Math.min(answer, Math.abs(a-b));
			return ;
		}
		for (int i = start; i < N; i++) {
			if(isSelected[i]) continue;
			isSelected[i] = true;
			nCr(cnt+1, i+1);
			isSelected[i] = false;
		}
	}
}