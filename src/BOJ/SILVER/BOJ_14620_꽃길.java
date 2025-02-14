package BOJ.SILVER;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_14620_꽃길 {
	static int N, FN, min= Integer.MAX_VALUE;
	static int [][] map;
	static int [] dr = {-1,1,0,0}, dc = {0,0,-1,1};
	public static void main(String[] args)throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		N = Integer.parseInt(br.readLine());
		FN = N-1; //꽃을 실질적으로 심을 수 있는 위치(가장자리 빼기)
		map = new int [N][N];
		
		for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine()," ");
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		//꽃잎이 서로 겹치지  x
		ncr(0,0,0, new boolean [N][N]);
		System.out.println(min);
	}
	private static void ncr(int cnt, int start, int sum, boolean [][] v) {
		
		if(cnt==3) {
			min = Math.min(sum, min);
			return;
		}
		
		for (int i = start; i < N*N; i++) {
			int r = i/N;
			int c = i%N;
			
			if(!check(r,c)) continue; //씨앗을 심을 수 있는 위치 => 가장자리 X
			if(!visitCheck(r,c, v))continue; //겹쳤는지 확인
			v[r][c] = true;
			int sumTmp = visit(r,c, v);
			
			ncr(cnt+1, i+1, sum+sumTmp, v);
			
			v[r][c] = false;
			unVisit(r,c, v);
		}
		
	}
	private static void unVisit(int r, int c, boolean[][] v) {
		for (int d = 0; d < 4; d++) {
			int nr = r + dr[d];
			int nc = c + dc[d];
			v[nr][nc] = false;
		}
	}

	private static int visit(int r, int c, boolean[][] v) {
		int sum = 0;
		sum += map[r][c];
		for (int d = 0; d < 4; d++) {
			int nr = r + dr[d];
			int nc = c + dc[d];
			v[nr][nc] = true;
			sum += map[nr][nc];
		}
		return sum;
	}
	private static boolean visitCheck(int r,int c,boolean[][] v) {
		for (int d = 0; d < 4; d++) {
			int nr = r + dr[d];
			int nc = c + dc[d];
			
			if(v[nr][nc]) {
				return false;
			}
		}
		return true;
	}
	private static boolean check(int nr, int nc) {
		
		if(nr>0 && nr<FN && nc>0 && nc<FN) return true;
		return false;
	}
}