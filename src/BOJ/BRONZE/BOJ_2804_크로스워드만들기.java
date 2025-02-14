package BOJ.BRONZE;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2804_크로스워드만들기 {
	static char[] A, B;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		A = st.nextToken().trim().toCharArray(); // 가로 단어
		B = st.nextToken().trim().toCharArray(); // 세로 단어

		int isSame1 = 0; // A의 겹치는 알파벳
		int isSame2 = 0; // B의 겹치는 알파벳
		a: for (int i = 0; i < A.length; i++) {
			for (int j = 0; j < B.length; j++) {
				if (A[i] == B[j]) {
					isSame1 = j; // A가 위치할 행
					isSame2 = i; // B가 위치할 열
					break a;
				}
			}
		}
		for (int i = 0; i < B.length; i++) {
			for (int j = 0; j < A.length; j++) {
				if (i == isSame1) {
					System.out.print(A[j]);
				} else if (j == isSame2) {
					System.out.print(B[i]);
				} else
					System.out.print(".");
			}
			System.out.println();
		}
	}
}