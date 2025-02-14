package Programmers;

import java.util.Arrays;
import java.util.StringTokenizer;

public class 브라이언의_고민 {
	public static void main(String[] args) {
		//영문 대문자는 원래 문구, 소문자는 특수기호를 의미
		
		//(규칙 1) 특정 단어를 선택하여 글자 사이마다 같은 기호를 넣는다. ex) HELLO -> HaEaLaLaO
		//(규칙 2) 특정 단어를 선택하여 단어 앞뒤에 같은 기호를 넣는다. ex) WORLD -> bWORLDb
		
		//위의 두 가지 규칙은 한 단어에 모두 적용될 수 있지만 같은 규칙은 두 번 적용될 수 없다.★
		//마지막으로 원래 문구에 있던 공백을 제거한다.★
		//한 번 쓰인 소문자(특수기호)는 다시 쓰일 수 없다. ★
		
		String sentence[] = {"HaEaLaLaObWORLDb", "SpIpGpOpNpGJqOqA", "AxAxAxAoBoBoB"};
		
		//알파벳 사용 체크
		boolean alpa[] = new boolean[26];
		
		
		System.out.println(spaceCheck(sentence[0]));
		
		
	}
	
	//(규칙 1) 특정 단어를 선택하여 글자 사이마다 같은 기호를 넣는다. ex) HELLO -> HaEaLaLaO
	//특정 단어를 기준으로 동일한 기호인지 확인
	static boolean rule1Check(String sentence) {
		int index = 0;
		boolean alpa[] = new boolean[26];
		StringBuilder sb = new StringBuilder();
		
		for (char c : sentence.toCharArray()) {
			
			if(c>='a' && c<='z') { //특수문자 범위라면
				
			}
			else if(c>='A' && c<='Z') { //본문 내용이라면
				
			}
			
		}
		
		
		return true;
	}
	
	
	static boolean rule2Check(String sentence) {
		
		
		return true;
	}
	
	
	static String spaceCheck(String sentence) {
		StringBuilder sb = new StringBuilder();
		
		int lower = 0;
		int upper = 0;
		int beginIndex = 0;
		int endIndex = 0;
		char lowerChar = '-'; 
		
		
		for (char c : sentence.toCharArray()) {
			if(c>='a' && c<='z') { //특수문자 범위라면
				lower++;
				if(lower==2) {
					sb.append(sentence.substring(beginIndex, endIndex));
					sb.append(' ');
					beginIndex = endIndex;
					lower=0;
				}
				upper=0;
			}
			else if(c>='A' && c<='Z') { //본문 내용이라면
				upper++;
				if(upper==2) {
					sb.append(sentence.substring(beginIndex, endIndex));
					sb.append(' ');
					beginIndex = endIndex;
					upper = 0;
				}
				lower=0;
			}
			
			
			if(lowerChar!='-' && lowerChar!=c) {
				sb.append(sentence.substring(beginIndex, endIndex));
				sb.append(' ');
				beginIndex = endIndex;
				lowerChar = c;
			}
			endIndex++;
		}
		
		return sb.toString();
	}
}
