package BOJ.SILVER;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class BOJ_10845_큐 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());
		Deque<Integer> que = new LinkedList<>();
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine()," ");
			switch(st.nextToken()) {
			case "push":
				que.offer(Integer.parseInt(st.nextToken()));
				break;
			case "pop":
				if(!que.isEmpty())
					sb.append(que.poll()).append("\n");
				else
					sb.append("-1").append("\n");
				break;
			case "size":
				sb.append(que.size()).append("\n");
				break;
			case "empty":
				if(!que.isEmpty())
					sb.append("0").append("\n");
				else
					sb.append("1").append("\n");
				break;
			case "front":
				if(!que.isEmpty())
					sb.append(que.peek()).append("\n");
					else
					sb.append("-1").append("\n");
				break;
			case "back":
				if(!que.isEmpty())
					sb.append(que.peekLast()).append("\n");
				else
					sb.append("-1").append("\n");	
				break;
			}
		}
		System.out.println(sb);
	}
}