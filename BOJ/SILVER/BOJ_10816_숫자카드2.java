package SILVER;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
//이분탐색, 해쉬를 이용해서 다시 풀어볼것
public class BOJ_10816_숫자카드2 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine()," ");
		int [] card = new int [20000001];
		
		//최대 2천만
		for (int i = 0; i < N; i++) {
			card[Integer.parseInt(st.nextToken())+10000000]++;
		}
		int M = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine()," ");
		
		StringBuilder sb = new StringBuilder();
		for (int j = 0; j < M; j++) {
			sb.append(card[Integer.parseInt(st.nextToken())+10000000]).append(" ");
		}
		System.out.println(sb);
	}
}