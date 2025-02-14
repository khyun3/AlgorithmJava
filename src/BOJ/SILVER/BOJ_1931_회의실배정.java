package BOJ.SILVER;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_1931_회의실배정 {
	static class Conf implements Comparable<Conf>{
		int s; int e;
		public Conf(int s, int e) {this.s = s; this.e = e;}

		@Override
		public int compareTo(Conf o) {
			if(this.e==o.e) {
				return Integer.compare(this.s, o.s);
			}
			return Integer.compare(this.e, o.e);
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());
		
		Conf [] cArr = new Conf[N]; 
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine()," ");
			cArr[i] = new Conf(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()));
		}
		Arrays.sort(cArr);
		
		int cnt = 0;
		int end = 0;
		for (int i = 0; i < N; i++) {
			if(end<=cArr[i].s) {
				end = cArr[i].e;
				cnt++;
			}
		}
		System.out.println(cnt);
	}
}