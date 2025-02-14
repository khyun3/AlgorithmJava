package BOJ.SILVER;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

public class BOJ_9020_골드바흐의추측 {
	public static void main(String[] args)throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		
		//1~10000까지 소수를 구한다.
		//에라토스테네스의 접근 : 주어진 자연수 N이 소수이기 위한 필요충분 조건은 N이 N의 제곱근보다 크지 않은 어떤 소수로도 나눠지지 않는다.
		//에라토스테네스의 체 : 모든 수는 소수의 곱으로 이루어진다.
		
		//에라토스테네스의 체 이용하기
		//ex) 4 = 2*2, 6 = 3*2, 9 = 3*3 ...
		int [] num = new int[10001];
		for (int i = 0; i <= 10000; i++) {
			num[i] = i;
		}
		
		for (int i = 2; i <= 100; i++) { // √10000 = 100
			if(num[i]!=0) {
				for (int j = i*2; j <=10000 ; j+=i) {
					num[j] = 0;
				}
			}
		}
		
		ArrayList<Integer> primeList = new ArrayList<>();
		for (int i = 2; i <= 10000; i++) {
			if(num[i]!=0) primeList.add(i);
		}
		
		int goldbach[][] = new int [10001][2];
		
		for (int p : primeList) {
			for (int pp : primeList) {
				if(p > pp) continue;
				int idx = p+pp;
				if(idx>10000) break;
				if(goldbach[idx][0] == 0) {
					goldbach[idx][0] = p;
					goldbach[idx][1] = pp;
				}
				else {
					if(pp-p < (goldbach[idx][1] - goldbach[idx][0])) {
						goldbach[idx][0] = p;
						goldbach[idx][1] = pp;
					}
				}
			}
		}
		for (int t = 0; t < T; t++) {
			int N = Integer.parseInt(br.readLine());
			sb.append(goldbach[N][0]).append(" ").append(goldbach[N][1]).append("\n");
		}
		
		System.out.print(sb);
	}
}
