package kaka;

public class s1 {
	public static void main(String[] args) {
		solution("one4seveneight");
		solution("23four5six7");
		solution("2three45sixseven");
		solution("123");
	}
	static public int solution(String s) {
	    int answer = 0;
	    
	    String [] numbers = {"zero","one","two","three","four","five","six","seven","eight","nine"};
	    int i = 0;
	    for (String str : numbers) {
			s = s.replace(str, Integer.toString(i++));
		}
	    
	    return answer;
	}
}
