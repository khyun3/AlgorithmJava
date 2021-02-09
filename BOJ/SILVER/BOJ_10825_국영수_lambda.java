package SILVER;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.LinkedList;
import java.util.StringTokenizer;


public class BOJ_10825_국영수_lambda {
	static class Student{
		String name;
		int kor, eng, math;
		public Student(String name, int kor, int eng, int math) {
			this.name = name;
			this.kor = kor;
			this.eng = eng;
			this.math = math;
		}
	}
	public static void main(String[] args)throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		int N = Integer.parseInt(br.readLine());
		
		LinkedList<Student> slist = new LinkedList<>();
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine()," ");
			
			slist.add(new Student(
					st.nextToken(), 
					Integer.parseInt(st.nextToken()), 
					Integer.parseInt(st.nextToken()), 
					Integer.parseInt(st.nextToken())));
		}
		Collections.sort(slist, (o1,o2)->{
		if(o1.kor > o2.kor) {return -1;}
		else if(o1.kor == o2.kor) {
			if(o1.eng < o2.eng) {return -1;}
			else if(o1.eng == o2.eng) {
				if(o1.math > o2.math) {return -1;}
				else if(o1.math == o2.math) {return o1.name.compareTo(o2.name);}
				else {return 1;}
			}
			else {return 1;}
		}
		else {return 1;}
		});
		StringBuilder sb = new StringBuilder();
		for (Student s : slist) {
			sb.append(s.name).append('\n');
		}
		System.out.print(sb.toString());
	}
}