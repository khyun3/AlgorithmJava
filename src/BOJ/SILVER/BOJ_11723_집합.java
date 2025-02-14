package BOJ.SILVER;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_11723_집합 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());
		
		int S = 0, num = 0;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine()," ");
			
			switch(st.nextToken()) {
			case "add":
					S |= 1<<Integer.parseInt(st.nextToken())-1;
				break;
			case "remove":
					S &= ~(1<<Integer.parseInt(st.nextToken())-1);
				break;
			case "check":
				num = Integer.parseInt(st.nextToken())-1;
				if(1==(S & 1<<num)>>num)
					sb.append("1\n");
				else
					sb.append("0\n");
				break;
			case "toggle":
				S = S^(1<<Integer.parseInt(st.nextToken())-1);
				break;
			case "all":
				S = 0xFFFFF;
				break;
			case "empty":
				S = 0;
				break;
			}
			//System.out.println(Integer.toBinaryString(S));

		}
		System.out.print(sb);
	}
}