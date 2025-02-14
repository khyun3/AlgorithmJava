package BOJ.SILVER;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_7668_덩치 {
	static class Person{
		int kg;
		int cm;
		int rank;
		
		public Person(int kg, int cm) {
			this.kg = kg;
			this.cm = cm;
			this.rank = 1;
		}
		
	}
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());
		List<Person> list = new ArrayList<>();
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine()," ");
			list.add(new Person(Integer.parseInt(st.nextToken()),
								Integer.parseInt(st.nextToken())));
		}
		
		for (int i = 0; i < N; i++) {
			Person a = list.get(i);
			for (int j = 0; j < N; j++) {
				Person b = list.get(j);
				if(a.cm < b.cm && a.kg < b.kg) {
					a.rank++;
				}
			}
		}
		StringBuilder sb = new StringBuilder();
		for (Person p : list) {
			sb.append(p.rank).append(" ");
		}
		System.out.println(sb);
	}
}