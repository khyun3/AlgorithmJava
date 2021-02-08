package GOLD;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_14503_로봇청소기 {
	static int N, M, R, C, D, map[][],answer;
										//0:상, 1:우, 2:하, 3:좌
	static int dir[][] = new int [][] {{-1,0},{0,1},{1,0},{0,-1}};
	public static void main(String[] args)throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		
		N = Integer.parseInt(st.nextToken()); //행
		M = Integer.parseInt(st.nextToken()); //열
		
		st = new StringTokenizer(br.readLine()," ");
		//로봇의 (R,C), 바라보는 방향 D
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		D = Integer.parseInt(st.nextToken());
		
		//맵 생성
		map = new int [N][M];
		
		//맵 정보 입력
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine()," ");
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		go();
		System.out.print(answer);
	}
	static void go() {
		//로봇 청소기의 위치는 R,C가 알고 있다.
		//로봇 청소기의 방향은 D가 알고 있다.
		int oper = 1; //로봇이 받을 명령
		int nd = D;
		boolean flag = true;
		
		while(flag) {
//			print();
			switch(oper) {
			case 1: //1. 현재 위치를 청소한다.
				cleaning(R,C);
				oper = 2;
				break;
			case 2: //2. 현재 위치에서 현재 방향(!)을 기준으로 왼쪽방향부터 차례대로 탐색한다.
				for (int i = 0; i < 4; i++) {
					D = (D+3)%4;
					
					int nr = R + dir[D][0];
					int nc = C + dir[D][1];
//					System.out.println(D +"  "+ nr+"  "+nc);
					 //a.왼쪽 방향에 아직 청소하지 않은 공간이 있다면 그 방향으로 회전하고 전진한다.					
					if(check(nr,nc) && map[nr][nc]==0) {
//						D = nd; //청소할 공간이 있다면 그 방향으로 회전한다.
						R = nr;	//회전한 방향으로 1칸 전진한다.
						C = nc;
						oper = 1;// 1번으로 돌아간다.
						break;
					}
					else {

						//c. 네 방향 모두 청소가 이미 되어있거나 벽인 경우에는, 바라보는 방향을 유지한 채로 한 칸 후진을 하고 2번으로 돌아간다.
						//d. 네 방향 모두 청소가 이미 되어있거나 벽이면서, 뒤쪽 방향이 벽이라 후진도 할 수 없는 경우에는 작동을 멈춘다.
						//네 방향 모두 청소가 이미 되어있거나 벽이라면
						if(i==3) {
							int br = R - dir[D][0];
							int bc = C - dir[D][1];
							//c. 바라보는 방향을 유지한 채로 한 칸 후진을 하고 2번으로 돌아간다.
							if(check(br, bc) && map[br][bc]!=1) {
								R = br;
								C = bc;
							}
							//d. 뒤쪽 방향이 벽이라 후진도 할 수 없는 경우에는 작동을 멈춘다.
							else {
								return;
							}
						}
					}
				}
				break;
			}
		}
	}
	static boolean check(int nr, int nc) {
		return (nr>=0 && nr<N && nc>=0 && nc<M);
	}
	static void cleaning(int rr, int rc) {
		map[rr][rc] = 5;
		answer++;
	}
	static void print() {
		System.out.println();
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				System.out.print(map[i][j]+" ");
			}
			System.out.println();
		}
	}
}
