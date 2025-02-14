package BOJ.SILVER;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_15658_연산자끼워넣기 {
	static int min=Integer.MAX_VALUE, max=-Integer.MAX_VALUE;
	static int [] num;
	static int [] oper = new int [4];
	public static void main(String[] args)throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		num = new int [N];
		
		//숫자 입력
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			num[i] = Integer.parseInt(st.nextToken());
		}//숫자 입력 끝
		
		// 연산자 입력
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < 4; i++) {
			oper[i] = Integer.parseInt(st.nextToken());
		}
		//연산자 입력 끝
		nPr(1, 0, 0, 0, 0, num[0], N);
		System.out.println(max+"\n"+min);
	}
	private static void nPr(int cnt, int plus, int minus, int mul, int div, int cal, int n) {
		
		if(n==cnt) {
			min = Math.min(min, cal);
			max = Math.max(max, cal);
			return;
		}
		if(plus<oper[0]) {
			nPr(cnt+1, plus+1, minus, mul, div, cal+num[cnt], n);
		}		
		if(minus<oper[1]) {
			nPr(cnt+1, plus, minus+1, mul, div, cal-num[cnt], n);
		}
		if(mul<oper[2]) {
			nPr(cnt+1, plus, minus, mul+1, div, cal*num[cnt], n);
		}
		if(div<oper[3]) {
			nPr(cnt+1, plus, minus, mul, div+1, cal/num[cnt], n);
		}
	}
}