package D4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class D4_7699_수지의_수지_맞는_여행2 {
	static int R, C ,max;
	static char [][] map;
	static int[] dr = {-1,1,0,0};
	static int[] dc = {0,0,-1,1};
	static boolean[] visited;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		for (int t = 1; t <= T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			R = Integer.parseInt(st.nextToken());
			C = Integer.parseInt(st.nextToken());
			map = new char[R][];
			visited = new boolean[26];
			max = 0;
			for (int i = 0; i < R; i++) {
				map[i] = br.readLine().toCharArray();
			}
			go(0,0,1);
			System.out.println("#"+t+" "+max);
		}	
	}
	public static void go(int r, int c, int cnt) {
		visited[map[r][c]-65] = true; //해당 알파벳을 방문했다고 표시하자
		
		if(max<cnt) max = cnt;	//max값을 변경
		if(max==26) return;		//만약 모든 명물을 봤다면
		
		int nr, nc;
		for (int d= 0; d < 4; d++) {
			nr = r + dr[d];
			nc = c + dc[d];
			
			if(nr<0 || nr>=R || nc<0 || nc>=C || visited[map[nr][nc]-65]) continue;
			go(nr,nc, cnt+1);	 
		}
		visited[map[r][c]-65] = false; //다시 풀어주자
	}
}