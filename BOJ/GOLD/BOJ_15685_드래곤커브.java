package GOLD;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class BOJ_15685_드래곤커브 {

	static int [] dx= {0,-1,0,1}, dy={1,0,-1,0};//우상좌하
	static boolean map [][];
	//우 -> 상  0 -> 1 
	//상 -> 좌  1 -> 2
	//좌 -> 하  2 -> 3
	//하 -> 우  3 -> 0
	public static void main(String[] args)throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		map = new boolean [101][101]; //char 2byte boolean 1btye
		int x,y,d,g;
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			y = Integer.parseInt(st.nextToken()); //열값
			x = Integer.parseInt(st.nextToken()); //행값
			d = Integer.parseInt(st.nextToken()); //방향 
			g = Integer.parseInt(st.nextToken()); //세대
			map[x][y] = true;
			dxagonCurve(x,y,d,g);
		}
		System.out.println(count());
	}
	private static int count() {
		int cnt=0;
		for (int i = 1; i < 101; i++) {
			for (int j = 0; j < 100; j++) {
				if(map[i][j] && map[i+-1][j] && map[i+-1][j+1] && map[i][j+1]) {
					cnt++;
				}
			}
		}
		return cnt;
	}
	private static void dxagonCurve(int x, int y, int d, int g) {
		//1. x,y점에서 d를 보고 0세대를 만든다.
		ArrayList<Integer> dir = new ArrayList<>();
		int nx = x+dx[d];
		int ny = y+dy[d];
		dir.add(d);
		map[x+dx[d]][y+dy[d]] = true;
		
		for (int i = 0; i < g; i++) { //1세대부터 
			int size = dir.size()-1;
			
			for (int j = size; j>=0 ; j--) {
				int curr = (dir.get(j)+1)%4;
				nx +=dx[curr]; 
				ny +=dy[curr];
				dir.add(curr);
				map[nx][ny] = true;
			}
		}
	}
}