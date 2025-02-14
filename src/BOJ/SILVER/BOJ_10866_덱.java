package BOJ.SILVER;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class BOJ_10866_덱 {
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		Deque<Integer> dq = new LinkedList<Integer>();
		int N = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine()," ");
			
			switch(st.nextToken()) {
			case "push_back":
				dq.addLast(Integer.parseInt(st.nextToken()));
				break;
			case "push_front":
				dq.addFirst(Integer.parseInt(st.nextToken()));
				break;
			case "pop_front":
				if(!dq.isEmpty())
					sb.append(dq.pollFirst()).append("\n");
				else
					sb.append("-1").append("\n");
				break;
			case "pop_back":
				if(!dq.isEmpty())
					sb.append(dq.pollLast()).append("\n");
				else
					sb.append("-1").append("\n");
				break;
			case "front":
				if(!dq.isEmpty())
					sb.append(dq.peekFirst()).append("\n");
				else
					sb.append("-1").append("\n");
				break;
			case "back":
				if(!dq.isEmpty())
					sb.append(dq.peekLast()).append("\n");
				else
					sb.append("-1").append("\n");					
				break;
			case "size":
				sb.append(dq.size()).append("\n");
				break;
			case "empty":
				sb.append(dq.isEmpty()? "1":"0").append("\n");
				break;
			}
		}
		System.out.println(sb);
	}
}
