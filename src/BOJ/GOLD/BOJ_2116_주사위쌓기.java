package BOJ.GOLD;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_2116_주사위쌓기 {
	
	static int N, max=0;
	static int[][] dice;
	public static void main(String[] args)throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		dice = new int [N][6]; //주사위들을 저장
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine()," ");
			for (int j = 0; j < 6; j++) {
				dice[i][j] = Integer.parseInt(st.nextToken());
			}
		}//입력 끝
		
		
		//바텀과 탑을 가지고 있을 변수
		//1번 주사위의 바텀을 0~6까지 다 해보자
		for (int i = 0; i < 6; i++) {
			int bottom = 0, top = 0, maxTmp=0;
			bottom = dice[0][i];
			top = select(i, 0);
			maxTmp += findMaxVal(bottom, top, 0);
			
			//이제 1번 주사위의 바텀과 탑이 정해졌으니 이제 
			//2 주사위부터 맞춰서 탑과 바텀을 구하자
			for (int j = 1; j < N; j++) {
				bottom = top;
				
				//바텀이 몇번째인지 찾아서 top를 구해온다.
				for (int k = 0; k < 6; k++) {
					if(dice[j][k]==bottom) {
						top = select(k,j);
					}
				}
				maxTmp += findMaxVal(bottom, top, j);//남은 가장 큰 수를 구해온다.
			}
			max = Math.max(maxTmp, max);
		}
		System.out.println(max);
	}
	static int findMaxVal(int bottom, int top, int j) {
		int tmp = 0;
		for (int i = 0; i < 6; i++) {
			if(dice[j][i]==bottom || dice[j][i]==top) continue;
			tmp = Math.max(dice[j][i], tmp);
		}
		return tmp;
	}
	
	static int select(int i, int k) {//
		//주사위의 바텀이 정해졌으면 탑을 정하자.
		switch(i) {
		case 0:
			return dice[k][5];
		case 1:
			return dice[k][3];
		case 2:
			return dice[k][4];
		case 3:
			return dice[k][1];
		case 4:
			return dice[k][2];
		case 5:
			return dice[k][0];
		}
		return -1;
	}
}