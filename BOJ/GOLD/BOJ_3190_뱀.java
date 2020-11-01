package GOLD;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;
import java.util.List;
public class BOJ_3190_뱀 {
	static List<int []> slist;
	static int [] dr = {-1,1,0,0}, dc= {0,0,-1,1};
	static int N,K;
	public static void main(String[] args)throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		N = Integer.parseInt(br.readLine()); //맵 크기
		K = Integer.parseInt(br.readLine()); //사과 개수
		
		int [][] map = new int [N][N];
		
		map[0][0] = 1; //시작 위치
		
		//사과 위치
		for (int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine()," ");
			map[Integer.parseInt(st.nextToken())-1][Integer.parseInt(st.nextToken())-1] = 4;
		}
		
		//방향을 언제 변경하는가?
		int L = Integer.parseInt(br.readLine());
		int time = 0; //진행시간
		int dir = 3; //오른쪽
		
		slist = new ArrayList<>(); //뱀
		slist.add(new int [] {0,0}); //r,c
		int roTime = 0; // 회전 시간
		char nextDir = 0; //회전 방향
		for (int i = 0; i <= L; i++) {
			if (i != L) {
				st = new StringTokenizer(br.readLine(), " ");
				roTime = Integer.parseInt(st.nextToken()); // 회전하는 시간
				nextDir = st.nextToken().charAt(0); // 회전하는 방향
			}
			else roTime = 10000;
			//roTime이 끝나고 회전
			int j = time;
			for (; j < 10000; j++) {
				time++;
				
				//뱀이동
				if(!go(map, dir)){
					System.out.println(time);
					return;
				}
				if(time==roTime) {
					dir = changeDir(dir, nextDir);
					break;
				}
			}
		}
		System.out.println(time);
	}
	static boolean go(int [][] map, int dir) {
		//뱀의 머리를 확인하고 이동시키자
		int [] head = slist.get(0);

		int nr = head[0] + dr[dir];
		int nc = head[1] + dc[dir]; 
		
		//맵 내부 체크
		//뱀이 자기 몸에 부딪혔는지 체크
		if(!check(nr,nc) || map[nr][nc]==1) return false; 
		slist.add(0, new int [] {nr,nc});
		
		if(map[nr][nc]!=4) {//사과가 아니면
			int [] tmp = slist.get(slist.size()-1);
			slist.remove(slist.size()-1);
			map[tmp[0]][tmp[1]] = 0;
		}
		map[nr][nc] = 1;
		return true;
	}
	static int changeDir(int dir, char nextDir) {
		//현재 방향이 오른쪽 or 왼쪽
		if(dir==3) {
			if(nextDir=='D')
				return 1;
			else
				return 0;
		}
		if(dir==2) {
			if(nextDir=='D')
				return 0;
			else
				return 1;
		}
		//현재 방향이 위쪽
		if(dir==0) {
			if(nextDir=='D')
				return 3;
			else
				return 2;
		}
		//현재 방향이 아래쪽
		if(dir==1) {
			if(nextDir=='D')
				return 2;
			else
				return 3;
		}
		return -1; //에러
	}
	static boolean check(int nr, int nc) {
		if(nr>=0 && nr<N && nc>=0 && nc<N) return true;
		return false;
	}
}