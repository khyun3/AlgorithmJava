package SILVER;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1074_Z {
	static int N, R, C, answer=0;
	private static int[][] map;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		map = new int [2*N][2*N];
		divNCon(0,0,1<<N); // 1<<(N) == 2^N		
	}
	
	private static void divNCon(int nr, int nc, int s) {
		if(s==1) {
			//if(nr<2*N && nc<2*N)
			map[nr][nc] = answer+1;
			print();
			if(nr==R && nc==C) {
				System.out.println(answer);
			}
			answer++;
			return ;
		}
		int w = s/2;
		System.out.println(w+"  "+nr+"  "+nc);
		divNCon(nr,nc,w);		// O X
								// X X
		
		divNCon(nr,nc+w,w);		// X O
								// X X
		
		divNCon(nr+w,nc,w);		// X X
								// O X
		
		divNCon(nr+w,nc+w,w);	// X X
								// X O
	}
	static void print() {
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map.length; j++) {
				System.out.print(map[i][j]+"\t");
			}
			System.out.println();
		}
		System.out.println();
	}
}
