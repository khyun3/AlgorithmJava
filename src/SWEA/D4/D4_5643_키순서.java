package SWEA.D4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class D4_5643_키순서 {

		static int N, M;
		public static void main(String[] args)throws Exception {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			StringTokenizer st = null;
			
			int T = Integer.parseInt(br.readLine());
			
			for (int t = 1; t <= T; t++) {
				N = Integer.parseInt(br.readLine());
				M = Integer.parseInt(br.readLine());
				
				int [][] d = new int [N][N]; //distance
				
				int answer = 0;
				
				for (int i = 0; i < M; i++) {
					st = new StringTokenizer(br.readLine()," ");
					d[Integer.parseInt(st.nextToken())-1][Integer.parseInt(st.nextToken())-1] = 1;
				}
				
				//플로이드 와샬
				//플로이드 와샬 알고리즘 Dij(K) ==> i에서 j로 갈 때, 어떤 K(경유 집합)을 지나가면 최소 비용으로 지나갈 수 있는가?
				//알고리즘의 점화식
				//dij(k) | 					Wij				  k=0 |
				//		 | min(Dij(k-1), Dik(k-1) + Dkj(k-1)) k>1 |	
				//	              기존 i->j 경로의 값과 i -> k -> j값 중 더 작은 값을 해당 i->j의 최소값으로 넣는다.
				
				for (int k = 0; k < N; k++) { //경유 정점
					for (int i = 0; i < N; i++) { //출발 정점
						for (int j = 0; j < N; j++) { //도착 정점
							if(i==j) continue;
							if(d[i][k]==1 && d[k][j]==1) {  //i<k<j 인가?
								d[i][j] = k+1; //i<k<j 가 맞다.
								print(k+1,i+1,j+1,d);
							}
						}
					}
				}
				
				for (int i = 0; i < N; i++) {
					boolean check = true;
					for (int j = 0; j < N; j++) {
						if(i!=j && d[i][j]==0 && d[j][i]==0)//i점이 다른 모든 점에 대해 크기 비교를 명확히 할 수 있는가?
							check = false;
					}
					if(check) answer++;//그러한 정점의 개수를 구한다.
				}
				System.out.println("#"+t+" "+answer);
			}
		}
		private static void print(int a, int b, int c, int[][] mtrx) {
			System.out.println("===============");
			System.out.println("출발지 : "+b+"  경유지 : "+a+"  도착지 : "+c +"  ==>  ("+ b+" < "+a+" < "+c+")");
			for (int j = 0; j < mtrx.length; j++) {
				for (int i = 0; i < mtrx.length; i++) {
					System.out.print(mtrx[j][i]+" ");
				}
				System.out.println();
			}
		}
	}