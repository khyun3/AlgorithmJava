package SWEA.D4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class D4_1226_미로1_bfs {
	static int T = 10, N, size = 16;
	static char [][] map;
	static int [] R = {-1,1,0,0};
	static int [] C = {0,0,-1,1};
	static boolean answer;
	public static void main(String[] args)throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		for (int t = 1; t <= 10; t++) {
			N = Integer.parseInt(br.readLine().trim());
			map = new char[size][size];
			int sr=0, sc=0;
			answer = false;
			for (int i = 0; i < size; i++) {
				map[i] = br.readLine().toCharArray();
				for (int j = 0; j < size; j++) {
					if(map[i][j]=='2') {
						sr = i;
						sc = j;
					}
				}  
			}
			bfs(sr,sc);
			
			if(answer)
				System.out.println("#"+t+" 1");
			else
				System.out.println("#"+t+" 0");
		}
	}
	private static void bfs(int sr, int sc) {
		//Queue<>
		for (int i = 0; i < 4; i++) {	//4방 검사 할 거임
			int snr = sr+R[i];
			int snc = sc+C[i];

		}
	}
	private static boolean check(int snr, int snc) {
		if(0<=snr&& 0<=snc && snr<size && snc<size)
			return true;
		return false;
	}
}