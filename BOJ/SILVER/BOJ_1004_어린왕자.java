package SILVER;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1004_어린왕자 {
	public static void main(String[] args)throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = null;
		
		int T = Integer.parseInt(br.readLine());
		
		for (int t = 0; t < T; t++) {
			st = new StringTokenizer(br.readLine()," ");
			
			//출발점, 도착점 입력받기
			double x1 = Double.parseDouble(st.nextToken()); 
			double y1 = Double.parseDouble(st.nextToken());
			double x2 = Double.parseDouble(st.nextToken());
			double y2 = Double.parseDouble(st.nextToken());
			
			//행성계 개수 n 입력받기
			int N = Integer.parseInt(br.readLine());
			int ans = 0;

			//Planetary system
			//ps[][0] = cx, ps[][1] = cy, ps[][2] = r
			double [][] ps = new double [N][3];
			
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine()," ");
				ps[i][0] = Double.parseDouble(st.nextToken());
				ps[i][1] = Double.parseDouble(st.nextToken());
				ps[i][2] = Double.parseDouble(st.nextToken());
				
				//해당 행성계가 꼭 지나가야 하는지 확인하기
				int check = 0;
				check+=check(x1,y1, ps[i]);
				check+=check(x2,y2, ps[i]);
				if(check==1) ans++;
			}
			sb.append(ans).append("\n");
		}
		System.out.print(sb);
	}
	static public int check(double x, double y, double [] ps) {
		double d = EuclideanDistance(x, ps[0], y, ps[1]);
		//해당 행성계 내부에 출발점/도착점이 존재하는가?
		return d<ps[2] ? 1 : 0;
	}
	static double EuclideanDistance(double x, double cx, double y, double  cy) {
		//sqrt((x-cx)^2 + (y-cy)^2) 
		return Math.sqrt(Math.pow(x-cx, 2) + Math.pow(y-cy, 2));
	}
}