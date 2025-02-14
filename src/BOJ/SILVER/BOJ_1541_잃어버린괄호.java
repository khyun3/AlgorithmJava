package BOJ.SILVER;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_1541_잃어버린괄호 {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
	
		String str = br.readLine();
		
		String intStr = str.replaceAll("[+-]", " "); //정수만 뽑는다.
		String opStr = str.replaceAll("[0-9]", " "); //연산자만 뽑는다.
		
		List<Integer> ilist = new ArrayList<>();
		List<Character> clist = new ArrayList<>();
		
		//숫자를 리스트에 넣기
		StringTokenizer st = new StringTokenizer(intStr, " ");
		while(st.hasMoreTokens()) {
			ilist.add(Integer.parseInt(st.nextToken()));
		}
		
		//연산자를 리스트에 넣기 
		st = new StringTokenizer(opStr, " ");
		while(st.hasMoreTokens()) {
			clist.add(st.nextToken().charAt(0));
		}
		
		
		//괄호를 넣어보자
		int sum =0;
		//이전 op가 -고 
		//이후 op가 -가 나올때까지 기다리다가 -가 나오면 직전 숫자전까지 괄호를 친다.
		for (int i = 0; i < ilist.size(); i++) {
			if(i==0) sum+=ilist.get(i);
			else {
				if(i-1<clist.size() && clist.get(i-1) == '-') {
					sum-=ilist.get(i);
					
					while(true) {
						if(i<clist.size() && clist.get(i) == '+') { //다음 연산자가 +이면 묶는다.
							sum-=ilist.get(++i);
						}
						else
							break;
					}
				}
				else { // '+'
					sum+=ilist.get(i);
				}
			}
			
		}
		System.out.println(sum);
	}
}
