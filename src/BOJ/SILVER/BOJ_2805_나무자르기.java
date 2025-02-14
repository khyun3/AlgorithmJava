package BOJ.SILVER;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2805_나무자르기 {
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		long [] tree = new long [N];
		st = new StringTokenizer(br.readLine()," ");
		
		long high = 0;
		for (int i = 0; i < N; i++) {
			tree[i] = Integer.parseInt(st.nextToken());
			high = Math.max(tree[i], high);
		}
		
		System.out.println(binarySearch(tree, high,M));
	}

	private static long binarySearch(long[] tree, long high, int M) {
		long first = 0;
		long last = high;
		long mid = 0;
		long sum = 0;
		
		while(first<=last) {
			sum = 0;
			mid = (first+last)/2;
			
			for (int i = 0; i < tree.length; i++) {
				if(tree[i]>mid)
					sum += tree[i] - mid;
			}
			System.out.println(sum);
			if(sum==M) {
				return mid;
			}
			else {
				if(sum<M)
					last = mid - 1;
				else
					first = mid + 1; //sum이 더 크다면
			}
		}
		return last;
	}
}