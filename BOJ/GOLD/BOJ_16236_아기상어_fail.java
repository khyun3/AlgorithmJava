package GOLD;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_16236_아기상어_fail {
	static class Shark{
		int r, c, size, eat, time; //r,c좌표, 크기, 먹은 수(크기만큼 먹으면 0으로 초기화), time, 출발지점부터의 거리

		public Shark(int r, int c, int time, int eat, int size) {
			this.r = r;     	this.c = c;
			this.size = size;   this.time = time;
			this.eat = eat;		
		}
	}
	static int N, answer;		  //맵크기
	static int[][] map;			  //맵
	static boolean[][] visited;	  //방문 체크
	static int[] dr = {-1,0,0,1}; //상 좌 하 우
	static int[] dc = {0,-1,1,0};

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		
		//초기화
		map = new int [N][N];
		Shark baby = null;
		visited = new boolean[N][N];
		//초기화 끝
		
		//맵 입력 시작
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine()," ");
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				
				if(map[i][j]==9) { //초기 아기 상어 위치
					baby= new Shark(i,j, 0, 0, 2);
					map[i][j] = 0;
				}
			}
		}//맵 입력 끝

		//탐색 시작
		bfs(baby);
		//탐색 끝
	}
	private static void bfs(Shark baby) {
		Queue<Shark> que = new LinkedList<>();
		que.offer(baby);
		visited[que.peek().r][que.peek().c] = true;
		
		while(!que.isEmpty()) {
			int size = que.size();
			Shark bs = null;
			E:for (int i = 0; i <size;  i++) { //레벨별로 관리한다.
				bs = que.poll();
				//4방탐색을 한다.
				for (int d = 0; d < 4; d++) {
					int nr = bs.r + dr[d]; 
					int nc = bs.c + dc[d];
					
					//맵 안의 좌표가 아니거나, 방문 했거나, 물고기의 사이즈가 아기상어보다 크다면 컨티뉴 
					if(nr<0 || nr>=N || nc<0 || nc>=N || visited[nr][nc] || map[nr][nc]>bs.size) continue;
					visited[nr][nc] = true;
					
					//eat : 물고기를 먹는다. 먹으면 먹은 수 +1, 먹은 수가 크기와 동일하다면 크기를 1증가하고 eat를 0으로 초기화
					if(map[nr][nc] != 0 && map[nr][nc]<bs.size) {
					
						if(++bs.eat == bs.size) { //물고기를 먹었을 때 사이즈랑 같은 수의 물고기를 먹었다면
							bs.size+=1;		     //사이즈를 1 증가시키고
							bs.eat=0;    		 //먹은 수를 0으로 초기화 한다.
						}
						
						map[nr][nc] = 0;  //물고기가 있던 자리의 맵을 0으로 변경한다.
						que.clear();      //먹었으니까 que를 초기화시키고
						que.offer(new Shark(nr,nc,bs.time+1,bs.eat,bs.size)); 	  //현 상태를 que에 넣는다.
						visited = new boolean[N][N];//물고기를 먹었으면 방문 배열 초기화
						answer = bs.time+1;
						visited[que.peek().r][que.peek().c] = true;
						print(bs);
						System.out.println("time : "+(bs.time+1)+"  size: "+bs.size+" eat: "+bs.eat);

						break E;
					}//eat
				
					//움직일 수 있는 공간이라면 time+1해서 큐에다가 다시 넣어준다.
					que.offer(new Shark(nr, nc, bs.time+1, bs.eat, bs.size));
				}
			}
		}
		System.out.println(answer);
	}
	static void print(Shark aa) {
		System.out.println();
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				System.out.print(map[i][j]+" ");
			}
			System.out.println();
		}
	}
}
