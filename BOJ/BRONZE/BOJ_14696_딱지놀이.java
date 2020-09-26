package BRONZE;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_14696_딱지놀이 {
	static int N;
	static int A[];
	static int B[];

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stA, stB;
		N = Integer.parseInt(br.readLine());// 총 라운드 입력
		
		// 해당 라운드만큼 경기를 진행한다.
		for (int n = 0; n < N; n++) {
			A = new int [4];
			B = new int [4];
			int k = 0;
			
			//A어린이 입력
			stA = new StringTokenizer(br.readLine(), " ");
			k = Integer.parseInt(stA.nextToken());
			for (int i = 0; i < k; i++) {
				A[Integer.parseInt(stA.nextToken())-1]++;
			}
			//B어린이 입력
			stB = new StringTokenizer(br.readLine(), " ");
			k = Integer.parseInt(stB.nextToken());
			for (int i = 0; i < k; i++) {
				B[Integer.parseInt(stB.nextToken())-1]++;
			}
			
			//가장 끝부터 비교해보자 만약에 A와 B중에 누군가 더 크다면 
			//그 사람이 이긴다.
			for (int i = 3; i>= 0; i--) {
				int cA = A[i];
				int cB = B[i];
				
				if(cA>cB) {
					System.out.println("A");
					break;
				}
				else if(cA<cB) {
					System.out.println("B");
					break;
				}
				else {
					if(i==0) {
						System.out.println("D");
					}
				}
			}
		}
	}
}