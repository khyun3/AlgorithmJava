package BOJ.SILVER;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class BOJ_9012_괄호 {
	static int T;
	static boolean flag;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		char [] arr;
		Stack<Character> sk = new Stack<>();
		for (int t = 0; t < T; t++) {
			arr = br.readLine().toCharArray();
			flag = true;
			sk.clear();
			for (char c : arr) {
				if(c==')') {
					if(!sk.isEmpty() && sk.peek()=='(') {
						sk.pop();
					}
					else {
						flag = false;
						break;
					}
				}
				else if(c=='(') {
					sk.push(c);
				}
			}
			if(sk.isEmpty() && flag) System.out.println("YES");
			else System.out.println("NO");
		}
	}
}
