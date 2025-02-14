package BOJ.GOLD;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ_15683_감시 {
	static int N, M, map[][], dir[][][], blindSpot, min=Integer.MAX_VALUE;
	static int dr[] = {-1,1,0,0}, dc[] = {0,0,-1,1};
	static ArrayList<CCTV> clist;
	static boolean flag;
	static class CCTV{
		int type, r, c;//CCTV종류, 좌표 r,c

		public CCTV(int type, int r, int c) {
			this.type = type;
			this.r = r;
			this.c = c;
		}
	}
	public static void main(String[] args)throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		//전체 스폿크기를 저장
		blindSpot = N*M;
		
		//맵 크기 할당
		map = new int [N][M];
		//방향 설정
		dir = new int [6][][];
		dirInit();
		
		//CCTV 객체 리스트를 만든다.
		clist = new ArrayList<>();
		
		//맵 데이터 입력
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine()," ");
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				//0이 아닐 때
				if(map[i][j] != 0) {
					//벽이 아니면 CCTV이므로 리스트에 추가
					if(map[i][j] != 6) {
						clist.add(new CCTV(map[i][j],i,j));
					}
					blindSpot--;
				}
			}
		}//input end
		
		solution(0, new int [clist.size()]);
		System.out.print(min);
	}
	static void solution(int cnt, int [] cctvDir) {
		if(flag) return;
		//선택한 것이 CCTV의 개수 이면
		if(cnt==clist.size()) {
			int mapTmp[][] = copy(new int[N][M]);
			int bsTmp = blindSpot;
			//CCTV의 개수만큼
			for (int i = 0; i < cctvDir.length; i++) {

				//cctvDir => 어디로 회전할것인가?
				//i=cctv의 번호
				int curr[] = dir[clist.get(i).type][cctvDir[i]]; //==>이 상태는 지금 해당 번호에 dir을 구해다가 방향을 가지고 온 상태	
				
			
				//해당 type이 몇개인지 모르니까 for문을 돌린다.
				for (int k = 0; k < curr.length; k++) {
					int dk = curr[k];
					int nr = clist.get(i).r, nc = clist.get(i).c;
					while(true)	{
						nr += dr[dk];
						nc += dc[dk];
						//cctv는 벽을 통과하지 못한다.
						if(!check(nr,nc) || mapTmp[nr][nc]==6) break;
						//cctv는 cctv를 뚫을 수 있다.
						if(mapTmp[nr][nc]==0) {
							mapTmp[nr][nc] = 9;
							bsTmp--;
						}
					}
				}
			}
			min = Math.min(bsTmp, min);
			if(min==0) flag=true;
			return;
		}
		//해방 CCTV의 종류에 따라 90도 회전할 수 있는 방향 수를 구한다.
		int [][] d = dir[clist.get(cnt).type];
		
		for (int i = 0; i < d.length; i++) {
			cctvDir[cnt]=i;
			solution(cnt+1,cctvDir);
		}
	}
	static boolean check(int nr, int nc) {
		return (nr>=0 && nr<N && nc>=0 && nc<M);
	}
	
	static void dirInit() {
		//1번 : 상,하,좌,우
				dir[1] = new int [][] {{0},{1},{2},{3}}; //상하좌우
				//2번 : 좌우, 상하
				dir[2] = new int [][] {{0,1},{2,3}};
				//3번 : 우상, 우하, 좌하, 좌상
				dir[3] = new int [][] {{0,3},{1,3},{1,2},{0,2}};
				//4번 : 좌우상,좌우하, 우상하, 좌상하
				dir[4] = new int [][] {{0,2,3},{1,2,3},{0,1,3},{0,1,2}};
				//5번 : 상하좌우
				dir[5] = new int [][] {{0,1,2,3}};
	}
	static int[][] copy(int [][] mapTmp) {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				mapTmp[i][j] = map[i][j];
			}
		}
		return mapTmp;
	}
//	static void print(int [][] kkk) {
//		System.out.println();
//		for (int i = 0; i < N; i++) {
//			for (int j = 0; j < M; j++) {
//				System.out.print(kkk[i][j]+" ");
//			}
//			System.out.println();
//		}
//	}
}
