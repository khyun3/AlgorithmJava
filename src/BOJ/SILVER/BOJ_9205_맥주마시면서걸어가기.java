package BOJ.SILVER;

import java.util.Scanner;

public class BOJ_9205_맥주마시면서걸어가기 {
	
	static int T, N;          //테케, 편의점 수
	static int[] cx,cy; 	  //좌표
	static boolean[][] d;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		T = sc.nextInt();
		
		for (int t = 0; t < T; t++) {
            String answer = "happy";
			N = sc.nextInt();
			cx = new int[N+2];
			cy = new int[N+2];
			
			//거리 인접행렬(1000업? 다운?)
			d = new boolean [N+2][N+2];
			
			//좌표받아오기
			for (int i = 0; i < N+2; i++) {
				cx[i] = sc.nextInt(); //다음 좌표x
				cy[i] = sc.nextInt(); //다음 좌표y
			}
			FW();
			
			if(!d[0][N+1]) answer="sad";
			
			System.out.println(answer);
		}	
	}
	private static void FW() {
		//인접행렬 만들기
		for (int i = 0; i < N+2; i++) {
			for (int j = 0; j < N+2; j++) {
					int dist = distance(cx[i], cy[i], cx[j], cy[j]);
					
					if(dist<=1000) {
						d[i][j] = true;
					}
				}
		}
		
		//플로이드 와샬
		for (int k = 0; k < N+2; k++) { //경유
			for (int i = 0; i < N+2; i++) { //출발
				for (int j = 0; j < N+2; j++) { //도착
					if(!d[i][j])					//출발i->도착j 거리가 1000이상이라면
						if(d[i][k] && d[k][j])	    //출발i->경유k && 경유k->도착j 경유해서 1000아래로 도착 가능?
							d[i][j] = true;			//출발i->도착j 경유지들을 거쳐서 1000아래로 도착 ok
				}
			}
		}
	}
	private static int distance(int x1, int y1, int x2, int y2) {
		//거리 구하기
		return Math.abs(x1 - x2) + Math.abs(y1 - y2);
	}
}