package BOJ.SILVER;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ_2981_검문 {
	
	public static void main(String[] args)throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		
		int num[] = new int [N];
		for (int i = 0; i < N; i++) {
			num[i] = Integer.parseInt(br.readLine());
		}
		//정렬
		Arrays.sort(num);
		
		//입력 받은 수들 중 최소값을 모든 수에서 빼버린다.(나머지 처리라고 생각)
		for (int i = 1; i < N; i++) {
			num[i]-=num[0];
		}
		
		//최소값을 가지는 수를 뺀 나머지들의 GCD를 구한다.
		int k=num[1];
		for (int i = 2; i < N; i++) {
			k = GCD(num[i],k);
		}
		
		//약수를 구한다
		for (int i = 2; i <= k ; ++i) {
			if(k%i==0) {
				sb.append(i).append(' ');
			}
		}
		System.out.print(sb);
	}
	private static int GCD(int a, int b) { // a>b이여야 성립
		return b==0 ? a : GCD(b,a%b);
	}
}