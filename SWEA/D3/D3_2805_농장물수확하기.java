package D3;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class D3_2805_농장물수확하기 {
	static int T, N, answer;
	static char [][] map;
	public static void main(String[] args)throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine().trim());
		
		for (int t = 1; t <= T; t++) {
			N = Integer.parseInt(br.readLine().trim());
			map = new char[N][N];
			int k=N-1;
			answer = 0;
			for (int i = 0; i < N; i++) {
				map[i] = br.readLine().toCharArray();
				if(N/2-i>=0)
					for (int j = N/2-i; j <N/2+(i+1); j++) {
						answer+=map[i][j]-'0';
					}
				if(N/2-i<0) {
					for (int j = i-N/2; j <k; j++) {
						answer+=map[i][j]-'0';
					}
					k--;
				}
			}
			System.out.println("#"+t+" "+answer);
		}
	}
}