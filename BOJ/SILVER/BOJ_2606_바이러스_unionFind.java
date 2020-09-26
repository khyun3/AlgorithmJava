package SILVER;

import java.util.Arrays;
import java.util.Scanner;

public class BOJ_2606_바이러스_unionFind {
	static int [] parent, rank;
	static int N, P, answer=0;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		P = sc.nextInt();
		parent = new int [N];
		
		makeSet(N);
		for (int i = 0; i < P; i++) {
			int x = sc.nextInt()-1;
			int y = sc.nextInt()-1;
			union(x,y);
			System.out.println(Arrays.toString(parent));
		}
		for (int i = 1; i <N; i++) {
			if(find(i) == find(0)) answer++;
		}
		System.out.println(answer);
	}
	private static void makeSet(int n) {
		for (int i = 0; i < n; i++) {
			parent[i] = i;
		}	
	}
	private static void union(int x, int y) {
		x = find(x);
		y = find(y);
		
		if(x==y) {return;}
		
		parent[y] = x;
	}
	private static int find(int a) {
		if(parent[a] == a) return a;
		return parent[a] = find(parent[a]);
	}
}