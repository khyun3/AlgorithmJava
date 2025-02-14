package BOJ.SILVER;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_14889_스타트와링크 {
	
	static int N, MIN=Integer.MAX_VALUE, sum1,sum2, count=0;
	static long stop=1;
	static int [][] map;
	static boolean[] isSelected;
	static int [] numbers, numbers2, numTmp1, numTmp2;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		N = Integer.parseInt(br.readLine());
		
		map = new int[N][N];
		isSelected = new boolean[N];
		numbers = new int[N/2];
		numbers2 = new int[N/2];
		numTmp1 = new int[2];
		numTmp2 = new int[2];
	
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		div(0,0);
		System.out.println(MIN);
	}

	private static void div(int cnt, int start) {//nCr
		if(cnt==N/2) {
			int j=0;
			int k=0;
			sum1=0; sum2=0;
			for (int i = 0; i < N; i++) {
				
				if(isSelected[i])
					numbers[j++] = i;
				else
					numbers2[k++] = i;
			}

			sum(0,0);
			MIN = Math.min(MIN, Math.abs(sum1-sum2));
			return;
		}
		
		for (int i = start; i < N; i++) {
			isSelected[i] = true;
				div(cnt+1, i+1);
			isSelected[i] = false;
		}
	}
	static void sum(int cnt, int start) {// nCr
		if(cnt==2) {
				sum1 += map[numTmp1[0]][numTmp1[1]] + map[numTmp1[1]][numTmp1[0]]; //start
				sum2 += map[numTmp2[0]][numTmp2[1]] + map[numTmp2[1]][numTmp2[0]]; //link

				return;
		}
		for (int i = start; i < N/2; i++) {
				numTmp1[cnt] = numbers[i];  //start
				numTmp2[cnt] = numbers2[i]; //link
			sum(cnt+1, i+1);
		}
	}
}