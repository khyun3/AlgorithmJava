package GOLD;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_1987_알파벳 {
	static int R, C, MAX=1;
	static int [] dr = {-1,1,0,0};
	static int [] dc = {0,0,-1,1};
	static char [][] map;
	static boolean [] visited = new boolean[26];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine().trim());
		
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		map = new char[R][];
		
		for (int i = 0; i < R; i++) {
			map[i] = br.readLine().toCharArray();
			
		}
		go(0,0,1);
		
		System.out.println(MAX);
	}
	private static void go(int r, int c, int cnt) {

		visited[map[r][c]-'A'] = true;	//현재 위치 방문 처리
		if(cnt>MAX) MAX = cnt;			//MAX값 갱신
		if(cnt == 26) return;			//알파벳 총 개수 = 26개
		int nr, nc;						//4방검사
		for (int d = 0; d <4; d++) {
			nr = r + dr[d]; 
			nc = c + dc[d];
			
			if(!check(nr,nc)) continue;
			if(visited[map[nr][nc]-'A']) continue; //만약에 이미 방문한 알파벳이라면? 
//			print();
			go(nr,nc,cnt+1);	//dfs
		}
		visited[map[r][c]-'A'] = false; //해당 위치에서 4방을 다 봤으면 풀어줌
	}
//	private static void print() {
//		System.out.println();
//		for (int i = 0; i < R; i++) {
//			for (int j = 0; j < C; j++) {
//				System.out.println("CNT : "+MAX +"  "+Arrays.toString(visited));
//			}
//		}
//	}
	private static boolean check(int nr, int nc) {
		if(nr>=0 && nr<R && nc>=0 && nc<C) return true;
		return false;
	}
}