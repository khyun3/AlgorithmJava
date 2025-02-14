package BOJ.GOLD;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class BOJ_20056_마법사상어와파이어볼 {
	static class FireBall{
		int r, c, m, s, d; //위치, 질량, 방향, 속력

		public FireBall(int r, int c, int m, int s, int d) {
			this.r = r;
			this.c = c;
			this.m = m;
			this.s = s;
			this.d = d;
		}
		public FireBall() {}
	}
	static int N, M, K; //맵 크기, 파이어볼 수, 명령 수
	static int dr[]= {-1,-1,0,1,1,1,0,-1}, dc[]= {0,1,1,1,0,-1,-1,-1};
	static LinkedList<FireBall> map[][];
	public static void main(String[] args)throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken()); //맵 크기
		M = Integer.parseInt(st.nextToken()); //파볼 수
		K = Integer.parseInt(st.nextToken()); //명령 수

		map = new LinkedList[N][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				map[i][j] = new LinkedList<FireBall>();
			}
		}
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int r = Integer.parseInt(st.nextToken()) - 1;
			int c = Integer.parseInt(st.nextToken()) - 1;
			map[r][c].add(new FireBall(r, c, 
					Integer.parseInt(st.nextToken()), 
					Integer.parseInt(st.nextToken()),
					Integer.parseInt(st.nextToken())));
		} // 입력 끝
		
		//명령 횟수(K) 만큼 수행
		for (int i = 0; i < K; i++) {
			moveFireBall();
		}
		int answer = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				for (int k = 0; k < map[i][j].size(); k++) {
					answer += map[i][j].get(k).m;
				}
			}
		}
		System.out.println(answer);
	}
	private static void moveFireBall() {
		//모든 파이어볼이 자신의 방향 di로 속력 si칸 만큼 이동한다.
		LinkedList<FireBall> aList = new LinkedList<>();
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				int size = map[i][j].size();
				//파이어볼이 존재하면
				for (int k = 0; k < size; k++) {
					FireBall cur = map[i][j].get(0);
					
					cur.r += dr[cur.d]*cur.s;
					cur.c += dc[cur.d]*cur.s;
					if(cur.r < 0) {cur.r = cur.r%N + N;} //0보다 작을 때
					if(cur.c < 0) {cur.c = cur.c%N + N;} //0보다 작을 떄
					if(cur.r >=N) {cur.r%=N;} //N보다 클 때
					if(cur.c >=N) {cur.c%=N;} //N보다 클 떄
					map[i][j].remove(0);
					aList.add(cur);
				}
			}
		}
		for (int i = 0; i < aList.size(); i++) {
			map[aList.get(i).r][aList.get(i).c].add(aList.get(i));
		}
		//이동이 모두 끝난 뒤, 2개 이상의 파이어볼이 있는 칸에서는 다음과 같은 일이 일어난다.
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				int size = map[i][j].size();
				int dir = 0;
					//1.같은 칸에 있는 파이어볼은 모두 하나로 합쳐진다.
				if(size>1) {
					FireBall tmp = new FireBall();
					tmp.r = map[i][j].get(0).r;
					tmp.c = map[i][j].get(0).c;
					
					for (int k = 0; k < size; k++) {
						tmp.m += map[i][j].get(k).m;
						tmp.s += map[i][j].get(k).s;
						
						if(map[i][j].get(k).d%2==0) { //짝수이면 dir ++ 
							dir ++;
						}
					}
					map[i][j].clear();
					//2.파이어볼은 4개의 파이어볼로 나누어진다.
					//3.나누어진 파이어볼의 질량, 속력, 방향은 다음과 같다.
					//	- 질량은 ⌊(합쳐진 파이어볼 질량의 합)/5⌋이다.
					tmp.m /=5;
					//	- 속력은 ⌊(합쳐진 파이어볼 속력의 합)/(합쳐진 파이어볼의 개수)⌋이다.
					tmp.s /=size;
					//	- 합쳐지는 파이어볼의 방향이 모두 홀수이거나 모두 짝수이면, 방향은 0, 2, 4, 6이 되고, 그렇지 않으면 1, 3, 5, 7이 된다.
					boolean dirCheck = false;
					if(dir==0 || dir==size) {
						dirCheck = true;
					}
					if (tmp.m != 0) {// 4.질량이 0인 파이어볼은 소멸되어 없어진다.
						for (int k = 0; k < 4; k++) {
							map[i][j].add(new FireBall(tmp.r, tmp.c, tmp.m, tmp.s, dirCheck ? 2 * k : 2 * k + 1));// r,c,m,s,d
						}
					}
				}
			}
		}
	}
}