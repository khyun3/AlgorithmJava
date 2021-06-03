package GOLD;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1107_리모컨_fail {
	static int M, num[], buttons[], answer; //이동할 채널, 선택한 채널, 선택가능한 버튼
	static boolean flag, rmc[] = new boolean[10];
	static char [] N;
	public static void main(String[] args)throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();
		
		int channel = 100; //초기 채널
		N = br.readLine().toCharArray();
		M = Integer.parseInt(br.readLine());
		num = new int [N.length];
		
		//고장난 버튼의 번호를 받아온다.
		st = new StringTokenizer(br.readLine(), " ");
		
		//고장난 버튼을 표시한다.
		for (int i = 0; i < M; i++) {
			rmc[Integer.parseInt(st.nextToken())] = true;
		}
		
		//누를 수 없는 가장 큰 자리를 구한다.
		int k = -1;
		for (char c : N) {
			if(!rmc[Integer.parseInt(Character.toString(c))]) {
				num[++k] = c-'0';
			}
			else {
				break;
			}
		}
		
		for (char c : N) {
			sb.append(c);
		}
		
		//방문할 수 있는 배열을 따로 뺀다.
		buttons = new int[10-M];
		int j = -1;
		for (int i = 0; i < 10; i++) {
			if(!rmc[i]) {
				buttons[++j] = i;
			}
		}
		
		answer = Math.abs(channel - Integer.parseInt(sb.toString()));
		//0때문에 자리수가 더 커질 수 있으니 체크 해야 함.
		int u = 0; //자리 수
		for (int i = 0; i < num.length; i++) {
			u += num[i];
			if(i != num.length-1)u *= 10;
		}
		
		//부분 집합 
		//cnt : 지금까지 고른 개수
		//n : 방문 가능한 버튼 수 
		//r : 골라야하는 개수
		solution(k+1, buttons.length, num.length, Integer.parseInt(sb.toString()), Integer.toString(u).length());
		System.out.println(answer);
	}
	
	
	static void solution(int cnt, int n, int r, int inputChannel, int u) {
		
		if(flag) return;
		
		if(r==cnt) {
			StringBuilder sb = new StringBuilder();
			for (int i : num) {
				sb.append(i);
			}
//			System.out.println(Math.abs(Integer.parseInt(sb.toString())-inputChannel)+"    "+answer);
			int tmp = Math.abs(Integer.parseInt(sb.toString())-inputChannel);
			if(answer <= tmp) {flag = true;}
			answer = Math.min(answer, tmp+u);
			return;
		}
		for (int i = 0; i < n; i++) {
			num[cnt] = buttons[i];
			solution(cnt+1, n, r, inputChannel, u);
		}
	}
}