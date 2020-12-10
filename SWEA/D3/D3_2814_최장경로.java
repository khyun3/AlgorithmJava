package D3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class D3_2814_최장경로 {
	
	static int answer, N,M; //정점, 간선의 수
	static ArrayList<Integer>[] adjList;
	static boolean [] visited;
	
	public static void main(String[] args)throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st =null;
		
		int T = Integer.parseInt(br.readLine());
		
		for (int t = 1; t <= T; t++) {
			//케이스
			st = new StringTokenizer(br.readLine()," ");
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			
			//초기화
			adjList = new ArrayList[N+1];
			for (int i = 1; i <= N; i++) {
				adjList[i] = new ArrayList<Integer>();
			}
			visited = new boolean[N+1];
			answer = 0;
			
			//인접리스트 만들기 양방향이므로 양쪽에 모두 추가한다.
			for (int i = 0; i < M; i++) {
				st = new StringTokenizer(br.readLine()," ");
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				adjList[a].add(b);
				adjList[b].add(a);
			}
			for (int j = 1; j <= N; j++) {
				visited[j] = true; //시작 정점 방문처리
				solve(j,1);
				visited[j] = false; //시작 정점 방문처리 상태 돌리기
			}
			sb.append("#").append(t).append(" ").append(answer).append('\n');
		}
		System.out.println(sb);
	}

	private static void solve(int v, int cnt) {
		//상태공간트리의 각 상태는 어느 정점에 몇번 밟고 왔는지 체크한다.
		answer = Math.max(answer, cnt);
		for (int nv : adjList[v]) { //v와 연결된 정점 모두에 대해
			if(visited[nv]) continue; //이미 방문했다면 pass
			visited[nv] = true; //아니라면 방문 체크
			solve(nv, cnt+1);	//다음 경로를 보러가자
			visited[nv] = false; //방문이 끝났으면 다시 방문을 풀어줌
		}
	}
}
