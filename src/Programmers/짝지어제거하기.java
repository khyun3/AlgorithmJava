package Programmers;

import java.util.Stack;

public class 짝지어제거하기 {
	public static void main(String[] args) {
		int a = solution("baaabaa");
		int b = solution("cdcd");
		System.out.println(a+"  "+b);
	}
	static int solution(String s){
		Stack<Character> stk = new Stack<>();
		
		for (int i = 0; i < s.length(); i++) {
			if(stk.isEmpty()) {
				stk.push(s.charAt(i));
			}
			else if(stk.peek()!=s.charAt(i)) {
				stk.push(s.charAt(i));
			}
			else {
				stk.pop();
			}
		}
		
	    return stk.size()==0 ? 1 : 0;
	}
}
