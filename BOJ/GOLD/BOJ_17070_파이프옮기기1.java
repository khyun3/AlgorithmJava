package GOLD;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_17070_파이프옮기기1 {
	static int N, map[][], res;
	static int [] dr= {0,1,1}, dc= {1,1,0};
	public static void main(String[] args)throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		map = new int [N][N];
		StringTokenizer st = null;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine()," ");
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		//시작점은 0,0과 0,1 (파이프는 2칸을 먹음)
		if(map[N-1][N-1]!=1)
			dfs(N-1,N-1, 0,1,0,0,0);
		System.out.println(res);
	}
	private static void dfs(int xr, int xy, int r1, int c1, int r2,int c2,  int dir) {
		if((r1==xr && c1==xy)) {
			res++;
			return;
		}
		if(r1>=N || c1>=N || map[r1][c1]==1) return;

		//왼쪽으로부터 왔음 => 오른쪽
		if(dir==0) {
			
			dfs(xr,xy, r1+dr[0],c1+dc[0],r1,c1, 0);
		}
		//왼쪽 대각으로부터 왔음 => 오른쪽, 아래
		else if(dir==1) {
			dfs(xr,xy, r1+dr[0],c1+dc[0],r1,c1, 0); //오른쪽
			dfs(xr,xy, r1+dr[2],c1+dc[2],r1,c1, 2); //아래
		}
		//위에서 왔음	=> 아래
		else if(dir==2) {
			dfs(xr,xy, r1+dr[2],c1+dc[2],r1,c1, 2); //아래
		}
		if(check(r1, c1))
			dfs(xr,xy, r1+dr[1],c1+dc[1],r1,c1, 1); //오른 대각은 다 갈 수 있으니 밖으로 뺀다.
	}
	private static boolean check(int r, int c) {
		for (int i = 0; i < 3; i++) {
			int nr = r+dr[i];
			int nc = c+dc[i];
			if(nr>=0 && nr<N && nc>=0 && nc<N)
				if(map[nr][nc]==1) return false;
		}
		return true ;
	}
}