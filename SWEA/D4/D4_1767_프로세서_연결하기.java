package D4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;


public class D4_1767_프로세서_연결하기 {
	static class Core{
		int r;
		int c;
		public Core(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}
	static int T, N, max,min,totalCnt;	//테케, 행렬 크기, 최대코어, 최소전선, 처리할 코어 
	static int[][] map;
	static List<Core> cList = new ArrayList<>();

	static int[] dr = {-1,1,0,0};
	static int[] dc = {0,0,-1,1};
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		T = Integer.parseInt(br.readLine());
		
		
		for (int t = 1; t <= T; t++) {
			N = Integer.parseInt(br.readLine());
			map = new int[N][N];
			cList.clear();
			max = 0;
			min = Integer.MAX_VALUE;
			totalCnt = 0;
			
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine()," ");
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				
					if(map[i][j]==1) { //테두리 라인이 아닌 코어들의 리스트를 만든다.
						if(i==0 || i==N-1 || j==0 || j==N-1) continue;
						cList.add(new Core(i,j));
						totalCnt++;
					}
				}
			}
			go(0,0,0);
			System.out.println("#"+t+" "+min);
		}	
	}				//처리할코어인덱스 //직전까지 포함된 코어수 //라인의 카운트
	static void go(int index, int cCnt, int lCnt) {
		//현재까지 연결된 코어수 + 앞으로 처리해야할 남은 코어수 : 기대할수 있는 최대코어 수
		//최대코어수가 임시해보다 작다면
		if(cCnt+totalCnt-index < max) { //가지치기
			return;
		}
		if(index == totalCnt) {
			if(max<cCnt) {
				max = cCnt;
				min = lCnt;
			} else if(max==cCnt) { //코어의 수가 같다면
				if(min>lCnt) {
					min = lCnt;
				}
			}
			return;
		}
		//해당 코어 선택
		//4방향의 직선으로 전선 놓아보는 시도
		Core cur = cList.get(index);
		int r = cur.r;
		int c = cur.c;
		
		for (int d = 0; d < 4; d++) {
			// 해당 방향으로 전선 놓는게 가능한지 체크
			if(isAvalable(r, c, d)) {
				// 가능하다면 전선 놓기
				int len = setStatus(r, c, d, 2);
				// 다음 코어로 넘어가기
				go(index+1, cCnt+1, lCnt+len);
				
				// 놓았던 전선 지우기(되돌리기) : 다시 0으로 돌리기
				setStatus(r, c, d, 0);
			}
		}
		// 해당 코어 비선택
		// 아무런 전선도 x하고 다음 코어로 넘어가자
		go(index+1, cCnt, lCnt);
		
	}
	static boolean isAvalable(int r, int c, int d) {
		int nr=r, nc = c;
		while(true) {
			nr+=dr[d];
			nc+=dc[d];
			if(!check(nr, nc)) break;
			if(map[nr][nc]>=1) return false; //1코어 2 전선
		}
		return true;
	}
									//전선 놓기 : s=2,  지우기 s=0
	static int setStatus(int r, int c, int d, int s) {
		int nr =r, nc = c, cnt=0;
		while(true) {
			nr +=dr[d];
			nc +=dc[d];
			if(!check(nr, nc)) break;
			map[nr][nc] = s;
			++cnt;
		}
		return cnt;
	}
	private static boolean check(int nr, int nc) {
		if(nr>=0 && nr<N && nc>=0 && nc<N) return true;
		return false;
	}
}