package SILVER;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_17085_십자가2개놓기 {
	static int R, C, max=1, arr[];
	static int [] dr = {-1,1,0,0}, dc = {0,0,-1,1};
	static char [][] map;
	static List<int []> cross = new ArrayList<>();
	static boolean [] visited;
	public static void main(String[] args)throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		map = new char [R][];
		arr = new int [2];
		for (int i = 0; i < R; i++) {
			map[i] = br.readLine().toCharArray();
		}
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if(crossCheck(i,j)) {
					cross.add(new int [] {i,j}); //십자가 모양이 있는 곳
				}
			}
		}
		visited = new boolean [cross.size()];
		SingleCountMaxCross();
		if(cross.size()>1) nPr(0);
		System.out.println(max);
	}
	private static void nPr(int cnt) {
		
		//크로스 부분 2개 이상
		if(cnt==2) {
			max = Math.max(max, countMaxCross());
			return;
		}
		for (int i = 0; i < cross.size(); i++) {
			if(visited[i]) continue;
			arr[cnt] = i;
			visited[i] = true;
			nPr(cnt+1);
			visited[i] = false;
		}
		
	}
	private static void SingleCountMaxCross() {
		for (int [] q : cross) {
			int k = 1;
			a:while(true) {
				for (int i = 0; i < 4; i++) {
					int nr = q[0]+dr[i]*k;
					int nc = q[1]+dc[i]*k;
					if(!check(nr,nc) || map[nr][nc]!='#') {break a;}
					if(i==3)k++;
				}
			}
			max = Math.max((k-1)*4+1, max);
		}
	}
	private static int countMaxCross() {
		boolean [][] visit = new boolean[R][C];
		int [] k = {1,1};
		int [] a = cross.get(arr[0]); //선택한 1번 점
		int [] b = cross.get(arr[1]); //선택한 2번 점
		visit[a[0]][a[1]] = true;
		visit[b[0]][b[1]] = true;
		
		boolean [] flag = new boolean [2];
		ArrayList<int []> aList = new ArrayList<>();
		while(true) {
			//a
			if(!flag[0]) {
				//System.out.print("A"+flag[0]+"  ");
				aList.clear();
				for (int i = 0; i < 4; i++) {
					int nr = a[0]+dr[i]*k[0];
					int nc = a[1]+dc[i]*k[0];
					if(!check(nr,nc) || visit[nr][nc] || map[nr][nc]!='#') {
						flag[0]=true;
						break;
					}
					aList.add(new int [] {nr,nc});
					if(i==3) {
						for (int[] l : aList) {
							visit[l[0]][l[1]] = true;
						}
						k[0]++;
					}
				}
			}
			//b
			if(!flag[1]) {
				//System.out.println("B"+flag[1]);
				aList.clear();
				for (int i = 0; i < 4; i++) {
					int nr = b[0]+dr[i]*k[1];
					int nc = b[1]+dc[i]*k[1];
					if(!check(nr,nc) || visit[nr][nc] || map[nr][nc]!='#') {
						flag[1]=true;
						break;
					}
					aList.add(new int [] {nr,nc});
					if(i==3) {
						for (int[] l : aList) {
							visit[l[0]][l[1]] = true;
						}
						k[1]++;
					}
				}
			}
			if(flag[0] && flag[1]) break;
		}
//		print(visit);
//		System.out.println(((k[0]-1)*4+1)+"  "+ ((k[1]-1)*4+1));
		return ((k[0]-1)*4+1)*((k[1]-1)*4+1);
	}
	private static void print(boolean[][] v) {
		System.out.println();
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				System.out.print(v[i][j] ? 1 +" " : 0 +" ");
			}
			System.out.println();
		}
	}
	private static boolean crossCheck(int r,int c) {
		if(map[r][c]!='#') return false;
		for (int d = 0; d < 4; d++) {
			int nr = r + dr[d];
			int nc = c + dc[d];
			if(!check(nr,nc)) return false;
			if(map[nr][nc]!='#') return false;
		}
		return true;
	}
	private static boolean check(int nr, int nc) {
		if(nr>=0 && nr<R && nc>=0 && nc<C) return true;
		return false;
	}
}