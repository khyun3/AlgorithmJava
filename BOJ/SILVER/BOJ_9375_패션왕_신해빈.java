package SILVER;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;


public class BOJ_9375_패션왕_신해빈 {
	static class C{
		String key;
		int cnt;
		
		public C(String key, int cnt) {
			this.key = key;
			this.cnt = cnt;
		}
	}
	static int T, N;
	public static void main(String[] args)throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		T = Integer.parseInt(br.readLine());
		
		for (int t = 0; t < T; t++) {
			N = Integer.parseInt(br.readLine());
			if(N==0) { System.out.println(0); continue;}
			
			List<C> clist = new ArrayList<>();
			
			for (int n = 0; n < N; n++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				String value = st.nextToken();
				String key = st.nextToken();
				
				if(clist.size()==0) {
					clist.add(new C(key,1));
				}
				else {
					boolean check = false;
					for (int i = 0; i < clist.size(); i++) {
						if(clist.get(i).key.equals(key)) {
							clist.get(i).cnt++;
							check = true;
							break;
						}
					}
					if(!check) {
						clist.add(new C(key,1));
					}
				}
			}
			int answer = 1;
				for (int i = 0; i < clist.size(); i++) {
					answer *= (clist.get(i).cnt+1);
				}
			System.out.println(answer-1);
		}
	}
}