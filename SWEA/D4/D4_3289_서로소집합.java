package D4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class D4_3289_서로소집합 {
	static int [] parents;
	static int T, N, M;
	public static void main(String[] args)throws Exception {
	 BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	 StringTokenizer st = null;
	 T = Integer.parseInt(br.readLine());
		
	 for (int t = 1; t <= T; t++) {
		StringBuilder sb = new StringBuilder();
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		sb.append("#").append(t).append(" ");
		
		parents = new int [N+1];
			for (int i = 1; i < N+1; i++) {
				parents[i] = i;
			}
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int f = Integer.parseInt(st.nextToken());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			switch(f){
				case 0:
					union(a, b); 
					break;
				case 1:
					if(find(a) == find(b)) {
						sb.append("1");
					}
					else
						sb.append("0");
					break;
			}
		}
		System.out.println(sb.toString());
	 }
	 
	}
	private static int find(int a) {
        if(parents[a] == a) return a;
        return parents[a] = find(parents[a]);
    }
    private static void union(int a,int b) {
        int pa = find(a);
        int pb = find(b); 
        if(pa != pb) parents[pb] = pa;
    }
}