package SILVER;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_2667_단지번호붙이기 {
	static int N , cnt;
	static char [][] map;
	static int [][] tmap;
	static int [] R = {-1,1,0,0};
	static int [] C = {0,0,-1,1};
	static LinkedList<Integer> list = new LinkedList<>();
	public static void main(String[] args)throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		StringBuilder sb= new StringBuilder(); 
		N = Integer.parseInt(br.readLine());
		map = new char [N][N];
		tmap = new int [N][N];
		for (int i = 0; i < N; i++) {
			map[i] = br.readLine().toCharArray();
		}
		cnt = 1;
		for (int i = 0; i < N; i++) {
   			for (int j = 0; j < N; j++) {
				if(map[i][j] == '1' && tmap[i][j] == 0)
					bfs(i,j,++cnt,1);
			}
		}
		Collections.sort(list);
		sb.append(cnt-1).append("\n");
		for (int i = 0; i <list.size(); i++) {
			sb.append(list.get(i)).append("\n");
			
		}
		System.out.println(sb);
	}
	private static void bfs(int i, int j, int k, int co) {
		Queue<int[]> que = new LinkedList<>();
		que.offer(new int [] {i,j,k,co});
		int count = 0;	//해당 단지 개수
		while(!que.isEmpty()) {
			int [] qd = que.poll(); 
			tmap[i][j] =k;
			count = qd[3];
			
			for (int d = 0; d < 4; d++) {
				int nr = qd[0]+ R[d];
				int nc = qd[1]+ C[d];
				if(!check(nr,nc)) continue;
				
				if(map[nr][nc] == '1' 
						&& tmap[nr][nc]==0) {
					tmap[nr][nc] = k;
					que.offer(new int [] {nr,nc,k,++co});
				}
			}
		}
		list.add(count);
	}
	private static boolean check(int nr, int nc) {
		if(nr>=0 && nr<N && nc>=0 && nc<N) return true;
		return false;
	}
}