package D4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class D4_8382_방향전환_방법2 {
	static int answer;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());

		for (int t = 1; t <= T; t++) {
			int xy[] = new int[4];
			answer = 0;
			st = new StringTokenizer(br.readLine(), " ");
			for (int i = 0; i < 4; i++) {
				xy[i] = Integer.parseInt(st.nextToken());
			}
			if(xy[0]==xy[2] && xy[1]==xy[3]) answer = 0;
			else solve(xy);
			
			sb.append("#").append(t).append(" ").append(answer).append("\n");
		}
		System.out.print(sb);
	}
	private static void solve(int[] xy) {
		//가로 세로 차이가 더 작은거를 구함
		int xdist = Math.abs(xy[0] - xy[2]);
		int ydist = Math.abs(xy[1] - xy[3]);
		if(xdist==ydist) {//같을 때
			answer = xdist*2;
		}
		else {
			//대각방향으로 내려갈 수 있는 최대를 구한다.
			answer += Math.min(xdist, ydist)*2;
			//나머지 가야하는 부분을 더해준다.
			int dist = Math.abs(xdist - ydist);
			answer +=4*(dist/2);
			if(dist%2!=0) {
				answer +=1;
			}
		}
	}
}