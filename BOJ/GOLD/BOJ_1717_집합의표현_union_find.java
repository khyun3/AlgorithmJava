package GOLD;

import java.util.Scanner;

public class BOJ_1717_집합의표현_union_find {
	static int N,M;
	static int O,A,B;  
	static int [] parents, rank;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		parents = new int[N+1];
		rank = new int[N+1];
		MakeSet();
		for (int i = 0; i < M; i++) {
			O = sc.nextInt();
			A = sc.nextInt();
			B = sc.nextInt();
			
			if(O == 0) { //합
				union(A,B);
			}
			else if(O == 1) { // yes or no
				if(find(A) == find(B)) {
					System.out.println("YES");
				}
				else
					System.out.println("NO");
			}
		}
	}
	private static void MakeSet() {
		for (int i = 0; i <N+1; i++) {
			parents[i] = i;
		}
	}
	private static int find(int a) {
		if(parents[a] == a) return a;
		return parents[a] = find(parents[a]);
	}
	private static void union(int a, int b) {
		a = find(parents[a]);
		b = find(parents[b]);
		
		if(a!=b) { 
			if(rank[a]<rank[b]) {
				parents[a] = b;
			}
			else {
				parents[b] = a;
				
				if(rank[a] == rank[b]) {
					rank[a]++;
				}
			}
		}
	}
}