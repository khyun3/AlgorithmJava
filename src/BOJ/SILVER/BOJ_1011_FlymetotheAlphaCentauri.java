package BOJ.SILVER;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1011_FlymetotheAlphaCentauri {
	public static void main(String[] args)throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();
		
		//k-1, k, k+1로 이동 가능
		int T = Integer.parseInt(br.readLine());
		int x, y, dist;
		for (int t = 0; t < T; t++) {
			st = new StringTokenizer(br.readLine()," ");
			x = Integer.parseInt(st.nextToken());
			y = Integer.parseInt(st.nextToken());
			
			//이동해야 하는 거리
			dist = y-x;
			if(dist==1) sb.append(1);
			else if(dist==2) sb.append(2);
			else {
				double dRoot = Math.sqrt(dist);
				//정수 부분
				double k = Math.floor(dRoot);
				//소수 부분(decimal fraction)
				double df = dRoot - k;
				
				//소수 부분이 0.5 이상
				if(df >= 0.5)  
					sb.append((int)(2*k+1));
				
				//정수로 딱 맞아떨어지는 거리라면 (4, 9, 16 ...)
				else if(df==0) 
					sb.append((int)(2*k-1));
				
				//소수 부분이 0.5이하 
				else 		   
					sb.append((int)(2*k));
			}
			sb.append("\n");
		}
		System.out.print(sb);
	}
}
