package GOLD;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_1504_특정한최단경로 {
   /* 1. 방향성 없는 그래프
	* 2. 1번 정점에서 N번 정점으로 가는 최단 거리 
	* 조건 
	* 1. 임의로 주어진 두 정점은 반드시 통과해야함
	* 2. 지나간 정점을 다시 지나갈 수 있다. 
	* 3. 그러한 경로가 없을 때에는 -1을 출력
	*/
	
	static class Edge implements Comparable<Edge>{
		int dest;
		long weight;
		public Edge(int dest, long weight) {this.dest = dest;	this.weight = weight;}
		@Override
		public int compareTo(Edge o) { return Long.compare(this.weight, o.weight); }
		@Override
		public String toString() {return "Edge [dest=" + dest + ", weight=" + weight + "]"; }
	}
	
	static int N, E, A, B; //정점, 간선, 꼭 지나가야하는 정점 2개
	static long [] d, d1, d2;
	static List<Edge> [] adjList;
	
	public static void main(String[] args)throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		
		N = Integer.parseInt(st.nextToken()); //정점
		E = Integer.parseInt(st.nextToken()); //간선
		
		d = new long [N];
		d1 = new long [N];
		d2 = new long [N];
		adjList = new ArrayList [N];
		
		//각 정점에 연결된 다른 정점을 넣기위해 new로 다 만들자
		for (int i = 0; i < N; i++) {
			adjList[i] = new ArrayList<Edge>();
			d[i] = Integer.MAX_VALUE;
			d1[i] = Integer.MAX_VALUE;
			d2[i] = Integer.MAX_VALUE;
		}
		
		for (int i = 0; i < E; i++) { //간선 정보 입력
			st = new StringTokenizer(br.readLine()," ");
			int sv = Integer.parseInt(st.nextToken())-1; //출발 정점
			int dv =  Integer.parseInt(st.nextToken())-1;//도착 정점
			int w = Integer.parseInt(st.nextToken());
			
			//양방향 그래프이므로 양쪽에 다 넣어줘야함
			adjList[sv].add(new Edge(dv,w)); //시작 -> 도착
			adjList[dv].add(new Edge(sv,w)); //도착 -> 시작
		}
		
		st = new StringTokenizer(br.readLine()," "); //꼭 지나가야하는 정점 입력
		A = Integer.parseInt(st.nextToken())-1;
		B = Integer.parseInt(st.nextToken())-1;
		/////////////////입력 끝//////////////////
		N = N-1;
		
		dij(d,0);
		dij(d1,A);
		dij(d2,B);
		long answer = Math.min(d[A]+d1[B]+d2[N], d[B]+d2[A]+d1[N]);
		System.out.println(answer >= Integer.MAX_VALUE ? -1 : answer);
	}
	private static void dij(long [] d, int start) {
		PriorityQueue<Edge> que = new PriorityQueue<Edge>();
		que.add(new Edge(start, 0));
		d[start] = 0;	//시작점 0처리
		while(!que.isEmpty()) {
			Edge current = que.poll();
			for (Edge k : adjList[current.dest]) {
				if(d[k.dest] > d[current.dest]+k.weight) {
					d[k.dest] = d[current.dest]+k.weight;
					que.offer(new Edge(k.dest, d[k.dest]));
				}
			}
		}
	}
}