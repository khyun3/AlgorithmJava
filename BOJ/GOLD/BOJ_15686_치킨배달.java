package GOLD;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_15686_치킨배달 {
	static int N,M, answer = Integer.MAX_VALUE;
	static int[][] map;
	static List<Point> chicken = new LinkedList<>();
	static List<Point> houses = new LinkedList<>();
	static int[] select,d;
	static class Point{
		int r;
		int c;
		public Point(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new int [N][N];
		select = new int[M];
		//고른 치킨집 간의 거리
		d = new int[M];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				
				if(map[i][j]==1)
					houses.add(new Point(i,j)); //치킨집 좌표 기억
				if(map[i][j]==2)
					chicken.add(new Point(i,j)); //집 좌표 기억
			}
		}
		
		//가장 짧은 거리의 조합을 구한다.
		nCr(0,0);
		System.out.println(answer);
	}
	static int dist(Point h, Point c) {
				return Math.abs(c.r-h.r) + Math.abs(c.c-h.c);
	}
	static void nCr(int cnt, int start) {
		if(cnt==M) {	
			int sumDist = 0;
			//집들을 다 확인하는데, 가장 가까운 치킨집을 찾는다.
			for (int i = 0; i < houses.size(); i++) { //house중
				int minDist = Integer.MAX_VALUE;
				for (int j = 0; j < M; j++) { //고른 치킨집에서 가장 가까운 치킨 집은?
					minDist = Math.min(minDist, dist(houses.get(i),chicken.get(select[j]))); //해당 치킨집의 i번째 집의 거리
				}
				sumDist +=minDist;
			}
			answer = Math.min(sumDist, answer);
			return;
		}
		
		for (int i = start; i < chicken.size(); i++) {
			select[cnt] = i; //치킨집을 고르자
			nCr(cnt+1,i+1);
		}
	}
}