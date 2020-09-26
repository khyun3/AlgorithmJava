package SILVER;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2630_색종이만들기 {
	static int N, blue=0, white=0;
	static int[][] map;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		
		map = new int[N][N];
		
		for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		//입력 끝
		//print();
		coloredPaper(0,0,N); //r,c,w
		System.out.println(white);
		System.out.println(blue);
	}
	private static void coloredPaper(int nr, int nc, int s) {
		if(s==1) {                      //만약에 1칸까지 왔으면
			if(map[nr][nc]==0) white++; //색별로 ++
			else blue++;
			return;
		}
		boolean check = true;
		L:for (int i = 0; i < s; i++) { //S너비 만큼의 색종이가 같은색인가?
			for (int j = 0; j < s; j++) {
				if(map[nr][nc] != map[nr+i][nc+j]) {
					check = false;
					break L;
				}
				if(i==(s-1) && j==(s-1) && check) { //for문이 끝까지 돌았을 때
					if(map[nr][nc] == 0) white++;   //흰색인가? 아니면 하늘색인가?
					else blue++;
				}
			}
		}
		int w = s/2;
		if(!check) {
			coloredPaper(nr, nc, w);
			coloredPaper(nr, nc+w, w);
			coloredPaper(nr+w, nc, w);
			coloredPaper(nr+w, nc+w, w);
		}
	}
// 	static void print() {
// 		for (int i = 0; i < map.length; i++) {
// 			for (int j = 0; j < map.length; j++) {
// 				System.out.print(map[i][j]+" ");
// 			}	
// 			System.out.println();
// 		}
// 		System.out.println();
// 	}
}
