package BOJ.SILVER;

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

		int k = 2*N+1;
		int answer = 0;
		
		Deque<Character> que = new LinkedList<>();
		for (int i = 0; i < str.length; i++) {
			char c = str[i];
					
			if(que.isEmpty()) {
				if(c=='I')
					que.offer(c);
			}
			else {
				if(que.peekLast()=='I' && c=='O') {
					que.offer(c);
				}
				else if(que.peekLast()=='O' && c=='I') {
					que.offer(c);
				}
				else if(que.peekLast()=='I' && c=='I') {
					int tmp = (que.size()-1)/2-(N-1);
					if(tmp > 0)
						answer+=tmp;
					que.clear();
					que.offer(c);
				}
				else {
					int tmp = (que.size()-1)/2-(N-1);
					if(tmp > 0)
						answer+=tmp;
					que.clear();
				}
			}
			
		}
		int tmp = (que.size()-1)/2-(N-1);
		if(tmp > 0)
			answer+=tmp;
		System.out.println(answer);
	}
}
