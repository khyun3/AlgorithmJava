package D3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class D3_9280_진용이네주차타워 {
	
	static int T, N, M, answer;
	static int input;
	static Queue<Integer> in = new LinkedList<Integer>();
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		T = Integer.parseInt(br.readLine());
		for (int t = 1; t <=T; t++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			answer = 0;
			int [][] parkingLot = new int[N][2];	
			int [][] cars = new int[M][2];
			for (int i = 0; i < parkingLot.length; i++) {
				parkingLot[i][0] = Integer.parseInt(br.readLine());
			}
			for (int i = 0; i < cars.length; i++) {
				cars[i][0] = Integer.parseInt(br.readLine());
				cars[i][1] = i+1;
				System.out.println(cars[i][0] +"  " +cars[i][1]);
			}
			for (int i = 0; i < M*2; i++) {
				input = Integer.parseInt(br.readLine());
				if(input > 0) {
					for (int j = 0; j < N; j++) {
						if(parkingLot[j][1] == 0) {
							parkingLot[j][1] = cars[input-1][1];
							break;
						}
						if(j == N-1) {	//가득 차면
							in.offer(input);
						}
					}
				}
				else {
					for (int j = 0; j < N; j++) {
						if(parkingLot[j][1] == cars[Math.abs(input)-1][1]) {
							answer += parkingLot[j][0]*cars[Math.abs(input)-1][0];
							parkingLot[j][1] = 0;
							
							if(!in.isEmpty()) {
								for (int k = 0; k < N; k++) {
									if(parkingLot[k][1] == 0) {
										parkingLot[k][1] = cars[in.poll()-1][1];
									}
								}
							}
							break;
						}
					}
				}
			}

			System.out.println("#"+t+" "+answer);
		}
	}
}