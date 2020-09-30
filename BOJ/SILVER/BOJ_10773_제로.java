package SILVER;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class BOJ_10773_제로 {
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		Stack<Integer> stk = new Stack<>();
		
		int num = 0;
		for (int i = 0; i < N; i++) {
			num = Integer.parseInt(br.readLine());
			if(num==0)
				stk.pop();
			else
				stk.push(num);
			
		}
		int sum = 0;
		int len = stk.size();
		for (int i = 0; i < len; i++) {
			sum += stk.pop();
		}
		System.out.println(sum);
	}
}