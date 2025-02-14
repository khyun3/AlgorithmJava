package BOJ.SILVER;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1049_기타줄 {
	public static void main(String[] args)throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int minSet, minPiece;
		minSet = minPiece = Integer.MAX_VALUE;
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine()," ");
			minSet = Math.min(minSet, Integer.parseInt(st.nextToken()));
			minPiece = Math.min(minPiece, Integer.parseInt(st.nextToken()));
		}
		//최소 낱개 가격으로 res를 구한다.
		int res = minPiece*N;
		
		//세트로 살 수 있는 횟수만큼 loop를 돌린다.
		int cnt = N/6+1;
		for (int i = 1; i <= cnt; i++) {
			res = Math.min(res, minSet*i + (i*6<N ? (N-i*6)*minPiece:0));
		}
		System.out.println(res);
	}
}