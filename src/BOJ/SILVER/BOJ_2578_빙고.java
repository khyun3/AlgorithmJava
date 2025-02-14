package BOJ.SILVER;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2578_빙고 {
	static 	boolean [][] visited;
	static int [][] map;
	static int answer=0;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		map = new int[5][5];
		visited = new boolean[5][5];
		int cnt = 0;
		for (int i = 0; i <5; i++) {
			st = new StringTokenizer(br.readLine()," ");
			for (int j = 0; j < 5; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		 for (int i = 0; i < 5; i++) {
			st = new StringTokenizer(br.readLine()," ");
			for (int j = 0; j < 5; j++) {
				int comp = Integer.parseInt(st.nextToken()); //비교할 문자
					cnt++;
					find(comp);
					if(cnt>=12)bingGo(cnt);
					if(answer>=3) {
						System.out.println(answer);
						return;
				}
			}
		}
	}

	private static void bingGo(int cnt) {
		int rcnt=0, lcnt=0, res=0;
		//오른,왼쪽 대각
		int rr=0,lr=0,rc=0,lc=4;
		for (int i = 0; i < 5; i++) {
			if(visited[rr++][rc++]) ++rcnt;
			if(visited[lr++][lc--]) ++lcnt;
			
			if(lcnt==5) res++;
			if(rcnt==5) res++;
		}
		//행 //열
		for (int i = 0; i < 5; i++) {
			rcnt=0; lcnt=0;
			for (int j = 0; j < 5; j++) {
				if(visited[i][j]) ++rcnt;
				if(visited[j][i]) ++lcnt;
				
				if(lcnt==5) res++;
				if(rcnt==5) res++;
			}
		}
		if(res>=3) answer=cnt;
	}
	//찾은곳 색칠
	static void find(int comp) {
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				if(comp == map[i][j]) visited[i][j] = true;
			}
		}	
	}
}