package BOJ.BRONZE;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2669_직사각형네개의합집합의면적구하기 {
	static int[][] map;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int r1=0,r2=0,c1=0,c2=0,cnt=0;
		map=new int [101][101];
		
		for (int i = 0; i < 4; i++) {
			st = new StringTokenizer(br.readLine()," ");
			c1 = Integer.parseInt(st.nextToken());
			r1 = Integer.parseInt(st.nextToken());
			c2 = Integer.parseInt(st.nextToken());
			r2 = Integer.parseInt(st.nextToken());

			for (int r = r1; r < r2; r++) {
				for (int c = c1; c < c2; c++) {
					if(map[r][c]==0) {
						map[r][c] = 1;
						cnt++;
					}
				}
			}
			
		}
		System.out.println(cnt);
	}
}