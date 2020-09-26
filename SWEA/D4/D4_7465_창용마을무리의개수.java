package D4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class D4_7465_창용마을무리의개수 {
	static int T, N, M,cnt;
	static int [] parents;
	static int [] rank;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		T = Integer.parseInt(br.readLine());
		
		for (int t = 1; t <=T; t++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			
			parents = new int[N];
			rank = new int[N];
			for (int i = 0; i < N; i++) { //우선 각사람을 하나의 집합으로 본다.
				parents[i] = i;
			}
			
			for (int i = 0; i < M; i++) { //M만큼 관계를 입력받는다.
				st = new StringTokenizer(br.readLine());
				int x= -1, y=-1;
				if(st.hasMoreTokens()) {
					x = Integer.parseInt(st.nextToken())-1;

				}
				if(st.hasMoreTokens()) {
					y = Integer.parseInt(st.nextToken())-1;
					union(x,y); // x<-y
				}
			}
			cnt = 0;
			for (int i = 0; i < N; i++) {
				if(parents[i] == i) {
					cnt++;
				}
			}
			System.out.println("#"+t+" "+cnt);
		}
	}
	static void union(int x, int y) {
		int a = find(x);
		int b = find(y);
		
		if(a==b) return; //만약 부모가 같다면 종료
		
		if(rank[a]<rank[b]) { //만약에 b의 rank가 더 높다면 b에 a를 붙인다.
			parents[a] = b;
		}
		else { 							//a가 더 높거나 같은 경우
			parents[b] = a;
			if(rank[a]==rank[b]) {  //랭크가 같다면 a에 +1
				rank[a]++;
			}
		}
	}
	private static int find(int x) {
		if(parents[x] == x) return x;
		return parents[x] = find(parents[x]);
	}
}