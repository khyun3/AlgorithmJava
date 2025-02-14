package BOJ.SILVER;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BOJ_1697_숨바꼭질 {
	static int N, K;
	static int min=Integer.MAX_VALUE;
	static boolean[] checked;
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt(); //수빈의 위치
		K = sc.nextInt(); //동생의 위치
		checked = new boolean[100001];
		if(N==K) {
			System.out.println(0);
			return;
		}
		if(K==0) {
			System.out.println(N);
			return;
		}
		bfs(N, K, 0);
	}
	private static void bfs(int X, int k, int cnt) {
		Queue<int []> que = new LinkedList<int[]>();
		//순간이동 2*X   걷기: +1, -1
		que.offer(new int [] {X, cnt});	
		checked[X] = true;
		while(!que.isEmpty()) {
			int size =  que.size();
			int [][] tmp = new int[size][];
			
			for (int i = 0; i < size; i++) {
				tmp[i] = que.poll();		//해당 레벨의 모든 경우를 큐에서 뺀다.
				checked[tmp[i][0]] = true;
			}
			
			for (int i = 0; i < size; i++) { //동생위치랑 같은가?
				if(tmp[i][0]==k) {
					System.out.println(tmp[i][1]);
					return;
				}
				else {
					if(tmp[i][0]*2<=100000 && !checked[tmp[i][0]*2]) {
						que.offer(new int[] {tmp[i][0]*2,tmp[i][1]+1});
					}
					if((tmp[i][0]+1)<=100000 && !checked[tmp[i][0]+1]) {
						que.offer(new int[] {tmp[i][0]+1,tmp[i][1]+1});
					}
					if((tmp[i][0]-1)>=1 && !checked[tmp[i][0]-1]) {
						que.offer(new int[] {tmp[i][0]-1,tmp[i][1]+1});
					}
				}
			}
		}
	}
}