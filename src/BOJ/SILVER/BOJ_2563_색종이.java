package BOJ.SILVER;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_2563_색종이 {
	static int N, cnt=0;
	static List<int []> list = new ArrayList<>();	//좌표 저장
	static int [][] map;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		map = new int [100][100];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine()," ");
			int r = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
		
			for (int j = 0; j < 10; j++) { //도화지에 색종이를 붙이자
				for (int k = 0; k < 10; k++) {
					map[r+j][c+k] = 1;
				}
			}
		}
		for (int i = 0; i < 100; i++) {
			for (int j = 0; j < 100; j++) {
				if(map[i][j] == 0) continue;
				cnt++;
			}
		}
		System.out.println(cnt);
	}
}