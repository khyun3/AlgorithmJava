package D4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class D4_5644_무선충전3 {
	static int M, aCnt;//시간, 충전소개수
	static int[] pathA, pathB, playerA, playerB;
	static int [][] ap;
	
	static int [] dx = {0,0,1,0,-1};
	static int [] dy = {0,-1,0,1,0};
	
	public static void main(String[] args)throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int TC = Integer.parseInt(br.readLine());
		
		StringTokenizer st = null;
		playerA = new int [2]; //위치
		playerB = new int [2]; //위치
		
		for (int t = 1; t<=TC; t++) {
			st = new StringTokenizer(br.readLine()," ");
			M = Integer.parseInt(st.nextToken());
			aCnt = Integer.parseInt(st.nextToken());
			
			//두 플레이어 초기위치
			playerA[0] = playerA[1] = 1;
			playerB[0] = playerB[1] = 10;
			
			pathA = new int [M+1]; //0초부터(출발위치부터)
			pathB = new int [M+1];
			ap = new int[aCnt][4];
			
			String charsA = br.readLine();
			String charsB = br.readLine();
			
			for (int c = 0; c < M; c++) {
				pathA[c+1] = charsA.charAt(c*2)-'0';
				pathB[c+1] = charsB.charAt(c*2)-'0';
			}
			
			for (int a = 0; a < aCnt; a++) {
				st = new StringTokenizer(br.readLine()," ");
				ap[a][0] = Integer.parseInt(st.nextToken()); //x
				ap[a][1] = Integer.parseInt(st.nextToken()); //y
				ap[a][2] = Integer.parseInt(st.nextToken()); //c
				ap[a][3] = Integer.parseInt(st.nextToken()); //p
			}
			System.out.println("#"+t+" "+move());
		}
	}

	private static int move() {
		int totalSum = 0;
		int time = 0;
		while(time<=M) {
			//두 플레이어를 히댕 시간의 이동정보에 맞게 이동
			playerA[0] +=dx[pathA[time]];
			playerA[1] +=dy[pathA[time]];
			playerB[0] +=dx[pathB[time]];
			playerB[1] +=dy[pathB[time]];
			
			totalSum += getCharge();
			++time;
		}
		return totalSum;
	}

	private static int getCharge() {
		int max = 0;
		for (int a = 0; a < aCnt; a++) {
			for (int b = 0; b < aCnt; b++) {
				int sum = 0;
				int amountA = check(a,playerA[0],playerA[1]);
				int amountB = check(b,playerB[0],playerB[1]);
				if(a != b) sum = amountA + amountB;
				else sum = Math.max(amountA, amountB);
				
				if(max<sum) max = sum;
			}
		}
		return max;
	}
	//x,y좌표에서 a 충전소에 충전이 가능한지 판단하여 충전가능하다면 충전량 리턴, 아니면 0 리턴
	private static int check(int a, int x, int y) {
		return Math.abs(ap[a][0]-x) + Math.abs(ap[a][1]-y) <= ap[a][2] ? ap[a][3] : 0;
	}
}
