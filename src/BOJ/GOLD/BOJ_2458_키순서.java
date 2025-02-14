package BOJ.GOLD;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2458_키순서 {
	
	static int N, M;
	public static void main(String[] args)throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		int [][] adjmtx = new int [N][N];
		int answer = 0;
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine()," ");
			adjmtx[Integer.parseInt(st.nextToken())-1][Integer.parseInt(st.nextToken())-1] = 1;
		}
		//플로이드 와샬
		for (int k = 0; k < N; k++) { //경
			for (int i = 0; i < N; i++) { //출
				for (int j = 0; j < N; j++) { //도
					if(adjmtx[i][k]==1 && adjmtx[k][j]==1) //출 -> 경 ok? && 경->도 ok?
						adjmtx[i][j] = 1;
				}
			}
		}
		
		for (int i = 0; i < N; i++) {
			boolean check = true;
			for (int j = 0; j < N; j++) {
				if(i!=j && adjmtx[i][j]==0 && adjmtx[j][i]==0)
					check = false;
			}
			if(check) answer++;
		}
		System.out.println(answer);
	}
}