package SWEA.D4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class D4_1223_계산기2 {
	static int N, a;
	static Stack<Integer> S= new Stack<>();
	static Queue<Integer> Q= new LinkedList<>();
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		
		for (int t = 1; t <= 10; t++) {
			N = Integer.parseInt(br.readLine().trim());
			char [] in = br.readLine().toCharArray();
			
			for (int i = 0; i < N; i++) {
				if(48<=in[i] && in[i]<58) {	//0~9
					Q.offer((int)in[i]-'0');
				}else if(in[i] == '+') {	//43
					
					while(!S.isEmpty()) {
						Q.offer(S.pop());
					}
					S.push((int)in[i]);
					
				}else if(in[i] == '*') {	//42
					while(!S.isEmpty()) {
						if(S.peek() == '+') {
							break;
						}
						Q.offer(S.pop());
					}
					S.push((int)in[i]);
				}
			}
			while(!S.isEmpty()){ //스텍 비우기
				Q.offer(S.pop());
			}
			
			while(!Q.isEmpty()) {
				a = Q.poll();
				if(1<=a && a<=9) {	//0~9
					S.push(a);
				}else if(a == 43) {
					S.push(S.pop() + S.pop());
				}
				else if(a == 42) {
					S.push(S.pop() * S.pop());
				}
			}
			System.out.println("#"+t+" "+S.pop());
		}
	}
}
