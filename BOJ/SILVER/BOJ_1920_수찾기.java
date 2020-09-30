package SILVER;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_1920_수찾기 {
	public static void main(String[] args)throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		int arr[] = new int [N];
		st = new StringTokenizer(br.readLine()," ");
		
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(arr);
		int len = arr.length-1;
		int M = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine()," ");
		for (int i = 0; i < M; i++) {
			sb.append(binarySearch(arr,Integer.parseInt(st.nextToken()),len)).append("\n");
		}
		System.out.println(sb);
	}

	private static int binarySearch(int[] arr, int num, int len) {
		int f = 0; 	//앞
		int l = len;//뒤
		int m = 0;	//중앙
		
		while(f<=l) {//앞이 마지막이랑 같거나 작으면
			
			m = (f + l)/2; //1. 중앙 값 설정
			if(num == arr[m]) {//2. 중앙의 값이 찾는 값과 같다면
				return 1;
			}
			else {
				if(num < arr[m]) //3. num이 더 작으면
					l = m-1;	 
				else	//4. num이 더 크면
					f = m+1;
			}
		}
		return 0;
	}
}