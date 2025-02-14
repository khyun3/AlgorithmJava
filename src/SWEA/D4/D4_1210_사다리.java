package SWEA.D4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class D4_1210_사다리 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st =null;
		int R = 0;	//현재 행
		int C = 0;	//현재 열
		
		int [][] map = new int [100][100];
		for (int t = 1; t <= 10; t++) {
			R = 0;
			C = 0;
			String T = br.readLine();
			for (int i = 0; i < map.length; i++) {
				st = new StringTokenizer(br.readLine()," ");
				for (int j = 0; j < map.length; j++) {
					map[100-1-i][j] = Integer.parseInt(st.nextToken());
				}
			}
			for (int i = 0; i < map.length; i++) {
				for (int j = 0; j < map.length; j++) {
					
					if(i == 0) {	//0행의 2를 찾음 찾아서 열(C)에 넣어줌
						if(map[0][j] == 2) {
							C = j;
							break;
						}
						else {
							continue;
						}
					}
						if(C>0 && map[R][C-1] == 1) {//좌로 분기
							map[R][C-1] = 5;	//분기하기 전에 해당 행렬에 지나간다는 표시를 해둠
							C--;
						}
						if(C < 99 && map[R][C+1] == 1) {//우로 분기
							map[R][C+1] = 5;
							C++;
						}
						if(R < 99 && map[R+1][C] == 1) {//아래로 분기
							map[R+1][C] = 5;
							R++;	
						}
				}
			}
			System.out.println("#"+t+" "+ C);
		}
	}
}
