package BOJ.SILVER;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class BOJ_18870_좌표압축 {
	
	public static void main(String[] args)throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		int arr[][] = new int [N][3];
		//0 해당 숫자
		//1 해당 숫자의 위치
		//2 해당 숫자의 압축 번호
		for (int i = 0; i < N; i++) {
			arr[i][0] = Integer.parseInt(st.nextToken());
			arr[i][1] = i;
		}
		//입력받은 숫자로 정렬
		Arrays.sort(arr, new Comparator<int []>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				return Integer.compare(o1[0], o2[0]);
			}
		});
		
		//정렬 받은 숫자의 압축 번호 지정
		int k = 0;
		for (int i = 0; i < N; i++) {
			if(i!=0 && arr[i][0] == arr[i-1][0]) {
				arr[i][2] = arr[i-1][2];
			}
			else {
				arr[i][2] = k++;
			}
		}
		//다시 원래 위치대로 sort
		Arrays.sort(arr, new Comparator<int []>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				return Integer.compare(o1[1], o2[1]);
			}
		});
		//결과 출력
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < N; i++) {
			sb.append(arr[i][2]).append(' ');
		}
		System.out.println(sb);
	}
}
