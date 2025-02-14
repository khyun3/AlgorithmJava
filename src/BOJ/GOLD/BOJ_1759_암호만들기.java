package BOJ.GOLD;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_1759_암호만들기 {
	//1. 암호는 서로 다른 L개의 알파벳 소문자들로 구성
	//2. 최소 1개의 모음(a,e,i,o,u)과 2 개의 자음으로 구성
	//3. 증가하는 순서로 배열
	//4. 중복 없음, 소문자, 3<= L <= C <= 15
	static boolean [] selected;
	static char [] answer;
	public static void main(String[] args)throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		StringBuilder sb = new StringBuilder();
		
		int L = Integer.parseInt(st.nextToken()); //암호 길이
		int C = Integer.parseInt(st.nextToken()); //암호에 넣을 수 있는 문자
		
		answer = new char [L];
		selected = new boolean[C];
		
		List<Character> aList = new ArrayList<Character>();
		st = new StringTokenizer(br.readLine()," ");
		
		while(st.hasMoreTokens()) {
			aList.add(st.nextToken().charAt(0));
		}
		Collections.sort(aList);
		solPw(L,C,0,aList, sb);
		System.out.print(sb);
	}

	private static void solPw(int l, int c, int cnt, List<Character> aList, StringBuilder sb) {
		
		if(cnt==l) {
			
			int ja = 0;
			int mo = 0;
			for (int i = 0; i < l; i++) {
				char a = answer[i];
				
				if(a=='a' ||a=='e' ||a=='i' ||a=='o' ||a=='u') {
					mo +=1;
				}
				else
					ja +=1;
			}
			if(mo>=1 && ja>=2) {
				for (char k : answer) {
					sb.append(k);
				}
				sb.append('\n');
			}
			return;
		}
		
		for (int i = 0; i < c; i++) {
			if(selected[i]) continue;
			char tmp = aList.get(i);
			if(cnt==0) {
				answer[cnt] = tmp;
				selected[i] = true;
				solPw(l,c,cnt+1,aList, sb);
				selected[i] = false;
			}
			else if(tmp>answer[cnt-1]) {
				answer[cnt] = tmp;
				selected[i] = true;
				solPw(l,c,cnt+1,aList, sb);
				selected[i] = false;
			}
		}
	}
}