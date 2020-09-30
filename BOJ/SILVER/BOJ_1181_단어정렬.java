package SILVER;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.TreeSet;

public class BOJ_1181_단어정렬 {
	static class Word implements Comparable<Word>{
		String w;
		
		public Word(String w) {
			this.w = w;
		}
		@Override
		public int compareTo(Word o) {
			int res = Integer.compare(this.w.length(), o.w.length());
			if(res==0) {
				return this.w.compareTo(o.w);
			}
			return res;
		}
	}
	static int N;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		N = Integer.parseInt(br.readLine());
		TreeSet<Word> list = new TreeSet<>();
		
		for (int i = 0; i < N; i++) {
			list.add(new Word(br.readLine().trim()));
		}
		for (Word word : list) {
			sb.append(word.w).append("\n");
		}
		System.out.println(sb);
	}
}