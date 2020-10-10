package SILVER;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;

public class BOJ_5525_IOIOI {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int S = Integer.parseInt(br.readLine());
		char [] str = br.readLine().toCharArray();

		//홀수 3,5,7,9, ...
		N = 2*N+1;
		int k=0;
		int cnt = 0;
		boolean flag = true;
		Deque<Character> dque = new LinkedList<>();
		
		while(true) {
			
			char c = str[k++];
			if(dque.isEmpty() && c=='I') { //I로 시작해야함
				dque.offer(c);
			}
			else if(dque.peekLast()=='O' && c=='I') {
				dque.offer(c);
			}
			else if(dque.peekLast()=='C' && c=='O') {
				dque.offer(c);
			}
			else {
				dque.clear();
			}
			
			System.out.println(dque);
			if(k==S) return;
		}
		
	}
}
