package Programmers;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class 카카오프렌즈_컬러링북 {
	static boolean visited[][];
	static int dir[][] = new int [][] {{-1,0},{1,0},{0,-1},{0,1}};
	public static void main(String[] args) throws Exception {
		
		
		int m = 6;
		int n = 4;
		int[][] picture = { {1,1,1,0},
							{1,2,2,0},
							{1,0,0,1},
							{0,0,0,1},
							{0,0,0,3},
							{0,0,0,3}};
		
		System.out.println(Arrays.toString(solution(m, n,picture)));
	}
	static int[] solution(int m, int n , int [][] picture) {
		visited = new boolean[m][n];
		
		int[] answer = new int[2];
		int numberOfArea = 0;
        int maxSizeOfOneArea = 0;
        
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if(!visited[i][j] && picture[i][j]!=0) {
					int tmp = 0;
					tmp = bfs(m, n, i, j, picture);
					maxSizeOfOneArea = Math.max(tmp, maxSizeOfOneArea);
					numberOfArea++;
				}
			}
		}
		answer[0] = numberOfArea;
        answer[1] = maxSizeOfOneArea;
        return answer;
	}
	
	static int bfs(int m, int n, int r, int c, int [][] picture) {
		
		Queue<int []> que = new LinkedList<>();
		que.offer(new int [] {r, c});
		visited[r][c] = true;
		int picSize = 1;
		
		while(!que.isEmpty()) {
			int [] curr = que.poll();
			
			for (int i = 0; i < 4; i++) {
				int nr = curr[0] + dir[i][0];
				int nc = curr[1] + dir[i][1];
				
				if(!check(nr,nc, m, n) || visited[nr][nc] || picture[nr][nc]!=picture[r][c]) continue;
				picSize++;
				visited[nr][nc] = true;
				que.offer(new int [] {nr,nc});
			}
		}
		return picSize;
	}
	static boolean check(int nr, int nc, int m, int n) {
		return nr>=0 && nr<m && nc>=0 && nc<n;
	}
//	static void print(int [][] picture) {
//		System.out.println();
//		for (int i = 0; i < 6; i++) {
//			for (int j = 0; j < 4; j++) {
//				System.out.print(picture[i][j]+" ");
//			}
//			System.out.println();
//		}
//	}
}
