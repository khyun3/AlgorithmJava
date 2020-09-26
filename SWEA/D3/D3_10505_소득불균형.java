package D3;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class D3_10505_소득불균형 {
	//테케 수인 T가 주어지고 명 수 N이 주어진다.
	static int T, N;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			N = Integer.parseInt(br.readLine());
			int [] p = new int[N];
			//평균을 구하자
			int avg = 0;
			st = new StringTokenizer(br.readLine());
			for (int i=0; i<N; i++) {
				p[i] = Integer.parseInt(st.nextToken());
				avg+= p[i];
			}
			avg /=N;
			//평균보다 낮은 소득의 사람을 구하자
			int cnt=0;
			for (int i = 0; i < N; i++) {
				if(avg>=p[i]) {cnt++;} 
			}
			System.out.println("#"+t+" "+cnt);
		}
	}
}