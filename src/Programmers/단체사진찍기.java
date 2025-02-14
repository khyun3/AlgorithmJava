package Programmers;

import java.util.Arrays;

public class 단체사진찍기 {
	static boolean [] isVisited;
	static char [] names, arr;
	static int total;
	public static void main(String[] args) {
		solution(2,	new String [] {"N~F=0", "R~T>2"}); //3648	
        System.out.println(total);
		solution(2,	new String [] {"M~C<2", "C~M>1"}); //0
		System.out.println(total);
		
	}
	static public int solution(int n, String[] data) {
        int answer = 0;
        total = 0;
        isVisited = new boolean[8];
        names = new char [] {'A', 'C', 'F', 'J', 'M', 'N', 'R', 'T'};
        arr = new char[8];
        nPr(0,data);
        return answer = total;
    }
	static void nPr(int cnt, String[] data) {
		if(cnt==8) {
			if(check(data))
				total++;
			return;
		}
		
		for (int i = 0; i < 8; i++) {
			if(isVisited[i]) continue;
			isVisited[i] = true;
			arr[cnt] = names[i];
			nPr(cnt+1, data);
			isVisited[i] = false;
		}
	}
	static boolean check(String [] data) {
		boolean res = true;
		String tmp;
		StringBuilder sb = new StringBuilder();
		for (char c : arr) {
			if(c!='\0')
			sb.append(c);
		}
		tmp = sb.toString();
		
		for (String str : data) {
			char a = str.charAt(0); //조건을 제시한 프렌즈
			char b = str.charAt(2); //상대방
			char op = str.charAt(3); //=, >, <
			int gap = str.charAt(4)-'0'; //0~6
			
			//arr => 현재 뽑힌 친구들
			int aIndex = tmp.indexOf(a);
			int bIndex = tmp.indexOf(b);

			int diff = Math.abs(aIndex - bIndex)-1;
			switch(op) {
			case '=':
				res = (diff == gap) ? true : false;
				break;
			case '>':
				res = (diff > gap) ? true : false;
				break;
			case '<':
				res = (diff < gap) ? true : false;
				break;
			default :
				break;
			}
			if(!res) return res;
		}
		return res;
	}
}
