package BOJ.SILVER;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;


public class BOJ_9375_패션왕_신해빈_HashMap {

	static int T, N;
	public static void main(String[] args)throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		T = Integer.parseInt(br.readLine());
		
		for (int t = 0; t < T; t++) {
			N = Integer.parseInt(br.readLine());
			
			if(N==0) { System.out.println(0); continue;}
			
			Map<String, Integer> m = new HashMap<String, Integer>();
			
			for (int n = 0; n < N; n++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				String value = st.nextToken();
				String key = st.nextToken();
				
				if(!m.containsKey(key))
					m.put(key, 1);
				else {
					m.put(key, m.get(key)+1);
				}
			}

			int answer=1;
			for (int i : m.values()) {
				answer *= i+1;
			}
			System.out.println(answer-1);
		}
	}
}