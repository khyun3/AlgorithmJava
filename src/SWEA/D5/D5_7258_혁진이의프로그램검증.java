package SWEA.D5;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class D5_7258_혁진이의프로그램검증 {
	static int R,C;
	static char[][] map;
	static int [][] visited;
	static boolean answer;
	public static void main(String[] args)throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		
		for (int t = 1; t <= T; t++) {
			st = new StringTokenizer(br.readLine()," ");
			R = Integer.parseInt(st.nextToken());
			C = Integer.parseInt(st.nextToken());
			visited = new int [R][C];
			map = new char[R][];
			answer = false;
			for (int i = 0; i < R; i++) {
				map[i] = br.readLine().toCharArray();
			}
			//로직 ㄱ
			solve(4, 0, 0, 0, 0);
			sb.append('#').append(t).append(" ").append(answer ? "YES" : "NO").append('\n');
		}
		System.out.print(sb);
	}
	private static void solve(int dir, int r, int c, int vCnt, int memory) {
		if(vCnt==3) {
			return;
		}
		if(map[r][c] == '<') {
			
		}
		switch(map[r][c]) {
		case '>':
			break;
		case '<':
			break;
		case '^':
			break;
		case 'v':
			break;
		case '_':
			break;
		case '|':
			break;
		case '?':
			break;
		case '.':
			break;
		case '@':
			break;
		case '+':
			break;
		case '-':
			break;
		default :
			break;
		}
		
	}
}
