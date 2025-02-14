package BOJ.SILVER;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class BOJ_1874_스택수열 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		
		int [] sq = new int [N];
		int [] msq = new int [N]; //스택으로 만들어진 수열
		
		for (int i = 0; i < N; i++) {
			sq[i] = Integer.parseInt(br.readLine());
		}
		
		Stack<Integer> stk = new Stack<>();
		int sNum = 1;
		int k = 0;
		boolean check = true;
		stk.push(1);
		sb.append("+\n");

		while(true) {
			if(!stk.isEmpty() && sq[k]==stk.peek()) {
				msq[k++] = stk.pop();
				sb.append("-\n");
			}
			else if(sNum!=N){
				stk.push(++sNum);
				sb.append("+\n");
			}	
			if(k==N) break;
			if(sNum==N) {
				while(!stk.isEmpty()) {
					msq[k++] = stk.pop();
					sb.append("-\n");
				}
				break;
			}
		}	
		for (int i = 0; i < N; i++) {
			if(sq[i] != msq[i]) check = false;
		}
		
		if(check)
			System.out.println(sb);
		else
			System.out.println("NO");
	}
}