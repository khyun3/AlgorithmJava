package BOJ.SILVER;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_10814_나이순정렬 {
	static class Member {
		int age;
		String name;
		public Member(int age, String name) {
			this.age = age;
			this.name = name;
		}
	}
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		List<Member> mList = new LinkedList<>();
		
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			mList.add(new Member(Integer.parseInt(st.nextToken()),st.nextToken()));
		}
		Collections.sort(mList, (Member m1, Member m2)-> m1.age-m2.age);
		StringBuilder sb = new StringBuilder();
		for (Member m : mList) {
			sb.append(m.age).append(" ").append(m.name).append("\n");
		}
		System.out.println(sb);
	}
}