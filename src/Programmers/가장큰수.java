package Programmers;

import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;

public class 가장큰수 {
	public static void main(String[] args) {
		
		solution(new int [] {0,0,0});
	}
	static String solution(int[] numbers) {
	      String answer = "";
	      
	      answer = sort(IntegerToString(numbers));
	      return answer;
	}
	static LinkedList<String> IntegerToString(int [] numbers) {
		LinkedList<String> list = new LinkedList<>();
		for (int i : numbers) {
			list.add(Integer.toString(i));
		}
		return list;
	}
	static String sort(LinkedList<String> list){
		Collections.sort(list, new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				return -(o1+o2).compareTo(o2+o1);
			}
		});
		StringBuilder sb = new StringBuilder();
		
		for (String s : list) {
			sb.append(s);
		}
		return sb.toString().substring(0,1).equals("0") ? "0" : sb.toString();
	}
}
