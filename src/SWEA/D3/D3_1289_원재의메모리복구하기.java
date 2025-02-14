package SWEA.D3;
import java.util.Scanner;

public class D3_1289_원재의메모리복구하기 {
	static int T, answer;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		T = sc.nextInt();
		for (int t = 1; t <= T; t++) {
			String s = sc.next();
			answer = 0;
			char c = '0';
			for (int i = 0; i < s.length(); i++) {
				if(s.charAt(i) != c) {
					answer++;
					if(c == '0') {
						c = '1';
					}
					else {
						c = '0';
					}
				}
				else
					continue;
			}
			System.out.println(answer);
		}
	}
}
