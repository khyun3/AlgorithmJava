package SWEA.D4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;

public class D4_1249_보급로 {
	static class Edge implements Comparable<Edge>{
		int dest;   //목적지
		int weight; //가중치

		public Edge(int dest, int weight) {
			this.dest = dest;
			this.weight = weight;
		}
		@Override
		public int compareTo(Edge o) {
			return Integer.compare(this.weight, o.weight);
		}
	}
	
	static int N, map[][], answer;
	static int[] dr = {-1,1,0,0};
	static int[] dc = {0,0,-1,1};
	public static void main(String[] args)throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		
		for (int t = 1; t <= T; t++) {
			N = Integer.parseInt(br.readLine());
			answer = Integer.MAX_VALUE;
			map = new int[N][N];
			
			for (int i = 0; i < N; i++) {
				char [] tmp = br.readLine().toCharArray();
				for (int j = 0; j < N; j++) {	
					map[i][j]=tmp[j]-'0';
				}
			}//맵을 만들기 끝
			
			
			sol(0,0, N-1, N-1);
			System.out.println("#"+t+" "+answer);
			
		}
	}
	private static void sol(int sr, int sc, int er, int ec ) {
		PriorityQueue<Edge> pq = new PriorityQueue<Edge>();
		boolean [] visit = new boolean [N*N];
		int [] distance = new int [N*N]; 
		
		// 각 정점점에 연결될 수 있는 edge들을 list에 넣어야 하기 떄문에 만드는 list
		 ArrayList<Edge>[] edge = new ArrayList[N*N];

		//최소값 배열을 모두 INF로 초기화하고 각 정점의 edge들을 만든다.
		for (int i = 0; i < N*N; i++) {
			distance[i] = Integer.MAX_VALUE;
			edge[i] = new ArrayList<Edge>();
		}
		
		//시작점과 시작점의 사이 거리 == 0
		distance[0] = 0;

		//간선 정보 입력 시작
		for (int i = 0; i < N; i++) { //간선 정보를 edge에 넣어준다.
			for (int j = 0; j < N; j++) {
				
				for (int d = 0; d < 4; d++) { //4방향을 보고 간선을 넣어주자
					int nr = i + dr[d];
					int nc = j + dc[d];
					
					if(nr<0 || nr>=N || nc<0 || nc>=N || (nr==0 && nc==0)) continue;
					edge[i*N+j].add(new Edge(nr*N+nc, map[nr][nc]));
				}
			}
		} //간선 정보 입력 끝
			
		pq.offer(new Edge(0, 0));
		while(!pq.isEmpty()) {
			Edge curr = pq.poll();
			
			if(visit[curr.dest]) continue; //해당 정점이 이미 방문 했다면 넘긴다.
			visit[curr.dest] = true;		//해당 정점을 방문처리 한다.
			for (Edge k : edge[curr.dest]) { //각 정점에서 연결되어 있는 간선의 최소값 찾기
				if(!visit[k.dest]) { 	 	 //방문한 점이 아니면
					distance[k.dest] = Math.min(distance[k.dest], distance[curr.dest]+k.weight);
					pq.offer(new Edge(k.dest, distance[k.dest]));
				}
			}
		}
		answer = distance[N*N-1];
	}
}