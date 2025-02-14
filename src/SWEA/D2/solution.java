package SWEA.D2;

import java.util.Scanner;

public class solution {
	static int T,N;
	static int [][][] ro;
	public static void main(String[] args)throws Exception {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb;
		T = sc.nextInt();
		
		for (int t = 1; t <= T; t++) {
			sb = new StringBuilder();
			sb.append("#").append(t).append("\n");
			N = sc.nextInt();
			ro = new int [4][N][N];
			
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					ro[0][i][j] = sc.nextInt();	
				}
			}
			rotate(ro,1);
			for (int i = 0; i <N; i++) {
				for (int j = 1; j <=3; j++) {
					for (int k = 0; k < N; k++) {
						sb.append(ro[j][i][k]);
					}
					sb.append(" ");
				}
				sb.append("\n");
			}
			System.out.print(sb.toString());
		}
	}
	static void rotate(int [][][] a, int cnt) {
		if(cnt == 4) return;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {//�뿴�쓽 �겕湲곕�� 90,180,270�룄 �겕湲곕줈				
				a[cnt][i][j] = a[cnt-1][N-1-j][i];
			}
		}
		rotate(a, cnt+1);
	}
}