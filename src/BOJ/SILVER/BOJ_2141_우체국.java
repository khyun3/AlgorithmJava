package BOJ.SILVER;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_2141_우체국 {
	static class City implements Comparable<City>{
		int l; int p;
		
		public City(int l, int p) {	this.l = l; this.p = p;}
		
		@Override
		public int compareTo(City o) {
			return Integer.compare(this.l,o.l);
		}

		@Override
		public String toString() {
			return "["+l+", " +p+ "] ";
		}
		
	}
	public static void main(String[] args)throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());
		long pMax = 0;
		
		City [] c = new City[N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine()," ");
			int l = Integer.parseInt(st.nextToken());
			int p = Integer.parseInt(st.nextToken());
			c[i] = new City(l, p);
			pMax += p;
		}
		Arrays.sort(c);
		System.out.println(Arrays.toString(c));
		long pTmp = pMax;
		long div = pMax/2;
		
		for (int i = 0; i < c.length; i++) {
			pTmp -=c[i].p;
			if(pTmp<=div) {
				System.out.println(c[i].l);
				break;
			}
		}
	}
}