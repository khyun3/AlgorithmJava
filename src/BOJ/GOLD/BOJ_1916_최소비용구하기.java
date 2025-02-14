package BOJ.GOLD;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_1916_최소비용구하기 {
	static class Edge implements Comparable<Edge> {
		int dest;
		int weight;

		@Override
		public int compareTo(Edge o) {
			return Integer.compare(this.weight, o.weight); // 오름차순
		}

//		@Override
//		public String toString() {
//			return "Edge [dest=" + dest + ", weight=" + weight + "]";
//		}

		public Edge(int dest, int weight) {
			this.dest = dest;
			this.weight = weight;
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;

		int N = Integer.parseInt(br.readLine());// 도시의 개수
		int M = Integer.parseInt(br.readLine());// 버스의 개수

		// 인접리스트
		ArrayList<Edge>[] adjList = new ArrayList[N];
		for (int i = 0; i < N; i++) {
			adjList[i] = new ArrayList<Edge>();
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int sv = Integer.parseInt(st.nextToken())-1; // 출발 정점
			int dv = Integer.parseInt(st.nextToken())-1; // 목적 정점
			int w = Integer.parseInt(st.nextToken()); // 가중치

			adjList[sv].add(new Edge(dv, w)); // 간선정보 저장
		}
		st = new StringTokenizer(br.readLine(), " ");
		int startVertex = Integer.parseInt(st.nextToken()) - 1; // 시작 정점
		int EndVertex = Integer.parseInt(st.nextToken()) - 1; // 목적 정점(출력할 정점)

		///////////////// dij////////////////////
		int[] dist = new int[N]; // 최소거리를 저장할 dist 배열
		boolean[] visit = new boolean[N];
		
		Arrays.fill(dist, Integer.MAX_VALUE);

		dist[startVertex] = 0;

		PriorityQueue<Edge> pq = new PriorityQueue<>();
		pq.offer(new Edge(startVertex, 0)); // 시작정점 넣기
		
		while (!pq.isEmpty()) {
			Edge curr = pq.poll();

			// 방문 정점 체크
			if(visit[curr.dest]) continue;

			visit[curr.dest] = true; // 방문 체크
		
			// 현 정점에서 목적지
			for (Edge k : adjList[curr.dest]) {
				if (!visit[k.dest]) {
					dist[k.dest] = Math.min(dist[k.dest], dist[curr.dest] + k.weight);
					pq.offer(new Edge(k.dest, dist[k.dest]));
				}
			}
		}
		//System.out.println(Arrays.toString(dist));
		System.out.println(dist[EndVertex]);
	}
}