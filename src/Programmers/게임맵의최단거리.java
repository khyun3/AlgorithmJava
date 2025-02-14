package Programmers;

import java.util.LinkedList;
import java.util.Queue;

public class 게임맵의최단거리 {
	static int maps[][], N, M;
	
	public static void main(String[] args) {
		maps = new int[][] {{1,0,1,1,1},{1,0,1,0,1},{1,0,1,1,1},{1,1,1,0,1},{0,0,0,0,1}};
		solution(maps);
		maps = new int[][] {{1,0,1,1,1},{1,0,1,0,1},{1,0,1,1,1},{1,1,1,0,0},{0,0,0,0,1}};
		solution(maps);
	}
	static public int solution(int[][] maps) {
        int answer = 0;
        //끝 점
        N = maps.length;
        M = maps[0].length;
        answer = bfs(0,0);
        System.out.println(answer);
        return answer;
    }
	static int bfs(int sr, int sc) {
		Queue<int []> que = new LinkedList<>();
		que.offer(new int [] {sr, sc, 1});
		maps[sr][sc] = 9;
		int dir[][] = new int[][] {{-1,0},{1,0},{0,-1},{0,1}}; 
		int curr[] = null;
		
		while(!que.isEmpty()) {
			curr = que.poll();
			for (int i = 0; i < 4; i++) {
				int nr = curr[0] + dir[i][0];
				int nc = curr[1] + dir[i][1];
				
				if(!check(nr,nc) || maps[nr][nc]==9 || maps[nr][nc]==0) continue;
				maps[nr][nc] = 9;
				que.offer(new int[] {nr, nc, curr[2]+1});
				if(nr==N-1 && nc==M-1) {
					return curr[2]+1;
				}
			}
		}
		return -1;
	}
	static boolean check(int nr, int nc) {
		return nr>=0 && nr<N && nc>=0 && nc<M;
	}
}
