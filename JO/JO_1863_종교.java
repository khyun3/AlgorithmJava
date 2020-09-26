import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class JO_1863_종교 {
	static int N,M;
	static int [] parent;
	public static void main(String[] args)throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		parent = new int [N+1];
		for (int i = 1; i < N+1; i++) {
			parent[i] = i;
		}
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			union(a,b);
		}
		int answer = 0;
		for (int i = 1; i <N+1; i++) {
			if(parent[i] == i) {
				answer++;
			}
		}
		System.out.println(answer);
	}
	private static int find(int a) {
		if(parent[a]== a) return a;
		return parent[a] = find(parent[a]);
	}
	private static void union(int a, int b) {
		int pa = find(a);
		int pb = find(b);
		if(pa != pb) parent[pb] = pa;
	}
}