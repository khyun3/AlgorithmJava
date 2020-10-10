package SILVER;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_1966_프린터큐 {
	static class Doc{
		int p; //우선순위
		int n; //들어온 순서
		
		public Doc(int p, int n) {
			this.p = p;
			this.n = n;
		}
	}
	public static void main(String[] args)throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		
		for (int t = 0; t < T; t++) {
			st = new StringTokenizer(br.readLine()," ");
			int N = Integer.parseInt(st.nextToken()); //문서의 수
			int M = Integer.parseInt(st.nextToken()); //출력 순서를 찾고싶은 문서
			
			Queue<Doc> que = new LinkedList<>();
			int [] p = new int [10];//priority
			st = new StringTokenizer(br.readLine()," ");
			for (int n = 0; n < N; n++) {
				int priority = Integer.parseInt(st.nextToken());
				p[priority]++;
				que.offer(new Doc(priority,n));
			}
			
			int pOk = 1;
			while(true) {
				boolean check = true;
				Doc print = que.poll();
				for (int i = 9; i > print.p; i--) { //우선순위가 높은 문서가 있다면
					if(p[i]!=0) {
						check = false;
					}
				}
				if(!check) {
					que.offer(print);
				}
				else {//출력대상이면
					if(print.n == M ) {
						System.out.println(pOk);
						p[print.p]--;
						break;
					}
					p[print.p]--;
					pOk++;
				}
			}
		}
	}
}