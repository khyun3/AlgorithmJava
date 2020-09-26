package SILVER;

import java.util.Scanner;

public class BOJ_10157_자리배정 {
	static int C, R, K,Rt=0;
	static int [] dr = {1,0,-1,0};//아래//오른쪽//위쪽//왼쪽
	static int [] dc = {0,1,0,-1};
	static int[][] map;
	static boolean flag;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		C = sc.nextInt(); //가로
		R = sc.nextInt(); //세로
		K = sc.nextInt();
		map = new int[R][C];
		go(0, 0);
		if(!flag) System.out.println(0);
	}

	private static void go(int r, int c) {
		int nr = r;
		int nc = c;
		int cnt = 1;
		if(K==1) { 
			System.out.println(1+" "+1);
			flag=true;
			return;
		}
		map[nr][nc] = cnt++;
		int Rt = R;
		if(R%2==1) Rt+=1;
		for (int i = 0; i < Rt / 2; i++) {
			for (int d = 0; d < 4; d++) {
				while(true) {
					nr += dr[d];
					nc += dc[d];
					if (!check(nr, nc)) {
						nr-=dr[d];
						nc-=dc[d];
						break;
					}
					if (map[nr][nc] != 0) {
						nr-=dr[d];
						nc-=dc[d];
						break;
					}
					map[nr][nc] = cnt;
					if(cnt==K) {
						System.out.println(nc+1+" "+(nr+1));
						flag=true;
						return;
					}
					cnt++;
				}
			}
		}
	}
	private static boolean check(int nr, int nc) {
		if(nr>=0 && nr<R && nc>=0 && nc<C) return true;
		return false;
	}
}