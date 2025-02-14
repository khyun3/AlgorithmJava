package BOJ.BRONZE;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Hashtable;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class BOJ_18111_마인크래프트 {
	static int size;
	static int [] answer = {Integer.MAX_VALUE, 0};//시간, 높이
	public static void main(String[] args)throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		
		int N = Integer.parseInt(st.nextToken()); //세로
		int M = Integer.parseInt(st.nextToken()); //가로
		int B = Integer.parseInt(st.nextToken()); //인벤 블록 수
		
		size = N*M;
		int [] height = new int[257];
		int max = 0;
		int min = Integer.MAX_VALUE;
		
		//각 땅의 높이 입력받기
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine()," ");
			for (int j = 0; j < M; j++) {
				int h = Integer.parseInt(st.nextToken());
				height[h]++;
				max = Math.max(max, height[i]);
				min = Math.min(min, height[i]);
			}
		}
		
		System.out.println(min+" "+max);
		
		dfs(height, min, max, 0); //높이 테이블과 최소, 최대, 시간
	}

	private static void dfs(int [] h, int min, int max, int time) {
		if(h[min]==size) {
			if(answer[0]==time) {
				answer[1] = Math.max(answer[1], min);
			}
			else {
				if(answer[0]>time) {
					answer[0] = time;
					answer[1] = min;
				}
			}
			return;
		}
		//가장 높은 친구를 때려 부신다.
		
		
		//가장 낮은 친구에 블럭을 둔다.
		
		
		//return 0;
	}
}
