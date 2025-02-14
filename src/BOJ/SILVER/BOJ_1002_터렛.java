package BOJ.SILVER;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1002_터렛 {
	public static void main(String[] args)throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = null;
		
		int T = Integer.parseInt(br.readLine());
		
		//x1,y1,r1,x2,y2,r2
		double [] in = new double [6]; 
		
		for (int i = 0; i < T; i++) {
			st = new StringTokenizer(br.readLine()," ");
			for (int j = 0; j < 6; j++) {
				in[j] = Double.parseDouble(st.nextToken());
			}
			//1번 원  중심좌표 : (x1,y1), 반지름 : r1
			//2번 원  중심좌표 : (x2,y2), 반지름 : r2
			
			//d = 두 중심좌표사이 거리
			double d = Math.sqrt(Math.pow(in[0]-in[3],2)+Math.pow(in[1]-in[4],2));

			//r+r'
            double ins = in[2]+in[5];
            
            //|r-r'|
			double cir = Math.abs(in[2]-in[5]);
			
			//두 점사이의 거리가 0이고 반지름이 같을 때,
			if(d==0 && in[2]==in[5]){
				sb.append("-1\n");
			}
            //두 점에서 만나는 경우
            //(|r1 - r2| < d) && (r1 + r2 > d)
			else if(cir < d && ins > d){
				sb.append("2\n");
            }
			//한 점에 만나는 경우(외접, 내접)
			//r1 + r2 = d || |r1-r2| = d
			else if(ins==d || cir==d){
				sb.append("1\n");
			}
            //만나지 않는 경우
			else{
				sb.append("0\n");
            }
		}
		System.out.println(sb);
	}
}
