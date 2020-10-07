package SILVER;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class BOJ_11724_연결요소의개수 {
	static int [] parents;
	static int [] rank;
	public static void main(String[] args)throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int u = 0;
		int v = 0;
		
		parents = new int [N+1];
		rank = new int [N+1];
		makeset();
		
		HashSet<Integer> ts = new HashSet<Integer>();
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine()," ");
			u = Integer.parseInt(st.nextToken());
			v = Integer.parseInt(st.nextToken());
			union(u,v);
		}
		
		for (int i = 1; i <= N; i++) {
			find(i);
			ts.add(parents[i]);
		}
		System.out.println(ts.size());
	}

	private static void makeset() {
		for (int i = 0; i < parents.length; i++) {
			parents[i] = i;
		}
	}

	private static void union(int u, int v) {
		int x = find(u);
		int y = find(v);
		
		if(x==y) return;
		if(rank[x]<rank[y]) {
			parents[x] = y;
		}
		else {
			parents[y] = x;
			if(rank[x]==rank[y]) {
				rank[x]++;
			}
		}
	}
	private static int find(int x) {
		if(x == parents[x]) return x;
		return parents[x] = find(parents[x]);
	}
}