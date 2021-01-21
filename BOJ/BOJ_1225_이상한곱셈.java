import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1225_이상한곱셈 {

	public static void main(String[] args)throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		char [] atmp, btmp;
		atmp = st.nextToken().toCharArray();
		btmp = st.nextToken().toCharArray();
		
		int [] a = new int [10];
		int [] b = new int [10];
		
		long ans = 0;
		
		for (int i = 0; i < atmp.length; i++) {
			a[atmp[i]-'0']++;
		}
		for (int i = 0; i < btmp.length; i++) {
			b[btmp[i]-'0']++;
		}
		
		for (int i = 1; i <= 9; i++) {
			for (int j = 1; j <= 9; j++) {
				ans+= (a[i]*b[j])*(i*j);
			}
		}
		System.out.print(ans);
	}
}