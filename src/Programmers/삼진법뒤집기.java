package Programmers;

import java.util.ArrayList;

public class 삼진법뒤집기 {
	public static void main(String[] args) {
		solution2(45);
		solution2(125);
	}
	//그냥 냅다 하기..
	static public int solution(int n) {
        int answer = 0;
        ArrayList<Integer> ternary = new ArrayList<>();
        
        while(n!=0) {
	        ternary.add(n%3);
	        n/=3;
        }
        
        int pow=1;
        int size = ternary.size()-1;
        for (int i = size; i>=0; i--) {
			if(i==size) {
				answer+=ternary.get(i);
			}
			else {
				pow*=3;
				answer+=ternary.get(i)*pow;
			}
		}
        
        return answer;
    }
	//parseint 라이브러리 사용
	static public int solution2(int n) {
		StringBuilder ternary = new StringBuilder();
		 while(n!=0) {
		        ternary.append(n%3);
		        n/=3;
	        }
		return Integer.parseInt(ternary.toString(), 3);
	}
}
