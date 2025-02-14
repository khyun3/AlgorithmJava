package SWEA.D4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class D4_4014_활주로건설 {
	
	static int N, X, map[][], count;
	public static void main(String[] args)throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		int T = Integer.parseInt(br.readLine());
		
		for (int t = 1; t <= T; t++) {
			st = new StringTokenizer(br.readLine()," ");
			N = Integer.parseInt(st.nextToken()); //지형의 크기
			X = Integer.parseInt(st.nextToken()); //경사로 길이
			
			map = new int [N][N];
			count = 0;
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine()," ");
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			process();
			System.out.println("#"+t+" "+count);
		}
	}
	private static void process() {
		for (int i = 0; i < N; i++) {
			if(makeRoad(i)) ++ count;
		}
	}
	//행단위 활주로 건설
	private static boolean makeRoad(int i) {
		int beforeHeight, size; //이전칸의 높이, 평탄한 지현의 길이
		beforeHeight = map[i][0];
		size = 1;
		
		for (int j = 0; j < N; j++) {
			
			//1. 이전칸과 현재칸의 높이가 같은지
			if(beforeHeight == map[i][j]) {
				++size;
			}
			
			//2. 현재칸이 이전칸보다 높이가 1 높은 경우(오르막 경사로 설치 가능한지 체크)
			else if(beforeHeight+1==map[i][j]) {
				if(size<X) return false; //활주로 건설 불가
				beforeHeight++;
				size = 1; //새로운 높이의 평탄한 지형 길이 1부터 시작
			}
			//3. 현재칸이 이전칸보다 높이가 1 낮은 경우(내리막 경사로 설치 가능한지 체크)
			else if(beforeHeight-1==map[i][j]) {
				int count = 0;
				
				for (int k = j; k < N; k++) {
					if(map[i][k] != beforeHeight-1) break;
					count++; //이전칸의 높이와 1차이 낮은 연속된 평탄화 지형의 길이 카운트
				}
				if(count<X) return false; //활주로 건설 불가
				j += X-1;
				beforeHeight--;
				size = 0;
			//4. 높이가 2이상 차이나는 경우
			}
			else
				return false;
		}
		return true;
	}
}
