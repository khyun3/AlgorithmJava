package SWEA.D4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

//간적쿠 간만프 (엣지가 많을 때, 프림) 
//정점, 간선, 가중치를 입력받아서 오름차순으로 정렬한다(가중치를 조건으로)
//유니온 파인드 알고리즘으로 간선을 연결해준다.
//이 때, 만약 닫히는 구간(사이클)이 생기면 그 간선은 패스한다.
//가중치들을 다 더하는 변수로 답을 구한다.

//ex) 시간표 작성, 냉장고, sw자기방으로 가기
//최대값 구하기(1234 4321) : 8883 8838 <- 완탐으로 해야하자.
//
public class D4_3124_최소스패닝트리_fail {
	static class Node implements Comparable<Node>{

		int A;//vertex
		int B;//
		int C;//W
		@Override
		public int compareTo(Node n) {
			if(this.C-n.C > 0) return 1;
			else if(this.C-n.C < 0) return -1;
			else return 0;
		}
		public Node(int a, int b, int c) {
			A = a;
			B = b;
			C = c;
		}
		public Node() {}
	}
	static int T;
	static int [] p;
	static long res;
	public static void main(String[] args)throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		T = Integer.parseInt(br.readLine().trim());
		
		for (int t = 1; t <= T; t++) {
			
			st = new StringTokenizer(br.readLine());
			int V = Integer.parseInt(st.nextToken()); //정점
			int E = Integer.parseInt(st.nextToken()); //간선
			Queue<Node> pque = new PriorityQueue<>();
			p = new int[V+1];
			for (int i = 1; i < p.length; i++) {
				p[i] = i;
			}
			for (int i = 0; i < args.length; i++) {
				st = new StringTokenizer(br.readLine());
				int A = Integer.parseInt(st.nextToken());
				int B = Integer.parseInt(st.nextToken());
				int C = Integer.parseInt(st.nextToken());
				pque.offer(new Node(A,B,C));
			}
			res = 0L;
			while(!pque.isEmpty()) {
				Node cu = pque.poll();
				union(cu);
			}
			System.out.println("#"+t+" "+res);
		}
	}
	private static void union(Node cu) {
		int x= find(cu.A);
		int y= find(cu.B);
		if(x!=y) {
			p[y] = x;
			res+=cu.C;
		}
	}
	private static int find(int x) {
		if(x==p[x]) return x;
		else return p[x]=find(p[x]);
	}
}
