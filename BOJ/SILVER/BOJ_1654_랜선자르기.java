package SILVER;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1654_랜선자르기 {
	public static void main(String[] args)throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		
		long K = Long.parseLong(st.nextToken()); //영식이가 가진 랜선 수
		long N = Long.parseLong(st.nextToken()); //필요 개수
		long [] lan = new long[(int)K];
		
		long high = 0;
		for (int i = 0; i < K; i++) {
			lan[i] = Long.parseLong(br.readLine());
			if(high<lan[i]) high = lan[i];
		}
		
		System.out.println(binarySearch(lan, high, N));
	}

	private static long binarySearch(long[] lan, long high, long n) {
		long last = high;
		long first = 0;
		long mid = 0;
		long lanCnt = 0;
		
		while(first<=last) {
			lanCnt = 0;
			mid = (last+first)/2;
			
			if(mid==0) return 1;
			for (int i = 0; i < lan.length; i++) {
				
				lanCnt += lan[i]/mid;
			}
		
			if (lanCnt >= n) {
				first = mid + 1;
				
			} else {
				last = mid - 1;
			}
		}
		return last;
	}
}