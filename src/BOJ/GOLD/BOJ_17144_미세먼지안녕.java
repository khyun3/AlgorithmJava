package BOJ.GOLD;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_17144_미세먼지안녕 {
	static class AirRefresh{
		int r;
		int c;
		public AirRefresh(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}
	static int R, C, T, answer=0;
	static int [][] map, mtmp;
	static List<AirRefresh> ar = new ArrayList<>();
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		T = Integer.parseInt(st.nextToken());
		
		map = new int[R][C];
		
		for (int i = 0; i < R; i++) { //행
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < C; j++) {//열
				map[i][j] = Integer.parseInt(st.nextToken()); 
				if(map[i][j]==-1) {
					ar.add(new AirRefresh(i,j));
				}
			}
		}
		//입력 끝 그리고 공기청정기 위치를 찾았음.
		//1 미세먼지를 확산 시킨다.
		int [] dr = {-1,1,0,0};
		int [] dc = {0,0,-1,1};
		for (int t = 0; t < T; t++) {
			mtmp = new int[R][C];
			for (int i = 0; i < R; i++) {
				for (int j = 0; j < C; j++) {
					if(map[i][j]==0) continue;
					
					int nd = 0;
					for (int d = 0; d < 4; d++) { // 4방향으로 확산
						int nr = i+dr[d];
						int nc = j+dc[d];
						
						//맵의 크기를 넘어가거나, 공기청정기가 있다면 확산 x
						if(!check(nr,nc)) continue;
						if(map[nr][nc]==-1) continue;
						nd++; //확산한 방향의 개수
						mtmp[nr][nc] += map[i][j]/5; //각방향으로 확산하는 양
					}
					map[i][j] -=(map[i][j]/5)*nd; //n,r에 남은 미세먼지의 양을 표시한다.
				}
			}
			//1초동안 확산하는 미세먼지의 양을 다 구했으면 이제 실제 맵에 더해준다.
			for (int i = 0; i < R; i++) {
				for (int j = 0; j < C; j++) {
					map[i][j]+=mtmp[i][j];
				}
			}
			//공기청정기를 작동한다.
			goAR();
			//print();
		}
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if(map[i][j] !=-1) {
					answer+=map[i][j];
				}
			}
		}
		System.out.println(answer);
	}
	private static void goAR() {
		//위쪽
		int [] hdr = {0,-1,0,1};
		int [] hdc = {1,0,-1,0};
		int nr = ar.get(0).r;
		int nc = ar.get(0).c;
		int btmp = 0, bbtmp=0;
		for (int d = 0; d < 4; d++) { //4방향 돌꺼임
			
			while(true) {
				nr +=hdr[d];
				nc +=hdc[d];
				if(!check(nr,nc)) {
					nr -=hdr[d];
					nc -=hdc[d];
					break; //맵의 값을 넘어가면 종료
				}
				if(map[nr][nc]==-1) {
					btmp = 0;
					break;
				}
				bbtmp = map[nr][nc];
				map[nr][nc] = btmp;
				btmp = bbtmp;
			}
		}
		
		//아래쪽
		int [] ldr = {0,1,0,-1};
		int [] ldc = {1,0,-1,0};
		int nr2 = ar.get(1).r;
		int nc2 = ar.get(1).c;
		int btmp2 = 0, bbtmp2=0;
		for (int d = 0; d < 4; d++) { //4방향 돌꺼임
			
			while(true) {
				nr2 +=ldr[d];
				nc2 +=ldc[d];
				if(!check(nr2,nc2)) {
					nr2 -=ldr[d];
					nc2 -=ldc[d];
					break; //맵의 값을 넘어가면 종료
				}
				if(map[nr2][nc2]==-1) {
					btmp2 = 0;
					break;
				}
				bbtmp2 = map[nr2][nc2];
				map[nr2][nc2] = btmp2;
				btmp2 = bbtmp2;
			}
		}
	}
	private static boolean check(int nr, int nc) {
		if(nr>=0 && nr<R && nc>=0 && nc<C) return true; 
		return false;
	}
//	static void print() {
//		System.out.println();
//		for (int i = 0; i < R; i++) {
//			for (int j = 0; j < C; j++) {
//				System.out.print(map[i][j]+ " ");
//			}
//			System.out.println();
//		}
//	}
}
