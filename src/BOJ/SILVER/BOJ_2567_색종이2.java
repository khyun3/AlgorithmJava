package BOJ.SILVER;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BOJ_2567_색종이2 {
	static int N, MAX=0, MAY=0, cnt=0;
	static int [][] map;
	static int [] X, Y, dr = {-1,1,0,0}, dc = {0,0,-1,1};
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		X = new int[N];
		Y = new int[N];
		for (int i = 0; i < N; i++) {
			
			X[i] = sc.nextInt();	//열
			Y[i] = sc.nextInt();	//행
			
			MAX = Math.max(MAX, X[i]);
			MAY = Math.max(MAY, Y[i]);
		}
		map = new int [MAY+11][MAX+11];	//bfs돌릴때 모든 색종이에 태두리가 생기게 하고싶을 때+1
		
		//도화지에 색종이를 붙이자.
		for (int i = 0; i < N; i++) {
			for (int j = Y[i]; j < Y[i]+10; j++) {
				for (int k = X[i]; k < X[i]+10; k++) {
					map[j][k] = 1;
					//if(j == Y[i] || j==Y[i]+9 || k==X[i] || k==X[i]+9 )	//테두리만 배열에 넣기
						//map[j][k] = 1;
				}
			}
		}
		//도화지의 빈칸을 탐색하자.
		for (int i = 0; i < N; i++)
			for (int j = 0; j < Y[i]+10; j++)
				for (int k = 0; k < X[i]+10; k++) {
					if(map[j][k] == 0) { 	
						bfs(j,k);
						print();
						System.out.println(cnt);
					}
				}
		System.out.println(cnt);
		
	}
	static void print() {
		System.out.println();
		for (int i = 0; i < MAY+11; i++) {
			for (int j = 0; j < MAX+11; j++) {
			//	if(map[i][j] == 0) System.out.print("  ");
			//	else
					System.out.print(map[i][j]+" ");
				
			}
			System.out.println();
		}
	}

	static void bfs(int r, int c) {
		Queue<int []> que = new LinkedList<>();
		que.offer(new int[] {r, c});
		map[r][c] = 9;//중요함
		
		while(!que.isEmpty()) {
			int [] curr = que.poll();
			for (int i = 0; i < 4; i++) {
				int nr = curr[0] + dr[i]; 
				int nc = curr[1] + dc[i];
				
				if(!check(nr,nc)) continue;
				if(map[nr][nc] == 0) {
					map[nr][nc] = 9;//더 중요함
					que.offer(new int[] {nr,nc});
				}
				if(map[nr][nc] == 1){
					cnt++;
				}
				
			}
		}
	}
	private static boolean check(int nr, int nc) {
		if(nr>=0 && nc>=0 && nr<MAY+11 && nc<MAX+11) return true; //여기도 중요함
		return false;
	}
}
/*        
 * 		  1 1 1 1 1 1 1 1 1 1                       
          1                 1                       
          1                 1                       
          1                 1                       
          1                 1                       
      1 1 1 1 1 1 1 1 1 1   1 1 1 1 1 1 1 1 1 1 1   
      1   1             1   1 1                 1   
      1   1             1   1 1                 1   
      1   1             1   1 1                 1   
      1   1 1 1 1 1 1 1 1 1 1 1                 1   
      1                 1     1                 1   
      1                 1     1                 1   
      1                 1 1 1 1 1 1 1 1 1 1 1   1   
      1                 1 1   1             1   1   
      1 1 1 1 1 1 1 1 1 1 1   1 1 1 1 1 1 1 1 1 1   
                          1                 1       
                          1                 1       
                          1                 1       
                          1                 1       
                          1                 1       
                          1                 1       
                          1 1 1 1 1 1 1 1 1 1  
 * */