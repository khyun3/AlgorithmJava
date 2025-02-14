package BOJ.GOLD;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_17471_게리맨더링 {

	static int min=Integer.MAX_VALUE, pSum, adjMtrx[][];
	public static void main(String[] args)throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		adjMtrx = new int[N][N];
		int p[] = new int [N];
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		for (int i = 0; i < N; i++) {
			p[i] = Integer.parseInt(st.nextToken());
			pSum+=p[i];
		}
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine()," ");
			int k = Integer.parseInt(st.nextToken());
			for (int j = 0; j < k; j++) {
				adjMtrx[i][j]= adjMtrx[j][i] = Integer.parseInt(st.nextToken())-1;
			}
		}
		subSet(0, 0, new ArrayList<String>(), N, p);
	}
	private static void subSet(int cnt, int sum, ArrayList<String> arr, int n, int [] p) {
		if(cnt==n) {
			if(sum==0) return;
			boolean [] isOk = new boolean[n];
			Queue<Integer> que = new LinkedList<Integer>();
			for (String s : arr)
				que.offer(Integer.parseInt(s));
			
			while(!que.isEmpty()) {
				
			}
			return;
		}
		
		arr.add(cnt+"");
		subSet(cnt+1, sum+p[cnt], arr, n, p);
		arr.remove(cnt+"");
		subSet(cnt+1, sum+p[cnt], arr, n, p);
	}
}
