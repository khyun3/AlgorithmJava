package D3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class D3_4615_재미있는오셀로게임 {
	static int T, N, M;
	static int [] R = {-1,-1,-1,0,0,1,1,1};
	static int [] C = {-1,0,1,-1,1,-1,0,1};
	static int [][] map;
	public static void main(String[] args)throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		T = Integer.parseInt(br.readLine().trim());
		
		for (int t = 1; t <= T; t++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());	//판 크기
			M = Integer.parseInt(st.nextToken());	//돌을 둘 횟수
			map = new int[N][N];
			int [] answer = {0,0};
			
			//중앙 초기화
			map[(N-1)/2][(N-1)/2] = 2;
			map[(N-1)/2+1][(N-1)/2+1] = 2;
			map[(N-1)/2][(N-1)/2+1] = 1;
			map[(N-1)/2+1][(N-1)/2] = 1;
			
			//게임 시작
			for (int i = 0; i < M; i++) {
				st = new StringTokenizer(br.readLine());
				//돌을 둘 위치와 색깔을 받아와서 change함수에 넣음
				change(Integer.parseInt(st.nextToken())-1,Integer.parseInt(st.nextToken())-1, Integer.parseInt(st.nextToken()));
			}
			for (int k = 0; k < map.length; k++) {
				for (int j = 0; j < map.length; j++) {
					if(map[k][j] == 1) {
						answer[0]++;
					}
					else if(map[k][j] == 2) {
						answer[1]++;
					}
				}
			}
			System.out.println("#"+t+" "+answer[0] +" "+ answer[1]);
		}
	}
	//돌 변경 함수
	private static void change(int ri, int ci, int color) {
		map[ri][ci] = color;	//해당 위치에 돌을 넣음
		for (int d = 0; d < 8; d++) {	//8방을 검사해 봄
			int cur = ri+R[d];	//행
			int cuc = ci+C[d];	//열
			int count = 0;		//해당 위치부터 몇 개가 변경되어야 하는지 카운트 하는 함수 
			
			while(true) {
				/* 조건 : 
				 * 1. 바둑판의 위치를 넘지 않을 것.	    
				 * 2. ri와 ci 위치에 둔 돌과 색이 다를 것
				 * 3. 돌이 무조건 존재할 것. 
				 */
				if(check(cur,cuc) && map[cur][cuc] != color && map[cur][cuc] != 0) {
					count++;
				}
				/* modify 조건 :
				 * 1. 바둑판을 넘지 않을 것
				 * 2. 현재 돌을 둔 위치에서 어떤 방향으로 이동할 때, 같은 색의 돌을 만날 것. 
				 */
				else if(check(cur,cuc) && map[cur][cuc] == color) {
					int bcur = cur; 
					int bcuc = cuc;
					for (int i = 0; i < count; i++) {	//돌과 돌 사이의 돌의 색을 변경
						bcur-=R[d];
						bcuc-=C[d];
						map[bcur][bcuc] = color;
					}
					break;	//더 이상 이동하면 큰일남...해당 방향은 여기서 끝이야. 
				}
				else {
					break;
				}
				cur +=R[d];	//다음 위치로 이동하자
				cuc +=C[d]; //다음 위치로 이동하자.
			}
		}
	}
	private static boolean check(int cr, int cc) {
		if(0<=cr && cr<N && 0<=cc && cc<N) {
			return true;
		}
		return false;
	}
}