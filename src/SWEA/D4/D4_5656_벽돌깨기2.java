package SWEA.D4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class D4_5656_벽돌깨기2 {
	static int N,W,H, min;
	static int [] dr = {-1,1,0,0};
	static int [] dc = {0,0,-1,1}; 
	public static void main(String[] args)throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		
		for (int t = 1; t <= T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			N = Integer.parseInt(st.nextToken());//구슬
			W = Integer.parseInt(st.nextToken());//너비
			H = Integer.parseInt(st.nextToken());//높이
			
			min = Integer.MAX_VALUE;
			int [][] map = new int[H][W];
			
			for (int i = 0; i < H; i++) {
				st = new StringTokenizer(br.readLine()," ");
				for (int j = 0; j < W; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}////////////////////// 입력끝//////////////////////
			
			//N개의 공을 떨굼
			dfs(0, map);
			sb.append("#").append(t).append(" ").append(min).append("\n");
		}
		System.out.print(sb);
	}
	private static boolean dfs(int cnt, int [][] map) {
		int res = countBrick(map);
		if(res==0) {
			min = 0;
			return true;
		}
		if(cnt==N) {
			min = Math.min(countBrick(map), min);
			return false;
		}
		for (int i = 0; i < W; i++) {
			//열 우선 탐색을 통해 해당 열에 0이 아닌 최초 값의 좌표를 구한다
			int k = -1;
			for (int j=0; j < H; j++) {
				if(map[j][i]!=0) {
					k=j;
					break;
				}
			}
			//만약에 j가 H와 동일하다면 해당 열은 비었다는 소리
			
			if(-1<k && k<H) {
				int [][] mapTmp = mapCopy(map);
				mapTmp = breakBrick(mapTmp, k, i);
				if(dfs(cnt+1, mapTmp)) return true;
			}
		}
		return false;
	}
	private static int [][] breakBrick(int[][] map, int r, int c) {
		//벽돌을 뿌시자
		Queue<int []> que = new LinkedList<>();
		que.offer(new int [] {r,c, map[r][c]});
		
		while(!que.isEmpty()) {
			int[] curr = que.poll();
			// 1이면 0으로 만들고 해당 칸은 끝

			map[curr[0]][curr[1]] = 0;
			// 0이 아니라면 4방으로 해당 숫자-1만큼 이동
			for (int i = 0; i < 4; i++) {
				int nr = curr[0];
				int nc = curr[1];

				for (int j = 1; j < curr[2]; j++) {
					nr += dr[i];
					nc += dc[i];
					if (!check(nr, nc))
						continue;
					if (map[nr][nc] > 1) {
						que.offer(new int[] { nr, nc, map[nr][nc] });
					}
					map[nr][nc] = 0;
				}
			}
		}
		//벽돌을 아래로 내리자
		int [][] dropMap = new int [H][W];
		for (int i = 0; i < W; i++) {
			int k = H-1;
			for (int j = H-1; j >=0; j--) {
				if(map[j][i] !=0)
						dropMap[k--][i] = map[j][i]; 
			}
		}
		return dropMap;
	}
	private static boolean check(int nr, int nc) {
		if(nr>=0 && nr<H && nc>=0 && nc<W) return true;
		return false;
	}
	private static int[][] mapCopy(int[][] map) {
		int [][] mapTmp = new int[H][W];
		
		for (int i = 0; i < H; i++) {
			for (int j = 0; j < W; j++) {
				mapTmp[i][j] = map[i][j];
			}
		}
		return mapTmp;
	}
	private static int countBrick(int[][] map) {
		int brick=0;
		for (int i = 0; i < H; i++) {
			for (int j = 0; j < W; j++) {
				if(map[i][j]!=0)brick++;
			}
		}
		return brick;
	}
	private static void print(int[][] map) {
		System.out.println();
		for (int i = 0; i < H; i++) {
			for (int j = 0; j < W; j++) {
				System.out.print(map[i][j]+" ");
			}
			System.out.println();
		}
		
	}
}