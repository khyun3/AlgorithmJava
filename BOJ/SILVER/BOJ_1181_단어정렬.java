package SILVER;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.TreeSet;


public class BOJ_1181_단어정렬 {
	
	static int N;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		TreeSet<String> ts = new TreeSet<>();
	
		for (int i = 0; i < N; i++) {
			String str = br.readLine().toString();
			ts.add(str);
			
		}
		//Collections.sort();
		for (String s : ts) {
			System.out.println(s);
		}
	}
}
