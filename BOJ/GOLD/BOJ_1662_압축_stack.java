package GOLD;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Stack;

public class BOJ_1662_압축_stack {
	public static void main(String[] args)throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		char[] str = br.readLine().toCharArray();
		Stack<Character> stack = new Stack<>(); 
		Stack<Integer> len = new Stack<Integer>();
		int answer = 0;
		for (int i = 0; i < str.length; i++) {
			if(str[i]!=')') {
				stack.push(str[i]);
			}
			else {
				char K;
				int sLen=0, Q=answer;
				boolean check = false;	
				for (int j = i; j < str.length; j++) {
					if(str[j]>='0' && str[j]<='9') {
						check = true;
						break;
					}
				}
				while(stack.peek()!='(') {
					if(check) {
						if(stack.peek()=='L') {
							sLen+=len.pop();
							stack.pop();
						}
						else {
							sLen++;
							stack.pop();
						}
					}
					else {
						if(stack.peek()=='L')
							Q+=len.pop();
						else {
							Q++;
						}
						stack.pop();
					}
				}
				
				stack.pop(); //'('버리기
				K = stack.pop();
				if(check) {
					len.push(sLen*(K-'0'));
					stack.push('L');
				}
				else { //가장 뒤
					answer = Q*(K-'0');
				}
			}
		}
		while(!stack.isEmpty()) {
			if(stack.pop()=='L') answer+=len.pop();
			else answer++;
		}
		System.out.println(answer);
	}
}