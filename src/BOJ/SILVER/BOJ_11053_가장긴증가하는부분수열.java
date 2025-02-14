package BOJ.SILVER;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_11053_가장긴증가하는부분수열 {
	
	
	public static void main(String[] args)throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		
		int [] arr = new int[N];
		int [] lis = new int[N];
		
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		int max = 0;
		for(int i=0; i<N; i++) {
			lis[i] = 1; //현재의 수만 수열에 넣었을 때 길이는 1
			
			for (int j = 0; j < i; j++) {
				if(arr[j]<arr[i]) {
					lis[i] =Math.max(lis[j]+1, lis[i]);
				}
			}
			if(max<lis[i]) max = lis[i];
		}
		//System.out.println(Arrays.toString(lis));
		System.out.println(max);
	}
}