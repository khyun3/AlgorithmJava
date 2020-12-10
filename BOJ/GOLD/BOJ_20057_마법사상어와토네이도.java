package GOLD;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_20057_마법사상어와토네이도 {
	static int N, answer;
	static int [][] map;			//상상,   상,    상좌, 상우,   
	static int [][] tornadoD = 		{{-2,0},{-1,0},{-1,-1},{-1,1}, //0~3			0상
									//하하, 하,   하좌, 하우, 		  
									{2,0},{1,0},{1,-1},{1,1},	  //4~7				4하
									//좌좌,   좌,    상좌,    하좌	  
									{0,-2},{0,-1},{-1,-1},{1,-1}, 	//8~11			8좌 1, 10
									//우우,  우,   상우      하우
									{0,2},{0,1},{-1,1},{1,1}};		//12~15			12우 1, 10
	
	static int dir[][] = {{0,-1},{1,0},{0,1},{-1,0}};
	public static void main(String[] args)throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		N = Integer.parseInt(br.readLine());
		
		map = new int [N][N];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine()," ");
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		tornado(N/2, N/2);
		System.out.println(answer);
	}
	private static void tornado(int r, int c) {
		//시작점은 중앙 값
		//달팽이 모양으로 움직여야함
		int d = 0, nr=r,nc=c, cnt = 1;
		int tmp = 1;
		
		while(!(nr==0 && nc==0)) {//좌 -> 하 -> 우 -> 상   순서로 움직임 1122 3344 5566 6 << N=7일 경우
			
			for (int i = 0; i < cnt; i++) {
				nr+=dir[d][0];
				nc+=dir[d][1];
				movedust(nr,nc, d);
			}
			if(tmp%2==0 && nr!=0 && nc!=N-1) cnt++;	//이동
			d = (d+1)%4;	
			tmp++;
		}
		
	}
	private static void movedust(int r, int c, int d) {
		int remainDust = map[r][c];
		
		double [][] mp = {{0.02, 0.07, 0.1, 0.01}, //좌
						  {0.02, 0.07, 0.01, 0.1}, //하
						  {0.02, 0.07, 0.01, 0.1}, //우
						  {0.02, 0.07, 0.1, 0.01}};//상
		int i=0,j = 0;
		if(d==1 || d==3) i=8; 
		j=i;
		for (; i < j + 8; i++) {
			int nr = r + tornadoD[i][0];
			int nc = c + tornadoD[i][1];
			int mvdust = (int) (map[r][c] * mp[d][i%4]); // 이동할 먼지의 양을 구한다
			remainDust -= mvdust; // 남은 먼지의 양을 구한다
			if (!check(nr, nc, mvdust)) continue; // 만약 이동불가면 answer에 ++
			map[nr][nc] += mvdust; // 이동가능하면 해당 칸에++
		}

		if(d==0) d=8;			//좌(d=0)로 움직일 때 0~3 전부, 4~7 전부, 좌좌, 좌(a)
		else if(d==1)d=4;		//하(d=1)로 움직일 때 8~11전부, 12~15 전부, 하하, 하(a)
		else if(d==2)d=12;		//우(d=2)로 움직일 때 0~3 전부, 4~7 전부, 우우, 우(a)
		else if(d==3)d=0;		//상(d=3)으로 움직일 때 8~11전부, 12~15 전부, 상상, 상(a)
		
		int nr = r + tornadoD[d][0];
		int nc = c + tornadoD[d][1];
		int mvdust = (int) (map[r][c] * 0.05); // 이동할 먼지의 양을 구한다
		if (check(nr, nc, mvdust)) {
			map[nr][nc] += mvdust;
		}
		remainDust -= mvdust;
		nr = r + tornadoD[d + 1][0];
		nc = c + tornadoD[d + 1][1];
		if (check(nr, nc, remainDust)) {
			map[nr][nc] += remainDust;
		}
		map[r][c] = 0;
	}
	private static boolean check(int nr, int nc, int mvdust) {
		if(nr>=0 && nr<N && nc>=0 && nc<N)return true;
		answer +=  mvdust;
		return false;
	}
}