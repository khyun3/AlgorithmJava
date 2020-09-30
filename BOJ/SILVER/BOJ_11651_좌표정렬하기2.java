package SILVER;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_11651_좌표정렬하기2 {
	static class Location implements Comparable<Location>{
		int x;
		int y;
		@Override
		public int compareTo(Location o) {
			if(this.y > o.y)
				return 1;
			else if(this.y==o.y)
				return Integer.compare(this.x, o.x);
			else
				return -1;
		}
		public Location(int x, int y) {
			this.x = x; this.y = y;
		}
		
	}
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		
		List<Location> list = new LinkedList<>();
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine()," ");
			list.add(new Location(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
		}
		Collections.sort(list);
		for (Location l : list) {
			sb.append(l.x).append(" ").append(l.y).append("\n");
		}
		System.out.println(sb);
	}
}