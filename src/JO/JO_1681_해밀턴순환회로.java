package JO;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class JO_1681_해밀턴순환회로 {
	static int N, min = Integer.MAX_VALUE;
	static int[][] adjMatrix;
	static boolean [] visited;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		N = Integer.parseInt(br.readLine());
		
		adjMatrix = new int[N][N];	//인접행렬 만들기
		visited = new boolean[N];	//각 정점 방문 체크
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine()," ");
			for (int j = 0; j < N; j++) {
				adjMatrix[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		dfs(0,0,0);
		
		System.out.println(min);
	}

	private static void dfs(int cnt, int r, int tot) { 
		if(tot>min) return;						//tot보다 min값이 작으면 그냥 return(가지치기)
		if(cnt==N-1 && adjMatrix[r][0]!=0) {	//cnt가 n-1개를 선택했고, 인접행렬에서 마지막 방문 정점에서 0으로 돌아오는 값이 0이 아닐 때 
			tot+=adjMatrix[r][0];			    //마지막으로 방문한 정점에서 시작 정점으로 돌아온다.
			if(tot<min) min = tot; 
			return;
		}
		for (int i = 1; i < N; i++) { 			   //첫 시작정점은 건너뛴다. 무조건 0
			if(!visited[i] && adjMatrix[r][i]>0) { //방문x이면서 0이 아닐 때
				visited[i] = true;
				dfs(cnt+1, i, tot+adjMatrix[r][i]);
				visited[i] = false;
			}
		}
	}
}