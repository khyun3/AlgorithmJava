package BOJ.GOLD;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_14500_테트로미노 {
	
	static class Tetromino{
		int r[][];
		int c[][];
		public Tetromino(int[][] r, int[][] c) {
			this.r = r;
			this.c = c;
		}
	}
	//O(N*M*19*4) = 최대 1900만 => O(NM)
	
	static int N,M,max;
	static int[][] map;
	static int a = 0;
	public static void main(String[] args)throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine()," ");
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}//입력 끝
		
		//각각의 테트로미노의 모양을 만들자 15개임
		Tetromino tet = new Tetromino(
				new int[][] {{0,1,2,3},{0,0,0,0},
					{0,0,1,1},
					{0,1,2,2},{0,0,0,1},{0,0,1,2},{0,1,1,1},{0,0,0,1},{0,1,2,2},{0,1,1,1},{0,0,1,2},
					{0,0,0,1},{0,1,2,1},{0,1,1,1},{0,1,2,1},
					{0,1,1,2},{0,0,1,1},{0,1,1,2},{0,0,1,1}},
				
				new int[][] {{0,0,0,0},{0,1,2,3}, 													   // ㅡ |
					{0,1,0,1}, 																		   //ㅁ
					{0,0,0,1},{0,1,2,0},{0,1,1,1},{0,0,-1,-2},{0,1,2,2},{0,0,0,-1},{0,0,1,2},{0,1,0,0},//ㄱ,ㄴ자
					{0,1,2,1},{0,0,0,-1},{0,-1,0,1},{0,0,0,1},										   //	
					{0,0,1,1},{0,1,-1,0},{0,-1,0,-1},{0,1,1,2}});

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					//i,j = r,c
					for (int k = 0; k < 19; k++) {
						boolean flag = true;
						int sum = 0;
						for (int d = 0; d < 4; d++) {
							int nr = i+tet.r[k][d];
							int nc = j+tet.c[k][d];
							a++;
							if(!check(nr,nc)) {
								flag = false;
								break; //맵 안에 x이면
							}
							sum += map[nr][nc];
						}
						if(flag) {
							if(sum>max) max = sum;
						}
					}
				}
			}
			System.out.println(a);
			System.out.println(max);
		
	}
	private static boolean check(int nr, int nc) {
		if(nr>=0 && nr<N && nc>=0 && nc<M) return true;
		return false;
	}
}
