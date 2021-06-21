import java.util.Arrays;
import java.util.Comparator;

public class 문자열내마음대로정렬하기 {
	public static void main(String[] args) {
				
		//tc1
		String[] strings = {"abce", "abcd", "cdx"};
		int n = 1;
		
		
		System.out.println(Arrays.toString(solution(strings, n)));
	}
	static public String [] solution(String [] strings, int n) {
		
		Arrays.sort(strings, new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				if(o1.charAt(n) > o2.charAt(n)) {
					return 1;
				}
				else if(o1.charAt(n) < o2.charAt(n)) {
					return -1;
				}
				else { //같을 때
					return o1.compareTo(o2);
				}
			}
		});
		return strings;
	}
}
