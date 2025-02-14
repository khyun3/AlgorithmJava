package SWEA.D2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class D2_최빈수구하기_1204 {
	static int T,N, answer;
	static int [][] score = new int[101][2]; 
	public static void main(String[] args)throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		T = Integer.parseInt(br.readLine());
		
		for (int t = 1; t <= T; t++) {
			N = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine().trim());
			
			for (int i = 0; i < score.length; i++) {
				score[Integer.parseInt(st.nextToken())][1]++;
				score[i][0] = i;
			}			
			Arrays.sort(score);
			//System.out.println(Arrays.toString(score[1]));

			System.out.println("#"+N+" " + score[100][0]);
		}
	}
}
