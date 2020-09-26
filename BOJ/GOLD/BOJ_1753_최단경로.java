package GOLD;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_1753_최단경로 {
	static class Edge { 	//u->v로 가는 가중치 w인 간선이 있다. //인접리스트를 이용해본다.
		int v;
		int w;
		public Edge(int v, int w) {
			this.v = v;
			this.w = w;
		}
	}
	
	static int V, E, K; //정점, 간선, 시작 정점
	static int[] distance;
	static boolean[] visited;
	static final int INFINITY = Integer.MAX_VALUE;
	static List<Edge> [] adj;
	public static void main(String[] args) throws Exception {
		//시작에서 i까지 가는 최단 경로값
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		
		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(br.readLine());
		
		adj = new ArrayList[V]; //인접 리스트를 만든다.
		for (int i = 0; i < adj.length; i++) {
			adj[i] = new ArrayList<>();
		}
		
		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken()); 
			int w = Integer.parseInt(st.nextToken());
			adj[u-1].add(new Edge(v-1,w));
		}
		
		distance = new int[V];    //각 정점마다 최소 값을 갱신할 배열
		visited = new boolean[V]; //방문했나 확인해보자(최소 값으로 갱신 ok?)
		
		dijstra();
		for (int i = 0; i < V; i++) {
			if(distance[i]==Integer.MAX_VALUE)
				System.out.println("INF");
			else
				System.out.println(distance[i]);
		}
	}

	private static void dijstra() {
		// 디스턴스 배열에 모든 값을 무한으로 바꾼다.
		Arrays.fill(distance, INFINITY);

		distance[K - 1] = 0; // 시작점을 표시하고 자기 자신이 자기 자신에게 가는 거리는 0이므로 0을 넣는다.

		for (int i = 0; i < V; i++) {
			int min = Integer.MAX_VALUE;
			int index = -1;
			
			for (int j = 0; j < V; j++) {
				if (!visited[j] && min > distance[j]) {
					min = distance[j];
					index = j;
				}
			}
			if (index == -1)
				break;
			for (Edge ne : adj[index]) {
				if (!visited[ne.v] && (distance[ne.v] > (distance[index]) + ne.w)) {
					distance[ne.v] = min + ne.w;
				}
			}
			visited[index] = true;
		}
	}
}