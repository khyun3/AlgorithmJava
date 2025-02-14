package BOJ.SILVER;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class BOJ_4949_균형잡힌세상 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Stack<Character> stk = new Stack<>();
		
		while(true){
			char [] str = br.readLine().toCharArray();
			stk.clear();
			boolean check = true;
			if(str[0]=='.' && str.length==1) break;
			
			for (int i = 0; i < str.length; i++) {
				
				if(str[i] == '(') {
					stk.push('(');
				}
				else if(str[i] == '[') {
					stk.push('[');
				}
				else if(str[i] == ')') {
					if(!stk.isEmpty() && stk.peek()=='(') {
						stk.pop();
					}
					else {
						check = false;
						break;
					}
				}
				else if(str[i] == ']') {
					if(!stk.isEmpty() && stk.peek()=='[') {
						stk.pop();
					}
					else {
						check = false;
						break;
					}
				}
			}
			if(check && stk.isEmpty()) {
				System.out.println("yes");
			}
			else
				System.out.println("no");
		}
	}
}